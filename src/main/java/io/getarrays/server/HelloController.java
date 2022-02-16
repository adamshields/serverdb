package com.adam.consumeapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello world";
    }
    @GetMapping(value = "/callclienthello")
    private String getHelloClient() {
        String uri = "http://localhost:9000/hello";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }
    @GetMapping(value = "/endpoints")
    public List<Object> getEndpoints() {
        String url = "http://127.0.0.1:8000/api3/software/?format=json";
        RestTemplate restTemplate = new RestTemplate();
        Object[] endpoints = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(endpoints);
    }
}
