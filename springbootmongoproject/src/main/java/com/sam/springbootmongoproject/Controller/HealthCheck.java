package com.sam.springbootmongoproject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/health-check")
    public String HealthCheck(){
        return "Application is Up and Running...";
    }
}
