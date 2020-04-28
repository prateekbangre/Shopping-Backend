package com.prateek.bangre.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
@RestController
@RequestMapping("/api/healthcheck")
public class HealthCheck {

    @GetMapping
    private String getHealthCheck(){
        return "working.....!!";
    }
}
