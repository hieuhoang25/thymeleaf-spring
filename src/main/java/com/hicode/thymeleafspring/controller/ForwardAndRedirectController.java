package com.hicode.thymeleafspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class ForwardAndRedirectController {

    @GetMapping("/url1")
    public String view(){
        return "home/view";
    }
    @GetMapping("/url2")
    public String forWard(Model model){
        model.addAttribute("error", "Forward successfully");
        return "forward:/url1";
    }

    @GetMapping("/url3")
    public String redirect(RedirectAttributes params){
        params.addAttribute("error", "Redirect succesfully");
        return "redirect:/url1";
    }
}
