package com.RestfulWebServices.RestfulApI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {
    @GetMapping("/simple-rest-api")
    public String function(){
        return "Welcome to Spring Boot";
    }
}
