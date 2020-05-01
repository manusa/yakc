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

In the project quick start directory, run `mvn clean package -q`:

```shell script
$ mvn clean package -q
Complete POD example:
 - Creates a namespace
 - Deletes POD if exists
 - Creates POD
 - Patches POD's labels
 - Updates POD removing annotations and adding another label
Starting...

Namespace with name yakc-namespace is available
         ++ New Watch Event ADDED      - yakc-namespace/yakc-quickstart-pod (2020-04-26T15:55:08Z) [{app=yakc-pod-example, label2=otherlabel, label3=an-extra-one}]
Waiting for pre-existing POD yakc-quickstart-pod to be deleted
         ++ New Watch Event MODIFIED   - yakc-namespace/yakc-quickstart-pod (2020-04-26T15:55:08Z) [{app=yakc-pod-example, label2=otherlabel, label3=an-extra-one}]
         ++ New Watch Event MODIFIED   - yakc-namespace/yakc-quickstart-pod (2020-04-26T15:55:08Z) [{app=yakc-pod-example, label2=otherlabel, label3=an-extra-one}]
         ++ New Watch Event MODIFIED   - yakc-namespace/yakc-quickstart-pod (2020-04-26T15:55:08Z) [{app=yakc-pod-example, label2=otherlabel, label3=an-extra-one}]
Existing POD yakc-quickstart-pod was deleted
         ++ New Watch Event DELETED    - yakc-namespace/yakc-quickstart-pod (2020-04-26T15:55:08Z) [{app=yakc-pod-example, label2=otherlabel, label3=an-extra-one}]
         ++ New Watch Event ADDED      - yakc-namespace/yakc-quickstart-pod (2020-04-26T15:55:25Z) [{app=yakc-pod-example}]
Waiting for POD yakc-quickstart-pod to be created
         ++ New Watch Event MODIFIED   - yakc-namespace/yakc-quickstart-pod (2020-04-26T15:55:25Z) [{app=yakc-pod-example}]
POD yakc-quickstart-pod was created
         ++ New Watch Event MODIFIED   - yakc-namespace/yakc-quickstart-pod (2020-04-26T15:55:25Z) [{app=yakc-pod-example}]
         ++ New Watch Event MODIFIED   - yakc-namespace/yakc-quickstart-pod (2020-04-26T15:55:25Z) [{app=yakc-pod-example, label2=otherlabel}]
POD labels patched [{app=yakc-pod-example, label2=otherlabel}]
POD replaced: annotations removed, labels modified  [{app=yakc-pod-example, label2=otherlabel, label3=an-extra-one}]
         ++ New Watch Event MODIFIED   - yakc-namespace/yakc-quickstart-pod (2020-04-26T15:55:25Z) [{app=yakc-pod-example, label2=otherlabel, label3=an-extra-one}]
Pod demo concluded successfully!
```
