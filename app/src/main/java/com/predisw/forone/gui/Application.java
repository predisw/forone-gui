package com.predisw.forone.gui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication  // same as @Configuration @EnableAutoConfiguration @ComponentScan
@ComponentScan(basePackages = {"com.predisw.forone.gui"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @RequestMapping("/health_check")
    public String healthCheck(){
        return "The service is running normally";
    }


}
