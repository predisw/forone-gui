package com.predisw.forone.gui.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    @RequestMapping("/")
    public String index(ModelMap model){
        model.addAttribute("welcome","Hello world Thymeleaf");
        return "index";
    }

    @RequestMapping("/health_check")
    public String healthCheck(){
        return "The service is running normally";
    }

}
