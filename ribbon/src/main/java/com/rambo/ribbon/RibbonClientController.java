package com.rambo.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonClientController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hi")
    public String hi(@RequestParam("name") String name) {
        return restTemplate.getForEntity("http://HI-SERVICE/hi?name=" + name, String.class).getBody();
    }
}