package com.hicode.thymeleafspring.controller;

import com.hicode.thymeleafspring.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model){
        Item item = new Item(1, "Hoang Van Hieu", LocalDateTime.now());
        model.addAttribute("message", "Welcome to My Page");
        model.addAttribute("item", item);
        return "home/index";
    }
}
