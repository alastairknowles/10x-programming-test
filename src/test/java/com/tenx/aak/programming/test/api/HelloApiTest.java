package com.tenx.aak.programming.test.api;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.tenx.aak.programming.test.service.HelloService;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest
class HelloApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;

    @BeforeEach
    void setUp() {
        reset(helloService);
    }

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(helloService);
    }

    @Test
    void shouldSayHello() throws Exception {
        // Given
        when(helloService.sayHello()).thenReturn(Map.of("hello", "world"));

        // When
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/hello"));

        // When
        result.andExpect(status().isOk())
                .andExpect(content().json("{\"hello\":\"world\"}"));

        verify(helloService).sayHello();
    }

}