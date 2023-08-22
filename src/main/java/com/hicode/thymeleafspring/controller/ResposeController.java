package com.hicode.thymeleafspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/v1/response")
public class ResposeController {

    @GetMapping
    public ModelAndView  response(){
        ModelAndView modelAndView = new ModelAndView("response");
        modelAndView.addObject("response", "Test");
        return modelAndView;
    }
    @GetMapping("/test")
    public String  response1(Model model){
        model.addAttribute("response", "Test test");
        return "response";
    }
}
