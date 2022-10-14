package org.example.kreta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/th")
public class ThymeleafController {

    @RequestMapping(value={"","/","/index"},name = "Thymeleaf web page home")
    public String Index() {
        return "th/index";
    }

    @RequestMapping(value = "welcome",name = "Thymeleaf welcame web page home")
    public String Welcome(Model model) {
        model.addAttribute("kreta","Kréta");
        return "th/welcome";
    }
}
