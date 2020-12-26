package com.predisw.forone.gui.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

    //todo: the charset is ignored in response header
    //todo: to solve chinese mess issue by set utf-8 in HTML file.
    @GetMapping(value = "/", produces={"text/html;charset=UTF-8"})
    public String index(Model model){
        model.addAttribute("welcome","Hello world Thymeleaf");
        return "index";
    }

    @GetMapping("/health_check")
    public String healthCheck(){
        return "The service is running normally";
    }

}
