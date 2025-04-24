package com.peanut.example.extensionpoints.service.impl;

import com.peanut.example.extensionpoints.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author peanut
 * @description HelloServiceImpl
 */
@Service
@Slf4j
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        log.info("HelloServiceImpl load {}",name);
        return "hello," + name;
    }
}
