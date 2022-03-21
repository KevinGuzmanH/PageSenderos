package com.keviny.paginasenderos.controller;


import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping(path = "home")
    public String getHome(){
        return "home";
    }

    @GetMapping(path = "contact")
    public String getContact(){
        return "contact";
    }
}
