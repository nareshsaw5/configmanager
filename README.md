# Configmanager
A Spring Boot microservice that exposes configuration data through REST endpoints, allowing clients to query individual keys or retrieve all configuration values. The application can be run locally as standalone as well as k8s pod. The image is pushed to docker registry with tag - ```docker.io/nareshsaw5/configmanager:1.0 ``` 
1. **Running Standalone - locally**:
```bash
git clone https://github.com/nareshsaw5/configmanager
cd configmanager
./gradlew bootRun
```
Please keep the terminal open. Let the application run


2. **Test locally**;
Once the standalone application is running as mentioned above, open another terminal and run below commands to get all config or specific config
- ***Get all configuration***
  ```bash
  curl http://localhost:8080/configmanager/all-config
  ```
expected response:: {"country":"india","ln":"saw","education":"bsc","city":"bangalore","fn":"naresh","company":"nokia"}
- ***Get specific key(ln)***
```bash
curl http://localhost:8080/configmanager?key=ln
```
expected response:: {"value":"saw","key":"ln"}%
- ***Get specific key(fn)***
```bash
curl http://localhost:8080/configmanager?key=fn
```
expected response: {"value":"naresh","key":"fn"}


3. **Running in k8s cluster**:
If you can clone the repo in the cluster, just use configmanager-deployment.yml
or copy this file to the k8s cluster and use it as below
```bash
kubectl apply -f configmanager-deployment.yml
```
This should create 4 pods and a NodePort Service in default namespace on node-port 32080
```bash
kubectl get po | grep configmanager
kubectl get svc | grep configmanager
```

4. **Test in k8s cluster**;
- ***Get all configuration***
```bash
curl http://<<Node-IP>>:32080/configmanager/all-config
```
expected response:: {"country":"india","ln":"saw","education":"bsc","city":"bangalore","fn":"naresh","company":"nokia"}

- ***Get specific key(ln)***
```bash
curl http://<<Node-IP>>:32080/configmanager?key=ln
```
expected response:: {"value":"saw","key":"ln"}
- ***Get specific key(fn)***
```bash
curl http://<<Node-IP>>:32080/configmanager?key=fn
```
expected response: {"value":"naresh","key":"fn"}