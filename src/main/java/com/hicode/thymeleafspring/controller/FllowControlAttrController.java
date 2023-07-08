package com.hicode.thymeleafspring.controller;

import com.hicode.thymeleafspring.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.security.auth.Subject;
import java.util.List;
import java.util.Optional;

@RequestMapping("/students")
@Controller
public class FllowControlAttrController {

    public static  final List<Student> STUDENTS = List.of(
            new Student("Hoang Van Hieu",
                    true,
                    10.0,
                    new Student.Contact("hieuhoang25@gmail.com", "0776231312"),
                    List.of("JAVA","TypeScript", "Nodejs")),
            new Student("Bui Van Sinh",
                                true,
                                4.0,
                                new Student.Contact("hieuhoang25@gmail.com", "0776231312"),
                    List.of("JAVA", "HTML"," CSS")),
            new Student("Nguyen Ba Hoang",
                    true,
                    8.5,
                    new Student.Contact("hieuhoang25@gmail.com", "0776231312"),
                    List.of("Nestjs")),
            new Student("Nguyen Viet Cuong",
                    true,
                    5.0,
                    new Student.Contact("hieuhoang25@gmail.com", "0776231312"),
                    List.of("JAVA"))

    );
    @GetMapping
    public String index(@RequestParam("index") Optional<Integer> index, Model model){
        model.addAttribute("students", STUDENTS);
        model.addAttribute("student", STUDENTS.get(index.orElse(0)));
        return "home/student";
    }
}
