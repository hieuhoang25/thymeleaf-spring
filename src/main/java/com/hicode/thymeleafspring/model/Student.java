package com.hicode.thymeleafspring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Student {
    private String name;
    private Boolean gender;
    private Double marks;
    private Contact contact;
    private List<String> subjects;
    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    public static class Contact{
        private String email;
        private String phone;
    }
}
