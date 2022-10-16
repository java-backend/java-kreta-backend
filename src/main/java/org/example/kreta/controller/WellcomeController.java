package org.example.kreta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WellcomeController {
    @RequestMapping(value={"","/","/index"},name = "The main page")
    public String index() {
        return "index";
    }
}
