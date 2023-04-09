package com.tenx.aak.programming.test.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

class HelloServiceTest {

    private final HelloService helloService = new HelloService();

    @Test
    void shouldSayHello() {
        // When
        Map<String, String> response = helloService.sayHello();

        // Then
        assertThat(response).isEqualTo(Map.of("hello", "world"));
    }

}