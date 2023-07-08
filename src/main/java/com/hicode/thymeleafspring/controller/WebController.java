package com.hicode.thymeleafspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import static com.hicode.thymeleafspring.controller.FllowControlAttrController.STUDENTS;

@Controller
@RequestMapping("/home")
public class WebController {

    @GetMapping("/index")
    public String index(){
        return "home/index2";
    }
    @GetMapping("/about")
    public String about(){
        return "home/about";
    }
    @GetMapping("/student-management")
    public String students(@RequestParam("index") Optional<Integer> index, Model model){
        model.addAttribute("student", STUDENTS.get(index.orElse(0)));
        model.addAttribute("students", STUDENTS);
        return "home/student-management";
    }

}
