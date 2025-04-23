package com.peanut.example.extensionpoints.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author peanut
 * @description 健康检查
 */
@RestController
public class HealthCheckController {

    @GetMapping("/health")
    public String healthCheck() {
        return "ok";
    }
}
