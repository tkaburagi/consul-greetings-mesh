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
```