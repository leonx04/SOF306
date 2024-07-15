package com.example.app.controller;

import com.example.app.entity.Student;
import com.example.app.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest")
public class StudentController {
    @Autowired
    StudentDAO studentDAO;
    @GetMapping("/students")
    public List<Student> getAl(Model model) {
        return studentDAO.findAll();
    }
    @GetMapping("/students/{email}")
    public Student getOne(@PathVariable("email") String email) {
        return studentDAO.findById(email).get();
    }

    @PostMapping("/students")
    public Student save(@RequestBody Student student) {
        return studentDAO.save(student);
    }
    @PutMapping("/students/{email}")
    public Student update(@PathVariable("email") String email, @RequestBody Student student) {
        return studentDAO.save(student);
    }
    @DeleteMapping("/students/{email}")
    public void delete(@PathVariable("email") String email) {
        studentDAO.deleteById(email);
    }
}
