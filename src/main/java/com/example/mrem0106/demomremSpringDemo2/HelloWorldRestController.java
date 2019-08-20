package com.example.mrem0106.demomremSpringDemo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldRestController {

    @GetMapping(path = "/hello")
    public HelloWorld getHelloWorld() {
        return new HelloWorld("Hello World!");
    }

}
