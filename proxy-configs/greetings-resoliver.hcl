Kind           = "service-resolver"
Name           = "greetings-api"
ConnectTimeout = "10s"
Failover = {
  "*" = {
    Datacenters = ["dc-us", "dc-japan"]
  }
}
