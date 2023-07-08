package com.hicode.thymeleafspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/operator")
public class OperatorController {
    @RequestMapping
    public String demo(Model model){
        model.addAttribute("x", 5);
        model.addAttribute("y", 7);
        model.addAttribute("message", "Hello");
        return "home/operator";
    }
}
