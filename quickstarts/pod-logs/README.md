# Pod logs retrieval example
This example features YAKC's capabilities to retrieve logs from a Pod.

The example showcases the follow flag when retrieving the logs. The main class accepts
anr agument `--follow` that will enable the flag when retrieving the logs.

If the follow flag is enabled, logs will be followed in a separate thread for a couple of seconds,
the Pod container image run command is configured to echo some message every few milliseconds.
The console will be populated by these messages until the Thread is interrupted.

If the follow flag is not enabled, logs will be retrieved for current execution status of the Pod
and execution will finish.

## How to run
In order to run the example you need an active K8s cluster
(e.g. [Minikube](https://kubernetes.io/docs/setup/learning-environment/minikube/)).


### No follow
In the project quick start directory, run `mvn package`:

```shell script
$ mvn package
[INFO] Scanning for projects...
[INFO]
[INFO] ---------------< com.marcnuri.yakc.quickstarts:pod-logs >---------------
[INFO] Building YAKC :: Quickstarts :: Pod Logs 0.0.3
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ pod-logs ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory D:\00-MN\projects\manusa\yakc\quickstarts\pod-logs\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ pod-logs ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ pod-logs ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory D:\00-MN\projects\manusa\yakc\quickstarts\pod-logs\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ pod-logs ---
[INFO] No sources to compile
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ pod-logs ---
[INFO] No tests to run.
[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ pod-logs ---
[INFO]
[INFO] >>> exec-maven-plugin:1.2.1:java (default) > validate @ pod-logs >>>
[INFO]
[INFO] <<< exec-maven-plugin:1.2.1:java (default) < validate @ pod-logs <<<
[INFO]
[INFO]
[INFO] --- exec-maven-plugin:1.2.1:java (default) @ pod-logs ---
Waiting for POD yakc-quickstart-pod-logs to be created
Waiting for POD yakc-quickstart-pod-logs to log messages
POD yakc-quickstart-pod-logs was created
2020-04-26T09:18:33.754170847Z Logging message 1
2020-04-26T09:18:33.855039646Z Logging message 2
2020-04-26T09:18:33.956239736Z Logging message 3
2020-04-26T09:18:34.057692316Z Logging message 4
2020-04-26T09:18:34.160609368Z Logging message 5
2020-04-26T09:18:34.263083029Z Logging message 6
2020-04-26T09:18:34.364760736Z Logging message 7
2020-04-26T09:18:34.467194204Z Logging message 8
2020-04-26T09:18:34.568271327Z Logging message 9
2020-04-26T09:18:34.670278393Z Logging message 10
2020-04-26T09:18:34.772548378Z Logging message 11

Cleaning up

```

### Follow logs
In the project quick start directory, run `mvn package -Dexec.args=follow`:

```shell script
$ mvn package -Dexec.args=follow
[INFO] Scanning for projects...
[INFO]
[INFO] ---------------< com.marcnuri.yakc.quickstarts:pod-logs >---------------
[INFO] Building YAKC :: Quickstarts :: Pod Logs 0.0.3
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ pod-logs ---
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ pod-logs ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory D:\00-MN\projects\manusa\yakc\quickstarts\pod-logs\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ pod-logs ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding Cp1252, i.e. build is platform dependent!
[INFO] Compiling 1 source file to D:\00-MN\projects\manusa\yakc\quickstarts\pod-logs\target\classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ pod-logs ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory D:\00-MN\projects\manusa\yakc\quickstarts\pod-logs\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ pod-logs ---
[INFO] No sources to compile
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ pod-logs ---
[INFO] No tests to run.
[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ pod-logs ---
[INFO] Building jar: D:\00-MN\projects\manusa\yakc\quickstarts\pod-logs\target\pod-logs-0.0.3.jar
[INFO]
[INFO] >>> exec-maven-plugin:1.2.1:java (default) > validate @ pod-logs >>>
[INFO]
[INFO] <<< exec-maven-plugin:1.2.1:java (default) < validate @ pod-logs <<<
[INFO]
[INFO]
[INFO] --- exec-maven-plugin:1.2.1:java (default) @ pod-logs ---
Waiting for POD yakc-quickstart-pod-logs to be created
Waiting for POD yakc-quickstart-pod-logs to log messages
POD yakc-quickstart-pod-logs was created
Log reading started in a parallel thread, following logs for a couple of seconds
2020-04-26T09:19:53.8545725Z Logging message 1
2020-04-26T09:19:53.955762366Z Logging message 2
2020-04-26T09:19:54.058177851Z Logging message 3
2020-04-26T09:19:54.159909766Z Logging message 4
2020-04-26T09:19:54.262378137Z Logging message 5
2020-04-26T09:19:54.363977795Z Logging message 6
2020-04-26T09:19:54.465514033Z Logging message 7
2020-04-26T09:19:54.566356591Z Logging message 8
2020-04-26T09:19:54.667151735Z Logging message 9
2020-04-26T09:19:54.768288326Z Logging message 10
2020-04-26T09:19:54.869842158Z Logging message 11
2020-04-26T09:19:54.971084094Z Logging message 12
2020-04-26T09:19:55.073486455Z Logging message 13
2020-04-26T09:19:55.175429924Z Logging message 14
2020-04-26T09:19:55.277549019Z Logging message 15
2020-04-26T09:19:55.379484435Z Logging message 16
2020-04-26T09:19:55.482400814Z Logging message 17
2020-04-26T09:19:55.585784083Z Logging message 18
2020-04-26T09:19:55.685640509Z Logging message 19
2020-04-26T09:19:55.786495343Z Logging message 20
2020-04-26T09:19:55.88914047Z Logging message 21
2020-04-26T09:19:55.989821191Z Logging message 22
2020-04-26T09:19:56.09053702Z Logging message 23
2020-04-26T09:19:56.193020639Z Logging message 24
2020-04-26T09:19:56.29440476Z Logging message 25
2020-04-26T09:19:56.397938188Z Logging message 26
2020-04-26T09:19:56.49957329Z Logging message 27
2020-04-26T09:19:56.601871916Z Logging message 28
2020-04-26T09:19:56.703867917Z Logging message 29
2020-04-26T09:19:56.804781825Z Logging message 30
2020-04-26T09:19:56.906475889Z Logging message 31
2020-04-26T09:19:57.008290998Z Logging message 32
2020-04-26T09:19:57.111469046Z Logging message 33
2020-04-26T09:19:57.213449944Z Logging message 34
2020-04-26T09:19:57.315127688Z Logging message 35
2020-04-26T09:19:57.416576158Z Logging message 36
2020-04-26T09:19:57.51766437Z Logging message 37
2020-04-26T09:19:57.619229099Z Logging message 38
2020-04-26T09:19:57.722108119Z Logging message 39
2020-04-26T09:19:57.826393934Z Logging message 40
2020-04-26T09:19:57.92722216Z Logging message 41
2020-04-26T09:19:58.028965617Z Logging message 42
2020-04-26T09:19:58.130708859Z Logging message 43
2020-04-26T09:19:58.232723299Z Logging message 44
2020-04-26T09:19:58.337322805Z Logging message 45
2020-04-26T09:19:58.439261557Z Logging message 46
2020-04-26T09:19:58.540850291Z Logging message 47
2020-04-26T09:19:58.643114719Z Logging message 48
2020-04-26T09:19:58.745198268Z Logging message 49
2020-04-26T09:19:58.846642609Z Logging message 50
2020-04-26T09:19:58.949437878Z Logging message 51
2020-04-26T09:19:59.052117059Z Logging message 52
2020-04-26T09:19:59.155221967Z Logging message 53
2020-04-26T09:19:59.256224016Z Logging message 54
2020-04-26T09:19:59.357616558Z Logging message 55
2020-04-26T09:19:59.463005946Z Logging message 56
2020-04-26T09:19:59.565144184Z Logging message 57
2020-04-26T09:19:59.66667086Z Logging message 58
2020-04-26T09:19:59.768151445Z Logging message 59
2020-04-26T09:19:59.871181399Z Logging message 60
2020-04-26T09:19:59.973308875Z Logging message 61
2020-04-26T09:20:00.076263957Z Logging message 62
2020-04-26T09:20:00.178349043Z Logging message 63
2020-04-26T09:20:00.279839476Z Logging message 64
2020-04-26T09:20:00.381716264Z Logging message 65
2020-04-26T09:20:00.484907145Z Logging message 66
2020-04-26T09:20:00.586396769Z Logging message 67
2020-04-26T09:20:00.688291825Z Logging message 68
2020-04-26T09:20:00.789722468Z Logging message 69
2020-04-26T09:20:00.891871979Z Logging message 70
2020-04-26T09:20:00.993582144Z Logging message 71
2020-04-26T09:20:01.095521022Z Logging message 72
2020-04-26T09:20:01.197240891Z Logging message 73
2020-04-26T09:20:01.298975123Z Logging message 74
2020-04-26T09:20:01.410342262Z Logging message 75
2020-04-26T09:20:01.553580324Z Logging message 76
2020-04-26T09:20:01.655980779Z Logging message 77
2020-04-26T09:20:01.757641114Z Logging message 78
2020-04-26T09:20:01.860498477Z Logging message 79
2020-04-26T09:20:01.961704817Z Logging message 80
2020-04-26T09:20:02.062945019Z Logging message 81
2020-04-26T09:20:02.166525793Z Logging message 82
2020-04-26T09:20:02.268167948Z Logging message 83
2020-04-26T09:20:02.369531082Z Logging message 84
2020-04-26T09:20:02.471520941Z Logging message 85
2020-04-26T09:20:02.575741955Z Logging message 86
2020-04-26T09:20:02.677605092Z Logging message 87
2020-04-26T09:20:02.779725477Z Logging message 88
2020-04-26T09:20:02.883121408Z Logging message 89
2020-04-26T09:20:02.985407978Z Logging message 90
2020-04-26T09:20:03.089366404Z Logging message 91
2020-04-26T09:20:03.193270799Z Logging message 92
2020-04-26T09:20:03.295274601Z Logging message 93
2020-04-26T09:20:03.397036081Z Logging message 94
2020-04-26T09:20:03.500520772Z Logging message 95
2020-04-26T09:20:03.602488689Z Logging message 96
2020-04-26T09:20:03.704401763Z Logging message 97
2020-04-26T09:20:03.806454931Z Logging message 98
2020-04-26T09:20:03.908022124Z Logging message 99
2020-04-26T09:20:04.009982571Z Logging message 100
2020-04-26T09:20:04.11208744Z No more messages!
Log thread finished
Cleaning up

```