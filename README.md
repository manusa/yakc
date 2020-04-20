# YAKC - Yet Another Kubernetes Client

> Declarative Java REST client for Kubernetes API.

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

