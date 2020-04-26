# Top for Nodes 

This example features a Top implementation to retrieve resource usage for a given Node and its Pods.

The example execution will print a list of Pod Containers within a node and the amount of CPU and
Memory they've allocated and are using.

The report ends with a list of the total resources used in the provided Node.

## How to run

In order to run the example you need an active K8s cluster
(e.g. [Minikube](https://kubernetes.io/docs/setup/learning-environment/minikube/)).

In the project quick start directory, run `mvn package`:

```shell script
$ mvn package
[INFO] Scanning for projects...
[INFO]
[INFO] --------------< com.marcnuri.yakc.quickstarts:top-nodes >---------------
[INFO] Building YAKC :: Quickstarts :: Top Nodes 0.0.3
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ top-nodes ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory D:\00-MN\projects\manusa\yakc\quickstarts\top-nodes\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ top-nodes ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding Cp1252, i.e. build is platform dependent!
[INFO] Compiling 1 source file to D:\00-MN\projects\manusa\yakc\quickstarts\top-nodes\target\classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ top-nodes ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory D:\00-MN\projects\manusa\yakc\quickstarts\top-nodes\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ top-nodes ---
[INFO] No sources to compile
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ top-nodes ---
[INFO] No tests to run.
[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ top-nodes ---
[INFO] Building jar: D:\00-MN\projects\manusa\yakc\quickstarts\top-nodes\target\top-nodes-0.0.3.jar
[INFO]
[INFO] >>> exec-maven-plugin:1.2.1:java (default) > validate @ top-nodes >>>
[INFO]
[INFO] <<< exec-maven-plugin:1.2.1:java (default) < validate @ top-nodes <<<
[INFO]
[INFO]
[INFO] --- exec-maven-plugin:1.2.1:java (default) @ top-nodes ---
Node minikube allocatable resources, cpu: 2.0, memory: 1.800GiB, pods 110
POD (CONTAINER)                                                  CPU / LIMIT          MEM / LIMIT
============================================================     ===========          ===========
java-test-79df448b46-hv6r4 (java-test-pod)                         0.0 / 0.0            0.0 / 0.0
java-test-79df448b46-zdp8g (java-test-pod)                         0.0 / 0.0            0.0 / 0.0
test-pod-6f4b66d894-fc7ws (test-pod)                               0.0 / 0.0            0.0 / 0.0
coredns-5644d7b6d9-bc9x2 (coredns)                                 0.1 / 0.0       70MiB / 170MiB
coredns-5644d7b6d9-nz7tn (coredns)                                 0.1 / 0.0       70MiB / 170MiB
etcd-minikube (etcd)                                               0.0 / 0.0            0.0 / 0.0
kube-addon-manager-minikube (kube-addon-manager)                 0.005 / 0.0          50MiB / 0.0
kube-apiserver-minikube (kube-apiserver)                          0.25 / 0.0            0.0 / 0.0
kube-controller-manager-minikube (kube-controller-manager)         0.2 / 0.0            0.0 / 0.0
kube-proxy-smp46 (kube-proxy)                                      0.0 / 0.0            0.0 / 0.0
kube-scheduler-minikube (kube-scheduler)                           0.1 / 0.0            0.0 / 0.0
storage-provisioner (storage-provisioner)                          0.0 / 0.0            0.0 / 0.0
dashboard-metrics-scraper-76585494d8-8mscj (dashboard-metric       0.0 / 0.0            0.0 / 0.0
kubernetes-dashboard-57f4cb4545-4f95n (kubernetes-dashboard)       0.0 / 0.0            0.0 / 0.0
yakc-quickstart-pod (java-test-pod)                                0.0 / 0.0            0.0 / 0.0
============================================================     ===========          ===========
TOTAL                                                            0.755 / 0.0      190MiB / 340MiB

```
