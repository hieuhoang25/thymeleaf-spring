package com.hicode.thymeleafspring.controller;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.Date;

@Controller
@RequestMapping("/utilities")
public class UtilitiesController {
    @GetMapping()
    public String index(Model model){
        model.addAttribute("now", new Date());
        model.addAttribute("students", FllowControlAttrController.STUDENTS);
        return "home/utilities";
    }
}
