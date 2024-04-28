package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public  String hello(){

    return "hello world from spring boot  controller with dev tools".toUpperCase();
    }
    @GetMapping("/workout")
    public  String workout(){
        return  "hello from workout endpoint";
    }

}
