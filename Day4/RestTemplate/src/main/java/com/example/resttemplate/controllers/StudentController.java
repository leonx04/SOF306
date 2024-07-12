package com.example.resttemplate.controllers;

import com.example.resttemplate.beans.StudentMap;
import com.example.resttemplate.entity.Student;
import com.example.resttemplate.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentDAO studentDAO;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("form", new Student());
        model.addAttribute("list", studentDAO.findAll());
        return "student/list";
    }

    @PostMapping("/create")
    public String create(Student student) {
        studentDAO.create(student);
        return "redirect:/students/index";
    }

    @GetMapping("/edit{key}")
    public String edit(@PathVariable String key, Model model) {
        model.addAttribute("form", studentDAO.findByKey(key));
        model.addAttribute("key", key);
        model.addAttribute("list", studentDAO.findAll());
        return "student/list";
    }

    @PostMapping("/update{key}")
    public String update(@PathVariable String key, Student student) {
        studentDAO.update(key, student);
        return "redirect:/students/index";
    }

    @GetMapping("/delete{key}")
    public String delete(@PathVariable String key) {
        studentDAO.delete(key);
        return "redirect:/students/index";
    }
    
}