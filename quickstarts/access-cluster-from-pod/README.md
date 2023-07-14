# Access Cluster From Pod

This quick start demonstrate how to access the cluster's REST API from within a Pod.

This is a feature provided out-of-the-box by YAKC (you need to set RBAC for service account first).

This example uses [Eclipse JKube](https://github.com/eclipse/jkube) to deploy a Spring Boot application
that exposes the following endpoints to provide information from the underlying cluster:
- `/namespace`: Returns the default namespace for the Pod.
- `/pods`: Returns a list of Pods in the default namespace.
- `/deployments`: Returns a list of Deployments in the default namespace.
- `/deployments/{name}/logs`: Returns a merged log (for all pods in the Deployment) for the deployment
  with the provided `name`.

## How to run

In order to run the example you need an active K8s cluster
(e.g. [Minikube](https://kubernetes.io/docs/setup/learning-environment/minikube/)).

You will also need to provide access to the cluster to the default
[service account](https://kubernetes.io/docs/tasks/access-application-cluster/access-cluster/#accessing-the-api-from-a-pod):
```shell script
kubectl create clusterrolebinding default-cluster-admin --clusterrole cluster-admin --serviceaccount=default:default
```

In the project quick start directory, run `mvn clean package` which will automatically package and
deploy to te cluster:

```shell script
$ eval $(minikube docker-env)
$ mvn clean package
[INFO] Scanning for projects...
[INFO]
[INFO] -------< com.marcnuri.yakc.quickstarts:access-cluster-from-pod >--------
[INFO] Building YAKC :: Quickstarts :: Access Cluster API from a Pod 0.0.27
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:3.1.0:clean (default-clean) @ access-cluster-from-pod ---
[INFO] Deleting D:\00-MN\projects\manusa\yakc\quickstarts\access-cluster-from-pod\target
[INFO]
[INFO] --- maven-resources-plugin:3.1.0:resources (default-resources) @ access-cluster-from-pod ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] Copying 0 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ access-cluster-from-pod ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 4 source files to D:\00-MN\projects\manusa\yakc\quickstarts\access-cluster-from-pod\target\classes
[INFO]
[INFO] --- maven-resources-plugin:3.1.0:testResources (default-testResources) @ access-cluster-from-pod ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\00-MN\projects\manusa\yakc\quickstarts\access-cluster-from-pod\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ access-cluster-from-pod ---
[INFO] No sources to compile
[INFO]
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ access-cluster-from-pod ---
[INFO] No tests to run.
[INFO]
[INFO] --- maven-jar-plugin:3.2.0:jar (default-jar) @ access-cluster-from-pod ---
[INFO] Building jar: D:\00-MN\projects\manusa\yakc\quickstarts\access-cluster-from-pod\target\access-cluster-from-pod-0.0.27.jar
[INFO]
[INFO] --- spring-boot-maven-plugin:2.3.0.RELEASE:repackage (repackage) @ access-cluster-from-pod ---
[INFO] Replacing main artifact with repackaged archive
[INFO]
[INFO] --- kubernetes-maven-plugin:1.1.0:build (jkube) @ access-cluster-from-pod ---
[WARNING] The POM for io.sundr:sundr-codegen:jar:0.21.0 is invalid, transitive dependencies (if any) will not be available, enable debug logging for more details
[INFO] k8s: Running in Kubernetes mode
[INFO] k8s: Building Docker image in Kubernetes mode
[INFO] k8s: Running generator spring-boot
[INFO] k8s: spring-boot: Using Docker image fabric8/java-centos-openjdk8-jdk:1.5.6 as base / builder
[INFO] k8s: [quickstarts/access-cluster-from-pod:0.0.27] "spring-boot": Created docker-build.tar in 551 milliseconds
[INFO] k8s: [quickstarts/access-cluster-from-pod:0.0.27] "spring-boot": Built image sha256:2d7e1
[INFO] k8s: [quickstarts/access-cluster-from-pod:0.0.27] "spring-boot": Removed old image sha256:3aaa4
[INFO]
[INFO] --- kubernetes-maven-plugin:1.1.0:resource (jkube) @ access-cluster-from-pod ---
[INFO] k8s: Running generator spring-boot
[INFO] k8s: spring-boot: Using Docker image fabric8/java-centos-openjdk8-jdk:1.5.6 as base / builder
[INFO] k8s: jkube-controller: Adding a default Deployment
[INFO] k8s: jkube-service: Adding a default service 'access-cluster-from-pod' with ports [8080]
[INFO] k8s: jkube-revision-history: Adding revision history limit to 2
[INFO]
[INFO] --- kubernetes-maven-plugin:1.1.0:apply (jkube) @ access-cluster-from-pod ---
[INFO] k8s: Using Kubernetes at https://192.168.99.116:8443/ in namespace default with manifest D:\00-MN\projects\manusa\yakc\quickstarts\access-cluster-from-pod\target\classes\META-INF\jkube\kubernetes.yml 
[INFO] k8s: Using namespace: default
[INFO] k8s: Updating a Service from kubernetes.yml
[INFO] k8s: Updated Service: target\jkube\applyJson\default\service-access-cluster-from-pod.json
[INFO] k8s: Creating a Deployment from kubernetes.yml namespace default name access-cluster-from-pod
[INFO] k8s: Created Deployment: target\jkube\applyJson\default\deployment-access-cluster-from-pod.json
[INFO] k8s: HINT: Use the command `kubectl get pods -w` to watch your pods start up
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  18.338 s
[INFO] Finished at: 2020-05-16T13:46:09+02:00
[INFO] ------------------------------------------------------------------------
```

Now you can check one of the provided endpoints to retrieve the merged log for a given deployment.

e.g `curl $(minikube service --url access-cluster-from-pod)/deployments/access-cluster-from-pod/logs`:

```shell script
$ curl $(minikube service --url access-cluster-from-pod)/deployments/access-cluster-from-pod/logs
2020-05-03T03:10:43.977274092Z [access-cluster-from-pod-76db69cc56-gnmtd] - exec java -javaagent:/opt/agent-bond/agent-bond.jar=jolokia{{host=0.0.0.0}},jmx_exporter{{9779:/opt/agent-bond/jmx_exporter_config.yml}} -XX:+UseParallelGC -XX:GCTimeRatio=4 -XX:AdaptiveSizePolicyWeight=90 -XX:MinHeapFreeRatio=20 -XX:MaxHeapFreeRatio=40 -XX:+ExitOnOutOfMemoryError -cp . -jar /deployments/access-cluster-from-pod-0.0.27.jar
2020-05-03T03:10:44.021250749Z [access-cluster-from-pod-76db69cc56-gnmtd] - OpenJDK 64-Bit Server VM warning: If the number of processors is expected to increase from one, then you should configure the number of parallel GC threads appropriately using -XX:ParallelGCThreads=N
2020-05-03T03:10:44.523717612Z [access-cluster-from-pod-76db69cc56-gnmtd] - I> No access restrictor found, access to any MBean is allowed
2020-05-03T03:10:44.63848559Z [access-cluster-from-pod-76db69cc56-gnmtd] - Jolokia: Agent started with URL http://172.17.0.6:8778/jolokia/
2020-05-03T03:10:48.344130526Z [access-cluster-from-pod-76db69cc56-gnmtd] -
2020-05-03T03:10:48.344168213Z [access-cluster-from-pod-76db69cc56-gnmtd] -   .   ____          _            __ _ _
2020-05-03T03:10:48.345021351Z [access-cluster-from-pod-76db69cc56-gnmtd] -  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
2020-05-03T03:10:48.345332729Z [access-cluster-from-pod-76db69cc56-gnmtd] - ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
2020-05-03T03:10:48.34574066Z [access-cluster-from-pod-76db69cc56-gnmtd] -  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
2020-05-03T03:10:48.34664142Z [access-cluster-from-pod-76db69cc56-gnmtd] -   '  |____| .__|_| |_|_| |_\__, | / / / /
2020-05-03T03:10:48.350110937Z [access-cluster-from-pod-76db69cc56-gnmtd] -  =========|_|==============|___/=/_/_/_/
2020-05-03T03:10:48.352006628Z [access-cluster-from-pod-76db69cc56-gnmtd] -  :: Spring Boot ::        (v2.3.0.RELEASE)
2020-05-03T03:10:48.352489888Z [access-cluster-from-pod-76db69cc56-gnmtd] -
2020-05-03T03:10:48.87126487Z [access-cluster-from-pod-76db69cc56-gnmtd] - 2020-05-03 03:10:48.863  INFO 1 --- [           main] c.m.y.q.AccessClusterFromPodApplication  : Starting AccessClusterFromPodApplication v0.0.27 on access-cluster-from-pod-76db69cc56-gnmtd with PID 1 (/deployments/access-cluster-from-pod-0.0.27.jar started by jboss in /deployments)
2020-05-03T03:10:48.874298908Z [access-cluster-from-pod-76db69cc56-gnmtd] - 2020-05-03 03:10:48.873  INFO 1 --- [           main] c.m.y.q.AccessClusterFromPodApplication  : No active profile set, falling back to default profiles: default
2020-05-03T03:10:53.442496122Z [access-cluster-from-pod-76db69cc56-gnmtd] - 2020-05-03 03:10:53.441  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2020-05-03T03:10:53.488753251Z [access-cluster-from-pod-76db69cc56-gnmtd] - 2020-05-03 03:10:53.488  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2020-05-03T03:10:53.48949873Z [access-cluster-from-pod-76db69cc56-gnmtd] - 2020-05-03 03:10:53.489  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.35]
2020-05-03T03:10:53.694133743Z [access-cluster-from-pod-76db69cc56-gnmtd] - 2020-05-03 03:10:53.693  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2020-05-03T03:10:53.694632369Z [access-cluster-from-pod-76db69cc56-gnmtd] - 2020-05-03 03:10:53.694  INFO 1 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 4481 ms
2020-05-03T03:10:57.751926044Z [access-cluster-from-pod-76db69cc56-gnmtd] - 2020-05-03 03:10:57.751  INFO 1 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-05-03T03:10:58.541631432Z [access-cluster-from-pod-76db69cc56-gnmtd] - 2020-05-03 03:10:58.541  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-05-03T03:10:58.599326745Z [access-cluster-from-pod-76db69cc56-gnmtd] - 2020-05-03 03:10:58.598  INFO 1 --- [           main] c.m.y.q.AccessClusterFromPodApplication  : Started AccessClusterFromPodApplication in 11.788 seconds (JVM running for 14.579)
2020-05-03T03:11:49.682465961Z [access-cluster-from-pod-76db69cc56-gnmtd] - 2020-05-03 03:11:49.682  INFO 1 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2020-05-03T03:11:49.682768362Z [access-cluster-from-pod-76db69cc56-gnmtd] - 2020-05-03 03:11:49.682  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2020-05-03T03:11:49.698139027Z [access-cluster-from-pod-76db69cc56-gnmtd] - 2020-05-03 03:11:49.697  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 15 ms
```
