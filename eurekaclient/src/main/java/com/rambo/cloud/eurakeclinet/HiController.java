package com.rambo.cloud.eurakeclinet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HiController {

    private static final Logger logger = LoggerFactory.getLogger(HiController.class);

    @Value("${server.port:default}")
    String port;

    @GetMapping("/hi")
    public String hi(@RequestParam("name") String name) {
        String message = "hi, " + name + ", port:" + port;
        logger.info(message);
        return message;
    }

}