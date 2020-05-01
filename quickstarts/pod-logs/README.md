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
In the project quick start directory, run `mvn clean package -q`:

```shell script
$ mvn clean package -q
Waiting for POD yakc-quickstart-pod-logs to be created
Waiting for POD yakc-quickstart-pod-logs to log messages
POD yakc-quickstart-pod-logs was created
2020-04-26T15:56:35.604572177Z Logging message 1
2020-04-26T15:56:35.706897333Z Logging message 2
2020-04-26T15:56:35.80769418Z Logging message 3
2020-04-26T15:56:35.91083855Z Logging message 4
2020-04-26T15:56:36.017646232Z Logging message 5
2020-04-26T15:56:36.119028334Z Logging message 6
2020-04-26T15:56:36.220316443Z Logging message 7
2020-04-26T15:56:36.323496134Z Logging message 8
2020-04-26T15:56:36.425483954Z Logging message 9
2020-04-26T15:56:36.526270188Z Logging message 10

Cleaning up
```

### Follow logs
In the project quick start directory, run `mvn clean package -q -Dexec.args=follow`:

```shell script
$ mvn clean package -q -q -Dexec.args=follow
Waiting for POD yakc-quickstart-pod-logs to be created
Waiting for POD yakc-quickstart-pod-logs to log messages
POD yakc-quickstart-pod-logs was created
Log reading started in a parallel thread, following logs for a couple of seconds
2020-04-26T15:57:16.203981033Z Logging message 1
2020-04-26T15:57:16.30628361Z Logging message 2
2020-04-26T15:57:16.408269187Z Logging message 3
2020-04-26T15:57:16.510008453Z Logging message 4
2020-04-26T15:57:16.611411773Z Logging message 5
2020-04-26T15:57:16.7127995Z Logging message 6
2020-04-26T15:57:16.815392641Z Logging message 7
2020-04-26T15:57:16.91682928Z Logging message 8
2020-04-26T15:57:17.018374918Z Logging message 9
2020-04-26T15:57:17.121144861Z Logging message 10
2020-04-26T15:57:17.222295134Z Logging message 11
2020-04-26T15:57:17.32350922Z Logging message 12
2020-04-26T15:57:17.426656056Z Logging message 13
2020-04-26T15:57:17.528010467Z Logging message 14
2020-04-26T15:57:17.629527906Z Logging message 15
2020-04-26T15:57:17.730995592Z Logging message 16
2020-04-26T15:57:17.832974781Z Logging message 17
2020-04-26T15:57:17.935769059Z Logging message 18
2020-04-26T15:57:18.036953967Z Logging message 19
2020-04-26T15:57:18.138438574Z Logging message 20
2020-04-26T15:57:18.239567668Z Logging message 21
2020-04-26T15:57:18.340364733Z Logging message 22
2020-04-26T15:57:18.441862458Z Logging message 23
2020-04-26T15:57:18.543644688Z Logging message 24
2020-04-26T15:57:18.647059961Z Logging message 25
2020-04-26T15:57:18.748826108Z Logging message 26
2020-04-26T15:57:18.84996423Z Logging message 27
2020-04-26T15:57:18.952321588Z Logging message 28
2020-04-26T15:57:19.054128206Z Logging message 29
2020-04-26T15:57:19.156637899Z Logging message 30
2020-04-26T15:57:19.258311258Z Logging message 31
2020-04-26T15:57:19.358892142Z Logging message 32
2020-04-26T15:57:19.461383515Z Logging message 33
2020-04-26T15:57:19.563237684Z Logging message 34
2020-04-26T15:57:19.664430504Z Logging message 35
2020-04-26T15:57:19.766122076Z Logging message 36
2020-04-26T15:57:19.868475376Z Logging message 37
2020-04-26T15:57:19.970737973Z Logging message 38
2020-04-26T15:57:20.072582299Z Logging message 39
2020-04-26T15:57:20.175238833Z Logging message 40
2020-04-26T15:57:20.277091718Z Logging message 41
2020-04-26T15:57:20.379167147Z Logging message 42
2020-04-26T15:57:20.484420684Z Logging message 43
2020-04-26T15:57:20.586164224Z Logging message 44
2020-04-26T15:57:20.687975307Z Logging message 45
2020-04-26T15:57:20.790165955Z Logging message 46
2020-04-26T15:57:20.893905883Z Logging message 47
2020-04-26T15:57:20.996005105Z Logging message 48
2020-04-26T15:57:21.097734594Z Logging message 49
2020-04-26T15:57:21.199068825Z Logging message 50
2020-04-26T15:57:21.311201963Z Logging message 51
2020-04-26T15:57:21.407224297Z Logging message 52
2020-04-26T15:57:21.508811021Z Logging message 53
2020-04-26T15:57:21.610329544Z Logging message 54
2020-04-26T15:57:21.711983489Z Logging message 55
2020-04-26T15:57:21.81346232Z Logging message 56
2020-04-26T15:57:21.914584178Z Logging message 57
2020-04-26T15:57:22.016794697Z Logging message 58
2020-04-26T15:57:22.118280714Z Logging message 59
2020-04-26T15:57:22.220296832Z Logging message 60
2020-04-26T15:57:22.322038589Z Logging message 61
2020-04-26T15:57:22.423098798Z Logging message 62
2020-04-26T15:57:22.524959916Z Logging message 63
2020-04-26T15:57:22.626497976Z Logging message 64
2020-04-26T15:57:22.729127873Z Logging message 65
2020-04-26T15:57:22.832005372Z Logging message 66
2020-04-26T15:57:22.932992177Z Logging message 67
2020-04-26T15:57:23.034359326Z Logging message 68
2020-04-26T15:57:23.136280434Z Logging message 69
2020-04-26T15:57:23.237743478Z Logging message 70
2020-04-26T15:57:23.339273118Z Logging message 71
2020-04-26T15:57:23.440828118Z Logging message 72
2020-04-26T15:57:23.543274605Z Logging message 73
2020-04-26T15:57:23.644857205Z Logging message 74
2020-04-26T15:57:23.747463926Z Logging message 75
2020-04-26T15:57:23.848693359Z Logging message 76
2020-04-26T15:57:23.951441217Z Logging message 77
2020-04-26T15:57:24.052950139Z Logging message 78
2020-04-26T15:57:24.155165792Z Logging message 79
2020-04-26T15:57:24.258393167Z Logging message 80
2020-04-26T15:57:24.360657479Z Logging message 81
2020-04-26T15:57:24.463797378Z Logging message 82
2020-04-26T15:57:24.563427966Z Logging message 83
2020-04-26T15:57:24.666308726Z Logging message 84
2020-04-26T15:57:24.767008636Z Logging message 85
2020-04-26T15:57:24.871514758Z Logging message 86
2020-04-26T15:57:24.97328062Z Logging message 87
2020-04-26T15:57:25.075925027Z Logging message 88
2020-04-26T15:57:25.175948068Z Logging message 89
2020-04-26T15:57:25.278161015Z Logging message 90
2020-04-26T15:57:25.3797873Z Logging message 91
2020-04-26T15:57:25.481268583Z Logging message 92
2020-04-26T15:57:25.582264068Z Logging message 93
2020-04-26T15:57:25.6841922Z Logging message 94
2020-04-26T15:57:25.786274009Z Logging message 95
2020-04-26T15:57:25.887253034Z Logging message 96
2020-04-26T15:57:25.989267976Z Logging message 97
2020-04-26T15:57:26.091500163Z Logging message 98
2020-04-26T15:57:26.193273576Z Logging message 99
2020-04-26T15:57:26.294405217Z Logging message 100
2020-04-26T15:57:26.395199983Z No more messages!
Log thread finished
Cleaning up
```