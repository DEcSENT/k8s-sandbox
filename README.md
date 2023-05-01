# What is it

This is the sandbox for learning Docker, k8s, Grafana, etc.

## How to launch applications in the minikube cluster

Run this commands in sequence:

```shell
minikube start
```
```shell
kubectl apply -f ./k8s/deployment-shortlife-receiver.yaml 
```
```shell
kubectl apply -f ./k8s/deployment-shortlife-sender.yaml 
```
```shell
kubectl apply -f ./k8s/service.yaml 
```

Check in dashboard that everything works fine:

```shell
minikube dashboard
```

## How to build, push and use your own docker images

Build application image. For example:

```shell
docker build -t shortlife-sender ./shortlife
```

Then tag your new image and push it to docker hub. Find your new image id in images list:
```shell
docker images
```
Then tag your image:

```shell
docker tag 1551d56ad8c0 decsent/shortlife-sender:1.0
```

And then push image to hub:

```shell
docker push decsent/shortlife-sender:1.0  
```

Now you can use your image in k8s config files or use separately.