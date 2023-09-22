///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS info.picocli:picocli:4.6.1
//DEPS com.marcnuri.yakc:kubernetes-client:0.0.28
//DEPS com.marcnuri.yakc:kubernetes-api:0.0.28

import com.marcnuri.yakc.KubernetesClient;
import com.marcnuri.yakc.api.ClientErrorException;
import com.marcnuri.yakc.api.discovery.v1beta1.DiscoveryV1beta1Api;
import com.marcnuri.yakc.model.io.k8s.api.batch.v1beta1.CronJob;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.Callable;

@SuppressWarnings("unused")
@Command(
  name = "EndpointSlices",
  mixinStandardHelpOptions = true,
  description = "Examples of Kubernetes EndpointSlices from Java"
)
class EndpointSlices implements Callable<Integer> {
  @SuppressWarnings("java:S115")
  enum Options {
    list, delete
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
    int exitCode = new CommandLine(new EndpointSlices()).execute(args);
    System.exit(exitCode);
  }

  @Override
  public Integer call() throws Exception {
    try (KubernetesClient kc = new KubernetesClient()) {
      switch (action) {
        case delete:
          return delete(kc);
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
    info("List of Endpoints for all Namespaces:");
    kc.create(DiscoveryV1beta1Api.class).listEndpointSliceForAllNamespaces().stream()
      .forEach(endpoint -> {
        info(String.format(" - %s/%s",
          endpoint.getMetadata().getNamespace(),
          endpoint.getMetadata().getName()
        ));
        info(String.format("   %s: %s",
          endpoint.getAddressType(),
          endpoint.getPorts()
        ));
      });
  }

  private int delete(KubernetesClient kc) throws IOException {
    if (params == null || params.length != 1) {
      error("Missing required param <name>");
      return 1;
    }
    final String name = params[0];
    final String applicableNamespace = namespace(kc);
    info("Deleting EndpointSlice " + applicableNamespace + "/" + name);
    kc.create(DiscoveryV1beta1Api.class).deleteNamespacedEndpointSlice(name, applicableNamespace).get();
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
