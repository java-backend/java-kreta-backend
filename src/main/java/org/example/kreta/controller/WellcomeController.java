package org.example.kreta.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class WellcomeController {

    // https://studygyaan.com/spring-boot/thymeleaf-and-bootstrap-5-template-engine-in-spring-boot
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
