package com.luv2code.thymleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldDemoController {
    @GetMapping("/hello")
    public  String getHello(Model uiModel){
            uiModel.addAttribute("date",new java.util.Date());
            uiModel.addAttribute("title","helloWorld");
            System.out.println("hello");
            return "helloworld";
    }
}
