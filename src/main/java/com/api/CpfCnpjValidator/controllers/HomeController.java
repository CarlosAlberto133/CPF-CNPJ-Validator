package com.api.CpfCnpjValidator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("cpfEndpoint", "/CPF");
        model.addAttribute("cnpjEndpoint", "/CNPJ");
        model.addAttribute("cpfInput", "cpf");
        model.addAttribute("cnpjInput", "cnpj");
        return "home";
    }
}
