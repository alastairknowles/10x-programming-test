package com.tenx.aak.programming.test.api;

import com.tenx.aak.programming.test.service.HelloService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class HelloApi {

    private final HelloService helloService;

    @GetMapping
    public Map<String, String> sayHello() {
        return helloService.sayHello();
    }

}