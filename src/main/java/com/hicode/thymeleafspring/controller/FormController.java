package com.hicode.thymeleafspring.controller;

import com.hicode.thymeleafspring.model.OStudent;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class FormController {

    @GetMapping("/student/form")
    public String index(Model model){
        OStudent oStudent = new OStudent();
        oStudent.setFullname("Hoang Van Hieu");
        model.addAttribute("student", oStudent);
        return "home/form";
    }
    @PostMapping("/student/save")
    public String save(@Valid @ModelAttribute("student") OStudent student, Errors errors, Model model){
       log.info("{}",errors);
        if (errors.hasErrors()){
            model.addAttribute("message", "Vui long sua cac loi sau");
            return "home/form";
        }

        return "home/success";
    }

    @ModelAttribute("countries")
    Map<String, String> map(){
        Map<String, String> map = new HashMap<>();
        map.put("VN", "Viet Nam");
        map.put("US", "United States");
        return map;
    }
}
