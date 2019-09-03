package com.rambo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("hi-service")
public interface FeignHiClient {

    @GetMapping("/hi")
    public String hi(@RequestParam("name") String name);

}
