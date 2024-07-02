package com.example.app.controllers;

import com.example.app.beans.SinhVien;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class SinhViens2Controller {
    @RequestMapping("/students2/list")
    public String list(Model model, @RequestParam("index") Optional<Integer> index) throws IOException {
        File file = new ClassPathResource("/static/SinhViens2.json").getFile();
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<SinhVien>> type = new TypeReference<List<SinhVien>>() {};
        List<SinhVien> list = objectMapper.readValue(file, type);

        model.addAttribute("sv", list.get(index.orElse(0)));
        model.addAttribute("list", list);
        return "students2/list";
    }
}