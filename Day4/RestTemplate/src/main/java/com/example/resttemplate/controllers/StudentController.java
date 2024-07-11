package com.example.resttemplate.controllers;

import com.example.resttemplate.beans.StudentMap;
import com.example.resttemplate.entity.Student;
import com.example.resttemplate.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentDAO studentDAO;

    @GetMapping("/index")
    public String index(Model model){
        Student student = new Student();
        model.addAttribute("form", student);
        StudentMap studentMap = studentDAO.findAll();
        model.addAttribute("list", studentMap);
        return "student/list";
    }

    @PostMapping("/create")
    public String create(Student student){
        studentDAO.create(student);
        return "redirect:/students/index";
    }

    @GetMapping("/edit{key}")
    public String edit(String key, Model model){
        Student student = studentDAO.findByKey(key);
        model.addAttribute("form", student);
        StudentMap studentMap = studentDAO.findAll();
        model.addAttribute("list", studentMap);
        return "student/list";
    }

    @PostMapping("/update{key}")
    public String update(String key, Student student){
        studentDAO.update(key, student);
        return "redirect:/students/index";
    }

    @GetMapping("/delete{key}")
    public String delete(String key){
        studentDAO.delete(key);
        return "redirect:/students/index";
    }


}
