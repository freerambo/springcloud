package com.rambo.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HystrixHiService {

    private static final Logger logger = LoggerFactory.getLogger(HystrixHiService.class);

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiServiceFallback")
    public String hiService(String name) {
        logger.info("in hiService");
        return restTemplate.getForEntity("http://HI-SERVICE/hi?name=" + name, String.class).getBody();
    }

    /**
     * should be same parameter list
     *
     * @param name
     * @return
     */
    public String hiServiceFallback(String name) {
        logger.error(name);
        return "error - " + name;
    }

}