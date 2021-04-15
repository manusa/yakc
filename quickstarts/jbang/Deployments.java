///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS info.picocli:picocli:4.6.1
//DEPS com.marcnuri.yakc:kubernetes-client:0.0.22
//DEPS com.marcnuri.yakc:kubernetes-api:0.0.22

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.ClientErrorException;
import com.marcnuri.yakc.api.apps.v1.AppsV1Api;
import com.marcnuri.yakc.model.io.k8s.api.apps.v1.Deployment;
import com.marcnuri.yakc.model.io.k8s.api.apps.v1.DeploymentSpec;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.Container;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodSpec;
import com.marcnuri.yakc.model.io.k8s.api.core.v1.PodTemplateSpec;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.LabelSelector;
import com.marcnuri.yakc.model.io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.Callable;

@SuppressWarnings("unused")
@Command(
  name = "Deployments",
  mixinStandardHelpOptions = true,
  description = "Examples of Kubernetes Deployments from Java"
)
class Deployments implements Callable<Integer> {
  @SuppressWarnings("java:S115")
  enum Options {
    list, delete, example, restart
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
    int exitCode = new CommandLine(new Deployments()).execute(args);
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
        case restart:
          return restart(kc);
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
    info("List of Deployments for all Namespaces:");
    kc.create(AppsV1Api.class).listDeploymentForAllNamespaces().stream()
      .map(Deployment::getMetadata)
      .map(ObjectMeta::getName)
      .map(n -> " - " + n)
      .forEach(this::info);
  }

  private void createExample(KubernetesClient kc) throws IOException {
    final String name = "yakc-example-" + new Random().nextInt(999999);
    final String applicableNamespace = namespace(kc);
    final String appName = "yakc-example-deployment";
    info("Creating example Deployment in " + applicableNamespace + " namespace:");
    final Deployment ss = kc.create(AppsV1Api.class).createNamespacedDeployment(applicableNamespace, Deployment.builder()
      .metadata(ObjectMeta.builder().name(name).build())
      .spec(DeploymentSpec.builder()
        .selector(LabelSelector.builder().putInMatchLabels("app", appName).build())
        .replicas(1)
        .template(PodTemplateSpec.builder()
          .metadata(ObjectMeta.builder().putInLabels("app", appName).build())
          .spec(PodSpec.builder()
            .addToContainers(Container.builder()
              .name(name)
              .image("busybox")
              .addToCommand("sh")
              .addToCommand("-c")
              .addToCommand("echo 'Hello YAKC!' && sleep 300")
              .build())
            .addToContainers(Container.builder()
              .name(name+"-2")
              .image("busybox")
              .addToCommand("sh")
              .addToCommand("-c")
              .addToCommand("echo 'Hello YAKC! from second container' && sleep 300")
              .build())
            .build())
          .build())
        .build())
      .build()
    ).get();
    info(" - Deployment " + applicableNamespace + "/" + name + " successfully created!");
    info(" - " + ss.getMetadata().getCreationTimestamp().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
  }

  private int delete(KubernetesClient kc) throws IOException {
    if (params == null || params.length != 1) {
      error("Missing required param <name>");
      return 1;
    }
    final String name = params[0];
    final String applicableNamespace = namespace(kc);
    info("Deleting Deployment " + applicableNamespace + "/" + name);
    kc.create(AppsV1Api.class).deleteNamespacedDeployment(name, applicableNamespace).get();
    return 0;
  }

  private int restart(KubernetesClient kc) throws IOException {
    if (params == null || params.length != 1) {
      error("Missing required param <name>");
      return 1;
    }
    final String name = params[0];
    final String applicableNamespace = namespace(kc);
    final Deployment toPatch = new Deployment();
    toPatch.setSpec(new DeploymentSpec());
    toPatch.getSpec().setTemplate(PodTemplateSpec.builder()
      .metadata(ObjectMeta.builder()
        .putInAnnotations("yakc.marcnuri.com/restartedAt", Instant.now().toString())
        .build())
      .build());
    kc.create(AppsV1Api.class)
      .patchNamespacedDeployment(name, applicableNamespace, toPatch)
      .get();
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
