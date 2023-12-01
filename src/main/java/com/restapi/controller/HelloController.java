package com.restapi.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class HelloController {

    @GetMapping("/hello")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/adminHello")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminHello() {
        return "Admin - Hello World";
    }

}
