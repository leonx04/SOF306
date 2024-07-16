package com.example.app.controllers;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScopeController {
    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;

    @Autowired
    ServletContext context;

    @RequestMapping("/scope")
    public String index(Model model) {
        model.addAttribute("a", "Model");
        request.setAttribute("b", "Request");
        session.setAttribute("c", "Session");
        context.setAttribute("d", "Application");
        return "scope/index";
    }
}
