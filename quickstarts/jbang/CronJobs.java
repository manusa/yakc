///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS info.picocli:picocli:4.6.1
//DEPS com.marcnuri.yakc:kubernetes-client:0.0.20
//DEPS com.marcnuri.yakc:kubernetes-api:0.0.20

import com.marcnuri.yakc.api.ClientErrorException;
import com.marcnuri.yakc.api.batch.v1.BatchV1Api;
import com.marcnuri.yakc.model.io.k8s.api.batch.v1.Job;
import com.marcnuri.yakc.model.io.k8s.api.batch.v1.JobSpec;
import com.marcnuri.yakc.model.io.k8s.api.batch.v1beta1.CronJobSpec;
import com.marcnuri.yakc.model.io.k8s.api.batch.v1beta1.JobTemplateSpec;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Container;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodSpec;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodTemplateSpec;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.OwnerReference;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.Callable;

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.batch.v1beta1.BatchV1beta1Api;
import com.marcnuri.yakc.model.io.k8s.api.batch.v1beta1.CronJob;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;

@SuppressWarnings("unused")
@Command(
  name = "CronJobs",
  mixinStandardHelpOptions = true,
  description = "Examples of Kubernetes CronJobs from Java"
)
class CronJobs implements Callable<Integer> {
  @SuppressWarnings("java:S115")
  enum Options {
    list, delete, trigger, example
  }

  @CommandLine.Option(names = {"-ns", "--namespace"})
  private String namespace;

  @Parameters(index = "0", description = "The action to perform: ${COMPLETION-CANDIDATES}")
  private Options action;

  @Parameters(index="1..*")
  private String[] params;

  @CommandLine.Spec
  CommandLine.Model.CommandSpec spec;


  public static void main(String... args) {
    int exitCode = new CommandLine(new CronJobs()).execute(args);
    System.exit(exitCode);
  }

  @Override
  public Integer call() throws Exception {
    try (KubernetesClient kc = new KubernetesClient()) {
      switch (action) {
        case example:
          createExample(kc);
          break;
        case delete:
          return delete(kc);
        case trigger:
          return trigger(kc);
        case list:
        default:
          list(kc);
          break;
      }
    } catch (ClientErrorException ex) {
      error(ex.getClass().getSimpleName()+ ": " + ex.getMessage());
      return 1;
    }
    return 0;
  }

  private void list(KubernetesClient kc) throws IOException {
    info("List of CronJobs for all Namespaces:");
    kc.create(BatchV1beta1Api.class).listCronJobForAllNamespaces().stream()
      .map(CronJob::getMetadata)
      .map(ObjectMeta::getName)
      .map(n -> " - " + n)
      .forEach(this::info);
  }

  private void createExample(KubernetesClient kc) throws IOException {
    final String name = "yakc-example-" + new Random().nextInt(999999);
    final String applicableNamespace = namespace(kc);
    info("Creating example CronJob in " + applicableNamespace + " namespace:");
    final CronJob cj = kc.create(BatchV1beta1Api.class).createNamespacedCronJob(applicableNamespace,CronJob.builder()
      .metadata(ObjectMeta.builder().name(name).build())
      .spec(CronJobSpec.builder()
        .schedule("*/1 * * * *")
        .jobTemplate(JobTemplateSpec.builder()
          .spec(JobSpec.builder()
            .template(PodTemplateSpec.builder()
              .spec(PodSpec.builder()
                .restartPolicy("OnFailure")
                .addToContainers(Container.builder()
                  .name(name)
                  .image("busybox")
                  .addToCommand("sh")
                  .addToCommand("-c")
                  .addToCommand("echo 'Hello YAKC!' && sleep 30")
                  .build())
                .build())
              .build())
            .build())
          .build())
        .build())
      .build()).get();
    info(" - CronJob " + applicableNamespace + "/" + name + " successfully created!");
    info(" - " + cj.getMetadata().getCreationTimestamp().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
  }

  // https://github.com/kubernetes/kubernetes/blob/ff4234720d4ec390ca6f6aac4c19a21ba6661841/staging/src/k8s.io/kubectl/pkg/cmd/create/create_job.go#L263
  private int trigger(KubernetesClient kc) throws IOException {
    if (params == null || params.length != 1) {
      error("Missing required param <name>");
      return 1;
    }
    final String name = params[0];
    final String applicableNamespace = namespace(kc);
    info("Triggering CronJob " + applicableNamespace + "/" + name);
    final CronJob cronJob = kc.create(BatchV1beta1Api.class).readNamespacedCronJob(name, applicableNamespace).get();
    final JobTemplateSpec jts = cronJob.getSpec().getJobTemplate();
    final String jobName = String.format("%s-manual-%s",
      name.length() > 38 ? name.substring(0, 38) : name,
      new Random().nextInt(999999)
    );
    kc.create(BatchV1Api.class).createNamespacedJob(applicableNamespace, Job.builder()
      .metadata(ObjectMeta.builder()
        .name(jobName).namespace(applicableNamespace)
        .labels(new HashMap<>(Optional.ofNullable(cronJob.getMetadata().getLabels()).orElse(Collections.emptyMap())))
        .putInAnnotations("cronjob.kubernetes.io/instantiate", "manual")
        .addToOwnerReferences(OwnerReference.builder()
          .kind(cronJob.getKind())
          .apiVersion(cronJob.getApiVersion())
          .controller(false)
          .name(cronJob.getMetadata().getName())
          .uid(cronJob.getMetadata().getUid())
          .build())
        .build())
      .spec(jts.getSpec())
      .build()).get();
    info(" - Created manual Job: " + jobName);
    return 0;
  }

  private int delete(KubernetesClient kc) throws IOException {
    if (params == null || params.length != 1) {
      error("Missing required param <name>");
      return 1;
    }
    final String name = params[0];
    final String applicableNamespace = namespace(kc);
    info("Deleting CronJob " + applicableNamespace + "/" + name);
    kc.create(BatchV1beta1Api.class).deleteNamespacedCronJob(name, applicableNamespace).get(CronJob.class);
    return 0;
  }

  private String namespace(KubernetesClient kc) {
    if (namespace != null) {
      return namespace;
    }
    return Optional.ofNullable(kc.getConfiguration().getNamespace()).orElse("default");
  }

  private void info(String info) {
    spec.commandLine().getOut().println("[YAKC] " + info);
  }

  private void error(String error) {
    spec.commandLine().getErr().println(spec.commandLine().getColorScheme().errorText("[YAKC] " + error));
  }
}
