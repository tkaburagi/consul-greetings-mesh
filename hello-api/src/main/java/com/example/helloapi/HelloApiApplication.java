package com.example.helloapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@SpringBootApplication
public class HelloApiApplication {

    final
    RestTemplate restTemplate;

    public HelloApiApplication(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloApiApplication.class, args);
    }

    @GetMapping(value = "/api/v1/hello")
    public String hello() {
        URI url = null;
        try {
            url = new URI("http://127.0.0.1:5000/api/v1/greetings");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        String greetings;
        try {
            greetings = restTemplate.getForEntity(url, String.class).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return "Greetings from something wrong";
        }
        return "Greetings from the destination: " + greetings;
    }
}
