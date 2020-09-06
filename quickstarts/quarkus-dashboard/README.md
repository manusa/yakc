# YAKC - Kubernetes Dashboard

PoC to show how to build a Kubernetes dashboard with YAKC, Quarkus and React.

## Build

To build the whole project (Front-end & Back-end), the easiest way is to run the Maven build with
the provided profile `build-frontend`.

```shell script
# Build project
$ mvn clean package -Pbuild-frontend
```

## Build & Deploy to Minikube

Follow these instructions if you want to build & deploy the project into a Kubernetes Cluster, in
this case Minikube.

```shell script
# Provide access to Minikube's Docker daemon (allows to skip pushing the generated image)
$ eval $(minikube docker-env)
# Build and deploy project
$ mvn clean install -Pbuild-frontend,minikube
# Open Browser and navigate to deployed application
$ minikube service yakc-dashboard
```

## Development

### Back-End

### Front-End

You can find the React client application in the [`src/main/frontend`](src/main/frontend)
directory.

```shell script
# Install required dependencies
$ npm install
# Start development mode
$ npm start
```

You can point your browser to [localhost:3000](http://localhost:3000).