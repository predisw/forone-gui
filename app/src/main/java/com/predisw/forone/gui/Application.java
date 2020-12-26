package com.predisw.forone.gui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication  // same as @Configuration @EnableAutoConfiguration @ComponentScan
@ComponentScan(basePackages = {"com.predisw.forone.gui"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
