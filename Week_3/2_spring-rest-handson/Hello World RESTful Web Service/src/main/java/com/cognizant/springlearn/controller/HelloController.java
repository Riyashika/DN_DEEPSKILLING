package com.cognizant.springlearn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@Slf4j
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        log.info("Start sayHello() function");
        String response = "Hello World!";
        log.info("End sayHello() function");
        return response;
    }
}