package com.example.greetingsui;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Arrays;

public class HttpUtil {
    public HttpEntity setEntiry(String ingresshost) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Host", ingresshost);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return entity;
    }
}