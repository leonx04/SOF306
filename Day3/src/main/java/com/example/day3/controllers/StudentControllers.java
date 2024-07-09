package com.example.day3.controllers;

import com.example.day3.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentControllers {
    @GetMapping("/form")
    public String index(Model model) {
        Student student = new Student();

        student.setFullName("Y2mOc");
        student.setMark(9.0);
        student.setCountry("Vietnam");
        student.setGender(true);
        model.addAttribute("student", student);
        return "student/student";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student) {
        return "student/success";
    }
}
