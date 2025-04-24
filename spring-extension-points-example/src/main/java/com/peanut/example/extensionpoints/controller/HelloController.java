package com.peanut.example.extensionpoints.controller;

import com.peanut.example.extensionpoints.service.HelloService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author peanut
 * @description HelloController
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Resource
    HelloService helloService;

    @GetMapping("/name")
    public String hello() {
        return helloService.hello("peanut");
    }


}
