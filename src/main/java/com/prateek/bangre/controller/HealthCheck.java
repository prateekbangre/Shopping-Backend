package com.prateek.bangre.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
@RestController
public class HealthCheck {

    @GetMapping("/healthcheck")
    private String getHealthCheck(){
        return "working.....!!!!!";
    }
}
