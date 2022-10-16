package org.example.kreta.controller.JSP;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JSPContorller {
    @RequestMapping(value={"","/","/index"})
    public String index() {
        return "jsp/index";
    }

    @RequestMapping(value="/welcome")
    public String welcome(Model model) {
        model.addAttribute("Kréta","kreta");
        return "jsp/welcome";
    }
}
