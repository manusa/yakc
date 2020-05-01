# Pod Exec Example

This example features YAKC's capabilities to execute commands in a Pod and stream the 
standard output/error messages using ReactiveX both in a blocking and non-blocking way.

The examples starts by issuing a `pwd` command in a Pod container and waits for response to
print a message indicating the current directory.

Next it will start another execution, this time in the background
(notice the use of `Observable#subscribeOn(Schedulers.io())`), to list the available memory
(MemFree) in the container every second during 5 iterations and then finish.

While the monitor is running, another blocking command is executed to check that the different 
standard streams (out/err) are used.

## How to run

In order to run the example you need an active K8s cluster
(e.g. [Minikube](https://kubernetes.io/docs/setup/learning-environment/minikube/)).

In the project quick start directory, run `mvn clean package -q`:

```shell script
$ mvn clean package -q
Pod yakc-quickstart-pod-exec doesn't exist in namespace default
Waiting for POD yakc-quickstart-pod-exec to be created
POD yakc-quickstart-pod-exec was created
Current container Directory: /
Running memory monitor for 5s in the background
STDOUT: Waiting 5S
         ++ MemFree:          655308 kB
         ++ MemFree:          655576 kB
         ++ MemFree:          655576 kB
         ++ MemFree:          655584 kB
         ++ MemFree:          655340 kB
STDERR: Hello World in error standard stream
STDOUT: Container execution completed, bye!
Subscriptions completed, cleaning up.
Waiting for Pod yakc-quickstart-pod-exec in namespace default to be deleted
Pod yakc-quickstart-pod-exec in namespace default was deleted
```