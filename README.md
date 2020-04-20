# YAKC - Yet Another Kubernetes Client

> Declarative Java REST client for Kubernetes API.

**DISCLAIMER**

This project is still a PoC, public API and classes are subject to constant changes.
Please try it out and share your opinion, but use at your own risk.

## Quick start

### TL;DR
#### Maven
```xml
<dependencies>
  <dependency>
    <groupId>com.marcnuri.yakc</groupId>
    <artifactId>kubernetes-api</artifactId>
    <version>0.0.0</version>
  </dependency>
  <dependency>
    <groupId>com.marcnuri.yakc</groupId>
    <artifactId>kubernetes-client</artifactId>
    <version>0.0.0</version>
  </dependency>
</dependencies>
```
#### Gradle
```groovy
dependencies {
  compile 'com.marcnuri.yakc:kubernetes-api:0.0.0'
  compile 'com.marcnuri.yakc:kubernetes-client:0.0.0'
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

Check the [quickstarts](quickstarts) directory for projects ready to use with illustrative examples on how to use
the client.

- [Pod](quickstarts/pod) contains a Maven project with examples to the diverse available API operations
for  Pod resources. See nested [README.md](quickstarts/pod/README.md) for more information.
## Modules

### kubernetes-client-api
Provides the basic interfaces and Exception types to be used across the different modules.

### kubernetes-model
Kubernetes model objects to be used for REST API serialization/deserialization.

### kubernetes-api
[Retrofit](https://square.github.io/retrofit/) API client Java interfaces for the latest
[Kubernetes JSON](https://github.com/kubernetes/kubernetes/blob/master/api/openapi-spec/swagger.json)
[OpenAPI](https://swagger.io/specification/) schema.

### kubernetes-client
Kubernetes Retrofit2 based Java client to be used with kubernetes-api.

