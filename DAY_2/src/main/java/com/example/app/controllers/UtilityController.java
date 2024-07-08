package com.example.app.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.example.app.beans.SinhVien;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UtilityController {

    @RequestMapping("/utility")
    public String utility(Model model) throws IOException {
        File file = new ClassPathResource("/static/students.json").getFile();
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<SinhVien>> typeReference = new TypeReference<List<SinhVien>>(){};
        List<SinhVien> sinhViens = mapper.readValue(file, typeReference);
        model.addAttribute("SinhViens", sinhViens);
        model.addAttribute("now", new Date());
        return "utility/index";
    }
}