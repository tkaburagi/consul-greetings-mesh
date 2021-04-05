* US
```
gcloud container clusters create lab-cluster-1 \
 --num-nodes=3 \
 --zone us-central1-c

gcloud container clusters get-credentials lab-cluster-1 \
 --zone us-central1-c \
 --project se-kabu

helm install -f us.yaml consul hashicorp/consul --wait

kc get secret consul-federation -o yaml

kc apply greetings-us.yaml
kc apply hello.yaml
```

* Japan
```
gcloud container clusters create lab-cluster-2 \
 --num-nodes=3 \
 --zone asia-northeast1-a

gcloud container clusters get-credentials lab-cluster-2 \
 --zone asia-northeast1-a \
 --project se-kabu

kc apply -f consul-federation-secret.yaml

helm install -f japan.yaml consul hashicorp/consul --wait
kc apply greetings-jp.yaml
```

* Proxy Setup
```
consul config write proxy-configs/hello-api-svc-defaults.hcl
consul config write proxy-configs/greetings-api-svc-defaults.hcl
consul config write proxy-configs/ingress-gateway.hcl
consul config write proxy-configs/greetings-resoliver.hcl
```

* Deploy UI
```
cd greetings-ui
rm -rf .git
heroku login
git init
git add .
git commit -m "first commit"
heroku create
heroku config:set ingress_url=<INGRESSGW_LB_IP>:8080
heroku config:set service_fqdn=hello-api.ingress.dc-1.consul:8080
git push heroku master
heroku open
```