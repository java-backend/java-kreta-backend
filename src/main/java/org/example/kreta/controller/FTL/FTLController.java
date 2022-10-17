package org.example.kreta.controller.FTL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/ftl")
public class FTLController {
    private static final String kreta = "Kréta";

    @RequestMapping(value={"","/","/index"},name = "FreeMarker home page")
    public String Index() {
        return "index";
    }

    @GetMapping(value = "/welcome",name = "FreeMarker welcome page")
    public String hello(Map<String, Object> model) {
        model.put("message", kreta);
        return "welcome";
    }
}
