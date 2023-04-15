package com.example.rsue3labs.contollers;

import com.example.rsue3labs.repository.StatusAgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private StatusAgreementRepository agreementRepository;

    @GetMapping("/")
    public String home() {
        agreementRepository.findAll();
        return "home";
    }
}
