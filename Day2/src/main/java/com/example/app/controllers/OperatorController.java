package com.example.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OperatorController {

    @RequestMapping("/operator")
    public String index(Model model) {
        model.addAttribute("x", 5);
        model.addAttribute("y", 3);
        return "operator/index";
    }
}
