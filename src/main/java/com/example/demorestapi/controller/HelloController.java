package com.example.demorestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello-springboot")
    String welcome() {
        return "Welcome to the World of Springboot";
    }

    @GetMapping(value = "/hello/{name}")
    String displayName(@PathVariable String name) {
        return "Hello "+name;
    }

}
