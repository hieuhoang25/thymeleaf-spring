package com.hicode.thymeleafspring.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variable-expressions")
@RequiredArgsConstructor
public class ScopeController {

    private final HttpServletRequest request;
    private final HttpSession session;
    private final ServletContext servletContext;
    @RequestMapping()
    public String helloModel(Model model){
        model.addAttribute("a", "I am in model");
        request.setAttribute("b", "I am in request");
        session.setAttribute("c", "I am in session");
        servletContext.setAttribute("d", "I am in application");
        return "home/scope";
    }
}
