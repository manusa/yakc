# Complete Pod Example

This example features YAKC's capabilities to create, delete, update, patch and watch Pod resources.

The example will start by creating a namespace `yakc-namespace` if it doesn't exist:
```java
 api.createNamespace(Namespace.builder()
     .metadata(ObjectMeta.builder().name(NAMESPACE).build())
     .build();
```

Next it will try to delete the Pod `yakc-quickstart-pod` if it was created previously and
wait for the Pod to be deleted from the namespace.

Once the namespace is clear, a new Pod will be created. The Pod Watch will wait until
the Pod is effectively created in the cluster.

Next, the Pod will be patched and a new label will be added (preserving the previously added ones).

Finally, the Pod will be read and updated to remove all annotations.

## How to run

In order to run the example you need an active K8s cluster
(e.g. [Minikube](https://kubernetes.io/docs/setup/learning-environment/minikube/)).

In the project quick start directory, run `mvn package`:

```shell script
$ mvn package
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------< com.marcnuri.yakc.quickstarts:pods >-----------------
[INFO] Building YAKC :: Quickstarts :: Pods 0.0.2
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ pods ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory D:\00-MN\projects\manusa\yakc\quickstarts\pod\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ pods ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ pods ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory D:\00-MN\projects\manusa\yakc\quickstarts\pod\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ pods ---
[INFO] No sources to compile
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ pods ---
[INFO] No tests to run.
[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ pods ---
[INFO]
[INFO] >>> exec-maven-plugin:1.2.1:java (default) > validate @ pods >>>
[INFO]
[INFO] <<< exec-maven-plugin:1.2.1:java (default) < validate @ pods <<<
[INFO]
[INFO]
[INFO] --- exec-maven-plugin:1.2.1:java (default) @ pods ---
Complete POD example:
 - Creates a namespace
 - Deletes POD if exists
 - Creates POD
 - Patches POD's labels
 - Updates POD removing annotations and adding another label
         ++ New Watch Event ADDED      - yakc-namespace/yakc-quickstart-pod (2020-04-24T17:10:45Z) [{app=yakc-pod-example, label2=otherlabel, label3=an-extra-one}]
Namespace with name yakc-namespace is available
Waiting for pre-existing POD yakc-quickstart-pod to be deleted
         ++ New Watch Event MODIFIED   - yakc-namespace/yakc-quickstart-pod (2020-04-24T17:10:45Z) [{app=yakc-pod-example, label2=otherlabel, label3=an-extra-one}]
         ++ New Watch Event MODIFIED   - yakc-namespace/yakc-quickstart-pod (2020-04-24T17:10:45Z) [{app=yakc-pod-example, label2=otherlabel, label3=an-extra-one}]
         ++ New Watch Event MODIFIED   - yakc-namespace/yakc-quickstart-pod (2020-04-24T17:10:45Z) [{app=yakc-pod-example, label2=otherlabel, label3=an-extra-one}]
         ++ New Watch Event DELETED    - yakc-namespace/yakc-quickstart-pod (2020-04-24T17:10:45Z) [{app=yakc-pod-example, label2=otherlabel, label3=an-extra-one}]
Existing POD yakc-quickstart-pod was deleted
         ++ New Watch Event ADDED      - yakc-namespace/yakc-quickstart-pod (2020-04-24T17:12:50Z) [{app=yakc-pod-example}]
Waiting for POD yakc-quickstart-pod to be created
         ++ New Watch Event MODIFIED   - yakc-namespace/yakc-quickstart-pod (2020-04-24T17:12:50Z) [{app=yakc-pod-example}]
POD yakc-quickstart-pod was created
         ++ New Watch Event MODIFIED   - yakc-namespace/yakc-quickstart-pod (2020-04-24T17:12:50Z) [{app=yakc-pod-example}]
         ++ New Watch Event MODIFIED   - yakc-namespace/yakc-quickstart-pod (2020-04-24T17:12:50Z) [{app=yakc-pod-example, label2=otherlabel}]
POD labels patched [{app=yakc-pod-example, label2=otherlabel}]
         ++ New Watch Event MODIFIED   - yakc-namespace/yakc-quickstart-pod (2020-04-24T17:12:50Z) [{app=yakc-pod-example, label2=otherlabel, label3=an-extra-one}]
POD replaced: annotations removed, labels modified  [{app=yakc-pod-example, label2=otherlabel, label3=an-extra-one}]
Pod demo concluded successfully!

```
