package com.hicode.thymeleafspring.controller;

import com.hicode.thymeleafspring.exception.UnauthorizedException;
import com.hicode.thymeleafspring.model.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class HomeController {
    //https://github.com/hieuhoang25?page=2&tab=repositories
    @RequestMapping("/hieuhoang25?id=23&tab=repositories")
    public String index(Model model, @RequestParam("page") String page, @RequestParam("tab") String tab){
        Item item = new Item(1, "Hoang Van Hieu", LocalDateTime.now());
        model.addAttribute("message", "Welcome to My Page");
        model.addAttribute("item", item);
        if (page==null && tab!=null){
            return  "add";
        }
        if (page==null && tab==null){
            return  "edit";
        }


        return "home/index.html";
    }
    @RequestMapping("/user/{name}/tung/{ho}")
    public String index(@PathVariable("name") String name){
       throw new UnauthorizedException();
    }
}
