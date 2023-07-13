package com.hicode.thymeleafspring.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandling {
    @ExceptionHandler(UnauthorizedException.class)
    private ModelAndView throwException(UnauthorizedException exception){
        ModelAndView model = new ModelAndView("home/401");
        model.addObject("error", exception.getMessage());
        return model;
    }
}
