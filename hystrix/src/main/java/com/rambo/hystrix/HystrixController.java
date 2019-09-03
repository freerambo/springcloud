package com.rambo.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HystrixController {

    @Autowired
    HystrixHiService hystrixHiService;

    @GetMapping("/hi")
    public String hi(@RequestParam("name") String name) {
        return hystrixHiService.hiService(name);
    }
}