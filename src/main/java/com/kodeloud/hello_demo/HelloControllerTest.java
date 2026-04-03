package com.kodeloud.hello_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void welcome_returnsHelloMessage() throws Exception {
        mvc.perform(get("/hello").accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(content().string("Hello, KodeKloud community!"));
    }

    @Test
    public void welcome_startsWithExpectedGreeting() throws Exception {
        mvc.perform(get("/hello").accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(content().string(startsWith("Hello")));
    }

    @Test
    public void welcome_endsWithExpectedText() throws Exception {
        mvc.perform(get("/hello").accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(content().string(endsWith("community!")));
    }

    @Test
    public void welcome_responseIsNotNull() throws Exception {
        mvc.perform(get("/hello").accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(content().string(org.hamcrest.Matchers.notNullValue()));
    }

    @Test
    public void welcome_responseIsNotEmpty() throws Exception {
        mvc.perform(get("/hello").accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(content().string(org.hamcrest.Matchers.not(org.hamcrest.Matchers.emptyString())));
    }
}
