package com.rambo.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignClientController {

    @Autowired
    FeignHiClient feignHiClient;

    @GetMapping("/hi")
    public String hi(@RequestParam("name") String name) {
        return feignHiClient.hi(name);
    }
}