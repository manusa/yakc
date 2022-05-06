# YAKC - Yet Another Kubernetes Client

> Lower level Java REST client for Kubernetes API.

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
    <version>0.0.25</version>
  </dependency>
  <dependency>
    <groupId>com.marcnuri.yakc</groupId>
    <artifactId>kubernetes-client</artifactId>
    <version>0.0.25</version>
  </dependency>
</dependencies>
```
#### Gradle
```groovy
dependencies {
  implementation 'com.marcnuri.yakc:kubernetes-api:0.0.25'
  implementation 'com.marcnuri.yakc:kubernetes-client:0.0.25'
}
```
#### List all Pods
```java
try (KubernetesClient kc = new KubernetesClient()) {
  kc.create(CoreV1Api.class).listPodForAllNamespaces().stream().forEach(p ->
    System.out.printf("%-15s %s%n", p.getMetadata().getNamespace(), p.getMetadata().getName())
  );
}
```

### Quick start example projects

Check the [quickstarts](quickstarts) directory for projects ready to use with illustrative examples
on how to use the client.

- [Quarkus Kubernetes Dashboard](quickstarts/quarkus-dashboard), full featured reactive Kubernetes 
  dashboard built with Quarkus and ReactJS. 
  See nested [README.md](quickstarts/quarkus-dashboard/README.md) for more information.
  You can also checkout a demo on [YouTube](https://www.youtube.com/watch?v=Dum84fwA8_g).
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

### Core

#### kubernetes-client-api
[![Maven Central](https://img.shields.io/maven-central/v/com.marcnuri.yakc/kubernetes-client-api)
](https://search.maven.org/search?q=g:com.marcnuri.yakc%20a:kubernetes-client-api)
[![javadoc](https://javadoc.io/badge2/com.marcnuri.yakc/kubernetes-client-api/javadoc.svg)
](https://javadoc.io/doc/com.marcnuri.yakc/kubernetes-client-api)

Provides the basic interfaces and Exception types to be used across the different modules.

#### kubernetes-model
[![Maven Central](https://img.shields.io/maven-central/v/com.marcnuri.yakc/kubernetes-model)
](https://search.maven.org/search?q=g:com.marcnuri.yakc%20a:kubernetes-model)
[![javadoc](https://javadoc.io/badge2/com.marcnuri.yakc/kubernetes-model/javadoc.svg)
](https://javadoc.io/doc/com.marcnuri.yakc/kubernetes-model)

Kubernetes model objects to be used for REST API serialization/deserialization.

Model types are generated for Kubernetes equivalents in versions ranging from 1.15 to 1.24.

#### kubernetes-api
[![Maven Central](https://img.shields.io/maven-central/v/com.marcnuri.yakc/kubernetes-api)
](https://search.maven.org/search?q=g:com.marcnuri.yakc%20a:kubernetes-api)
[![javadoc](https://javadoc.io/badge2/com.marcnuri.yakc/kubernetes-api/javadoc.svg)
](https://javadoc.io/doc/com.marcnuri.yakc/kubernetes-api)

[Retrofit](https://square.github.io/retrofit/) API client Java interfaces for the latest
[Kubernetes JSON](https://github.com/kubernetes/kubernetes/blob/master/api/openapi-spec/swagger.json)
[OpenAPI](https://swagger.io/specification/) schema.

API methods for Kubernetes REST endpoints in versions ranging from 1.15 to 1.24.

#### kubernetes-client
[![Maven Central](https://img.shields.io/maven-central/v/com.marcnuri.yakc/kubernetes-client)
](https://search.maven.org/search?q=g:com.marcnuri.yakc%20a:kubernetes-client)
[![javadoc](https://javadoc.io/badge2/com.marcnuri.yakc/kubernetes-client/javadoc.svg)
](https://javadoc.io/doc/com.marcnuri.yakc/kubernetes-client)

Kubernetes Retrofit2 based Java client to be used with kubernetes-api or any of the provided [apis](#apis).

### Apis

#### cert-manager
[![Maven Central](https://img.shields.io/maven-central/v/com.marcnuri.yakc.apis/cert-manager)
](https://search.maven.org/search?q=g:com.marcnuri.yakc.apis%20a:cert-manager)
[![javadoc](https://javadoc.io/badge2/com.marcnuri.yakc.apis/cert-manager/javadoc.svg)
](https://javadoc.io/doc/com.marcnuri.yakc.apis/cert-manager)

[Retrofit](https://square.github.io/retrofit/) API client Java interfaces for
[Kubernetes cert-manager](https://cert-manager.io/) (1.0.4 - 1.5.3).

cert-manager provides support for x509 certificate management for Kubernetes. It's a Kubernetes
add-on that automates the management and issuance of TLS certificates, making it very easy
to provide certificates for developers working within your cluster.

The Java types provided by YAKC will further improve the developer experience by enabling
developers to interact with cert-manager from Java.

#### Chaos Mesh
[![Maven Central](https://img.shields.io/maven-central/v/com.marcnuri.yakc.apis/chaos-mesh)
](https://search.maven.org/search?q=g:com.marcnuri.yakc.apis%20a:chaos-mesh)
[![javadoc](https://javadoc.io/badge2/com.marcnuri.yakc.apis/chaos-mesh/javadoc.svg)
](https://javadoc.io/doc/com.marcnuri.yakc.apis/chaos-mesh)

[Retrofit](https://square.github.io/retrofit/) API client Java interfaces for
[Chaos Mesh](https://chaos-mesh.org/) (1.1.0 - 2.0.0).

Chaos Mesh is chaos engineering platform that orchestrates chaos on Kubernetes environments.

#### Dapr
[![Maven Central](https://img.shields.io/maven-central/v/com.marcnuri.yakc.apis/dapr)
](https://search.maven.org/search?q=g:com.marcnuri.yakc.apis%20a:dapr)
[![javadoc](https://javadoc.io/badge2/com.marcnuri.yakc.apis/dapr/javadoc.svg)
](https://javadoc.io/doc/com.marcnuri.yakc.apis/dapr)

[Retrofit](https://square.github.io/retrofit/) API client Java interfaces for
[Dapr](https://dapr.io/) - Distributed Application Runtime (1.0.1 - 1.4.1).

Dapr is a portable, event-driven, runtime for building distributed applications across cloud and edge.

#### Istio
[![Maven Central](https://img.shields.io/maven-central/v/com.marcnuri.yakc.apis/istio)
](https://search.maven.org/search?q=g:com.marcnuri.yakc.apis%20a:istio)
[![javadoc](https://javadoc.io/badge2/com.marcnuri.yakc.apis/istio/javadoc.svg)
](https://javadoc.io/doc/com.marcnuri.yakc.apis/istio)

[Retrofit](https://square.github.io/retrofit/) API client Java interfaces for
[Istio](https://istio.io/) (1.7 - 1.11.3).

Istio is a service-mesh for distributed applications. Istio leverages the required features to
run a successful and efficient distributed microservice architecture by providing a uniform way
to secure, monitor and connect microservices.

#### Knative
[![Maven Central](https://img.shields.io/maven-central/v/com.marcnuri.yakc.apis/knative)
](https://search.maven.org/search?q=g:com.marcnuri.yakc.apis%20a:knative)
[![javadoc](https://javadoc.io/badge2/com.marcnuri.yakc.apis/knative/javadoc.svg)
](https://javadoc.io/doc/com.marcnuri.yakc.apis/knative)

[Retrofit](https://square.github.io/retrofit/) API client Java interfaces for
[Knative](https://knative.dev/) (0.19.0 - 0.22.0).

Knative is a Kubernetes-based platform to manage and deploy serverless workloads.

#### KUDO - Kubernetes Universal Declarative Operator (KUDO)
[![Maven Central](https://img.shields.io/maven-central/v/com.marcnuri.yakc.apis/kudo)
](https://search.maven.org/search?q=g:com.marcnuri.yakc.apis%20a:kudo)
[![javadoc](https://javadoc.io/badge2/com.marcnuri.yakc.apis/kudo/javadoc.svg)
](https://javadoc.io/doc/com.marcnuri.yakc.apis/kudo)

[Retrofit](https://square.github.io/retrofit/) API client Java interfaces for
[KUDO](https://kudo.dev/) (0.18.2 - 0.19.0).

Kubernetes Universal Declarative Operator (KUDO) provides a declarative approach to building production-grade Kubernetes
Operators covering the entire application lifecycle.

#### metrics-server
[![Maven Central](https://img.shields.io/maven-central/v/com.marcnuri.yakc.apis/metrics-server)
](https://search.maven.org/search?q=g:com.marcnuri.yakc.apis%20a:metrics-server)
[![javadoc](https://javadoc.io/badge2/com.marcnuri.yakc.apis/metrics-server/javadoc.svg)
](https://javadoc.io/doc/com.marcnuri.yakc.apis/metrics-server)

[Retrofit](https://square.github.io/retrofit/) API client Java interfaces for
[Kubernetes Metrics Server](https://github.com/kubernetes-sigs/metrics-server)  (0.4.0).

Metrics server collects resource metrics from Pods and Nodes making them ready to be consumed
via the Metrics API by Horizontal Pod Autoscaler and other scaling solutions.

YAKC provides the means to access the Metrics API from Java.

#### OpenShift
[![Maven Central](https://img.shields.io/maven-central/v/com.marcnuri.yakc.apis/openshift)
](https://search.maven.org/search?q=g:com.marcnuri.yakc.apis%20a:openshift)
[![javadoc](https://javadoc.io/badge2/com.marcnuri.yakc.apis/openshift/javadoc.svg)
](https://javadoc.io/doc/com.marcnuri.yakc.apis/openshift)

[Retrofit](https://square.github.io/retrofit/) API client Java interfaces for
[OpenShift](https://github.com/openshift/origin) (3.11 - 4.4).

This module contains models for OpenShift specific Kubernetes resources and the Retrofit APIs to
access them.  

### Extensions

#### YAKC Quarkus Extension
[![Maven Central](https://img.shields.io/maven-central/v/com.marcnuri.yakc/quarkus-yakc-extension)
](https://search.maven.org/search?q=g:com.marcnuri.yakc%20a:quarkus-yakc-extension)
[![javadoc](https://javadoc.io/badge2/com.marcnuri.yakc/quarkus-yakc-extension/javadoc.svg)
](https://javadoc.io/doc/com.marcnuri.yakc/quarkus-yakc-extension)

This [extension](https://github.com/manusa/yakc-quarkus-extension) provides the requirements to be able to produce
[Quarkus](https://quarkus.io) native images for your application running with YAKC.

The extension is hosted in a separate [repository](https://github.com/manusa/yakc-quarkus-extension).
