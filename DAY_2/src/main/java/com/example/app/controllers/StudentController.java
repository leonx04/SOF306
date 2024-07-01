package com.example.app.controllers;

import com.example.app.entity.SinhViens;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.File;
import java.util.List;
import java.util.Optional;


@Controller

public class StudentController {

    @RequestMapping("/student")
    public String index(Model model,
        @RequestParam("index")Optional <Integer> index) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        File path = ResourceUtils.getFile("classpath:static/SinhViens.json");
        TypeReference < List< SinhViens > > typeReference = new TypeReference <>() {};
        List < SinhViens > sinhViens = mapper.readValue(path, typeReference);
        int i = index.orElse(0);
        model.addAttribute("sinhViens", sinhViens.get(i));
        model.addAttribute("n", i);
        return "student/index";
    }

}
