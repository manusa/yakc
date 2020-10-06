# YAKC - Yet Another Kubernetes Client

> Declarative Java REST client for Kubernetes API.

This project is still in an early stage, public API and classes are subject to changes.

Please try it out and share your opinion, but use at your own risk.

## Quick start

### TL;DR
#### Maven
```xml
<dependencies>
  <dependency>
    <groupId>com.marcnuri.yakc</groupId>
    <artifactId>kubernetes-api</artifactId>
    <version>0.0.9</version>
  </dependency>
  <dependency>
    <groupId>com.marcnuri.yakc</groupId>
    <artifactId>kubernetes-client</artifactId>
    <version>0.0.9</version>
  </dependency>
</dependencies>
```
#### Gradle
```groovy
dependencies {
  compile 'com.marcnuri.yakc:kubernetes-api:0.0.9'
  compile 'com.marcnuri.yakc:kubernetes-client:0.0.9'
}
```
#### List all Pods
```java
try (KubernetesClient kc = new KubernetesClient()) {
  kc.create(CoreV1Api.class).listPodForAllNamespaces().stream().forEach(p ->
    System.out.printf("%-15s %s%n", p.getMetadata().getNamespace(), p.getMetadata().getName()
  )
}
```

### Quick start example projects

Check the [quickstarts](quickstarts) directory for projects ready to use with illustrative examples
on how to use the client.

- [Quarkus Kubernetes Dashboard](quickstarts/quarkus-dashboard), full featured reactive Kubernetes 
  dashboard built with Quarkus and ReactJS. 
  See nested [README.md](quickstarts/quarkus-dashboard/README.md) for more information.
- [Pods](quickstarts/pods) contains a Maven project with examples to the diverse available API operations
  for  Pod resources.
  See nested [README.md](quickstarts/pod/README.md) for more information.
- [Pod Logs](quickstarts/pod-logs) contains a Maven project with an example showcasing how to retrieve
  Pod logs, both with follow and no-follow options.
  See nested [README.md](quickstarts/pod-logs/README.md) for more information.
- [Pod Exec](quickstarts/pod-exec) contains a Maven project with an example showcasing how to execute
  commands in a Pod container.
  See nested [README.md](quickstarts/pod-exec/README.md) for more information.
- [Top for Nodes](quickstarts/top-nodes) contains a Maven project with an example on how to query
  Nodes and Pod containers to calculate resource availability and usage.
  See nested [README.md](quickstarts/top-nodes/README.md) for more information.
- [Custom Resource Definition](quickstarts/crd) contains a Maven project with a complete example on
  how to create Custom Resource Definitions and how to create and use an API to manipulate those
  custom resources.
  See nested [README.md](quickstarts/crd/README.md) for more information.
- [Access Cluster from Pod](quickstarts/access-cluster-from-pod) demonstrates how to access the 
  underlying k8s cluster's REST API from within a Pod.
  See nested [README.md](quickstarts/access-cluster-from-pod/README.md) for more information.
  
### Katacoda
Check out the different [Katacoda scenarios](https://www.katacoda.com/marcnuri/courses/yakc/)
where you can try YAKC from your browser and without installing anything in your machine.

We'll be adding several scenarios with increasing complexity, as of now you can try out [how to 
setup Maven to use YAKC](https://www.katacoda.com/marcnuri/courses/yakc/maven-quick-start).

## Modules

### kubernetes-client-api
[![Maven Central](https://img.shields.io/maven-central/v/com.marcnuri.yakc/kubernetes-client-api)
](https://search.maven.org/search?q=g:com.marcnuri.yakc%20a:kubernetes-client-api)
[![javadoc](https://javadoc.io/badge2/com.marcnuri.yakc/kubernetes-client-api/javadoc.svg)
](https://javadoc.io/doc/com.marcnuri.yakc/kubernetes-client-api)

Provides the basic interfaces and Exception types to be used across the different modules.

### kubernetes-model
[![Maven Central](https://img.shields.io/maven-central/v/com.marcnuri.yakc/kubernetes-model)
](https://search.maven.org/search?q=g:com.marcnuri.yakc%20a:kubernetes-model)
[![javadoc](https://javadoc.io/badge2/com.marcnuri.yakc/kubernetes-model/javadoc.svg)
](https://javadoc.io/doc/com.marcnuri.yakc/kubernetes-model)

Kubernetes model objects to be used for REST API serialization/deserialization.

### kubernetes-api
[![Maven Central](https://img.shields.io/maven-central/v/com.marcnuri.yakc/kubernetes-api)
](https://search.maven.org/search?q=g:com.marcnuri.yakc%20a:kubernetes-api)
[![javadoc](https://javadoc.io/badge2/com.marcnuri.yakc/kubernetes-api/javadoc.svg)
](https://javadoc.io/doc/com.marcnuri.yakc/kubernetes-api)

[Retrofit](https://square.github.io/retrofit/) API client Java interfaces for the latest
[Kubernetes JSON](https://github.com/kubernetes/kubernetes/blob/master/api/openapi-spec/swagger.json)
[OpenAPI](https://swagger.io/specification/) schema.

### kubernetes-client
[![Maven Central](https://img.shields.io/maven-central/v/com.marcnuri.yakc/kubernetes-client)
](https://search.maven.org/search?q=g:com.marcnuri.yakc%20a:kubernetes-client)
[![javadoc](https://javadoc.io/badge2/com.marcnuri.yakc/kubernetes-client/javadoc.svg)
](https://javadoc.io/doc/com.marcnuri.yakc/kubernetes-client)

Kubernetes Retrofit2 based Java client to be used with kubernetes-api.

