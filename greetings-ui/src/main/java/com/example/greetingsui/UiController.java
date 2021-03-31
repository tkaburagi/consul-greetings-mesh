package com.example.greetingsui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class UiController {

    private final RestTemplate restTemplate;
    private static final String protocol = "http://";

    public UiController(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Value( "${ingress_url}" )
    private String ingress_url;
    @Value( "${service_fqdn}" )
    private String service_fqdn;

    @GetMapping(value = "/")
    public String japan(Model model) {
        ResponseEntity<String> response =
                this.restTemplate.exchange(protocol + ingress_url + "/api/v1/hello",
                        HttpMethod.GET,
                        new HttpUtil().setEntiry(service_fqdn),
                        String.class);
        if (response.getBody().contains("USA")) {
            model.addAttribute("message", response.getBody() + " 🇺🇸 👋");
        } else if (response.getBody().contains("Japan")
        ) {
            model.addAttribute("message", response.getBody() + " 🇯🇵 👋");
        }
        return "ui/index";
    }
}
