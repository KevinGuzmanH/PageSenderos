package com.keviny.paginasenderos.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping(path = "test")
public class Controller {

    @GetMapping
    public String getArticles(Model model){
        List<Integer> stars = new ArrayList<>();
        stars.add(5);
        stars.add(1);
        stars.add(3);
        stars.add(3);
        stars.add(3);
        stars.add(3);
        model.addAttribute("starts",stars);
        return "Articles";
    }

}
