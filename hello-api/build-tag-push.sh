#!/bin/sh
cd /Users/kabu/hashicorp/consul/greetings-mesh/hello-api
./mvnw clean package -DskipTests
pwd
docker build -t tkaburagi/hello-api .
docker tag tkaburagi/hello-api gcr.io/se-kabu/hello-api
docker push gcr.io/se-kabu/hello-api
pwd