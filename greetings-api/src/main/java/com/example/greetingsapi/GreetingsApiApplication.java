package com.example.greetingsapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
@SpringBootApplication
public class GreetingsApiApplication {

    @Value( "${GKE_LOCATION}" )
    private String gke_location;

    public static void main(String[] args) {
        SpringApplication.run(GreetingsApiApplication.class, args);
    }

    @GetMapping(value = "/api/v1/greetings")
    public String greetings() throws Exception {
        InetAddress ia = InetAddress.getLocalHost();
        String ip = ia.getHostAddress();
        return "Hello! I'm running on " + gke_location + " " + ip;
    }
}
