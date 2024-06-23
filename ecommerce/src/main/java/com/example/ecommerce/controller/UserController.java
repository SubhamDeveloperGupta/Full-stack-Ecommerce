package com.example.ecommerce.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @GetMapping("/user")
    public String user(@RequestParam String name) {
        return "Hello World! Name : " + name;
    }


}
