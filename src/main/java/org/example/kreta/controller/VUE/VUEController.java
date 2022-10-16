package org.example.kreta.controller.VUE;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vue")
public class VUEController {
    @RequestMapping("/index")
    public String Index() {
        return "vue/index";
    }

}
