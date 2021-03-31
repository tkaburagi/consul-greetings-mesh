#!/bin/sh
cd /Users/kabu/hashicorp/consul/greetings-mesh/greetings-api
./mvnw clean package -DskipTests
pwd
docker build -t tkaburagi/greetings-api .
docker tag tkaburagi/greetings-api gcr.io/se-kabu/greetings-api
docker push gcr.io/se-kabu/greetings-api
pwd