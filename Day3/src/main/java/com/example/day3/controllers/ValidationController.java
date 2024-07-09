package com.example.day3.controllers;

import com.example.day3.entity.Student2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/validation")
public class ValidationController {
@GetMapping("/form")
    public String form(Model model) {
        Student2 student = new Student2();
        model.addAttribute("student", student);
        return "validation/form";
    }

    @PostMapping("/save")
    public String save(Model model,@Validated @ModelAttribute("student") Student2 student,
                       Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("message", "Validation failed");
            return "validation/form";
        }
        return "student/success";
    }


}
