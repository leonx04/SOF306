package com.example.app.controllers;

import com.example.app.beans.SinhVien;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

@Controller
public class HomeController {
    @RequestMapping("/home/index")
    public String index(Model model) throws IOException {
        model.addAttribute("message", "Jung Nguyễn  <b>Hello, World!</b>");

        ObjectMapper mapper = new ObjectMapper();
        String path = "A:\\SOF306\\DAY_2\\src\\main\\resources\\static\\SinhVien.json";
        SinhVien sv = mapper.readValue(new File(path), SinhVien.class);
        model.addAttribute("sv", sv);

        return "/home/index";
    }
}
