# Top for Nodes 

This example features a Top implementation to retrieve resource usage for a given Node and its Pods.

The example execution will print a list of Pod Containers within a node and the amount of CPU and
Memory they've allocated and are using.

The report ends with a list of the total resources used in the provided Node.

## How to run

In order to run the example you need an active K8s cluster
(e.g. [Minikube](https://kubernetes.io/docs/setup/learning-environment/minikube/)).

In the project quick start directory, run `mvn clean package -q`:

```shell script
$ mvn clean package -q
Node minikube allocatable resources, cpu: 2.0, memory: 3.754GiB, pods 110
POD (CONTAINER)                                                  CPU / LIMIT          MEM / LIMIT
============================================================     ===========          ===========
coredns-66bff467f8-4kjrg (coredns)                                 0.1 / 0.0       70MiB / 170MiB
coredns-66bff467f8-wghfg (coredns)                                 0.1 / 0.0       70MiB / 170MiB
etcd-minikube (etcd)                                               0.0 / 0.0            0.0 / 0.0
kube-apiserver-minikube (kube-apiserver)                          0.25 / 0.0            0.0 / 0.0
kube-controller-manager-minikube (kube-controller-manager)         0.2 / 0.0            0.0 / 0.0
kube-proxy-9hrm5 (kube-proxy)                                      0.0 / 0.0            0.0 / 0.0
kube-scheduler-minikube (kube-scheduler)                           0.1 / 0.0            0.0 / 0.0
storage-provisioner (storage-provisioner)                          0.0 / 0.0            0.0 / 0.0
dashboard-metrics-scraper-84bfdf55ff-qx7sn (dashboard-metric       0.0 / 0.0            0.0 / 0.0
kubernetes-dashboard-bc446cc64-2ftwh (kubernetes-dashboard)        0.0 / 0.0            0.0 / 0.0
yakc-quickstart-pod (java-test-pod)                                0.0 / 0.0            0.0 / 0.0
============================================================     ===========          ===========
TOTAL                                                             0.75 / 0.0      140MiB / 340MiB
```
