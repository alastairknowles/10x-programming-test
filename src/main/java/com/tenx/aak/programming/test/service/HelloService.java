package com.tenx.aak.programming.test.service;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public Map<String, String> sayHello() {
        return Map.of("hello", "world");
    }

}