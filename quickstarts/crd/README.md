# Complete Custom Resource Definition (CRD) Example

This example features YAKC's capabilities to create, list, delete and patch custom resources and
custom resource definitions (CRDs).

The example will start by creating a namespace `yakc-namespace` if it doesn't exist:
```java
 api.createNamespace(Namespace.builder()
     .metadata(ObjectMeta.builder().name(NAMESPACE).build())
     .build();
```

Next it will try to delete the CRD `shows.yakc.marcnuri.com` if it was created previously and
wait for the CRD to be deleted.

Once the cluster is clear, a new CustomResourceDefinition will be created for
[`shows.yakc.marcnuri.com`](src/main/java/com/marcnuri/yakc/quickstarts/Show.java).
The CRD Watch will wait until the CRD is effectively created in the cluster.

Next, the custom resource [ShowsV1Api](src/main/java/com/marcnuri/yakc/quickstarts/ShowsV1Api.java)
is showcased. Several Shows are created in the namespace. The created Shows will be listed.

Some of the Shows scores will be patched and the list will be printed again with the updated results.

Finally, the CRD will be deleted.

## How to run

In order to run the example you need an active K8s cluster
(e.g. [Minikube](https://kubernetes.io/docs/setup/learning-environment/minikube/)).

In the project quick start directory, run `mvn clean package -q`:

```shell script
$ mvn clean package -q
  Complete Custom Resource Definition (CRD) example:
   - Creates a namespace
   - Deletes CRD if exists
   - Creates CRD
   - Creates custom resource - TV Show
   - List entries for custom resource - TV Show
   - Patch entry for custom resource - TV Show
   - List patched entries for custom resource - TV Show
  Starting...
  
  Namespace with name yakc-namespace is available
  No existing CRDs with name shows.yakc.marcnuri.com
  SHOW                            AIR DATE  SCORE IMDB URL
  ====                           ========== ===== ========
  Band of Brothers               2001-09-09       https://www.imdb.com/title/tt0903747/
  Breaking Bad                   2008-01-20 9.5   https://www.imdb.com/title/tt0903747/
  House of Cards                 2013-02-01       https://www.imdb.com/title/tt1856010/
  
  Patching show scores...
  
  SHOW                            AIR DATE  SCORE IMDB URL
  ====                           ========== ===== ========
  Band of Brothers               2001-09-09       https://www.imdb.com/title/tt0903747/
  Breaking Bad                   2008-01-20 10.0  https://www.imdb.com/title/tt0903747/
  House of Cards                 2013-02-01 8.7   https://www.imdb.com/title/tt1856010/
  
```
