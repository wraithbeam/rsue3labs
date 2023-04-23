package com.example.rsue3labs.contollers;

import com.example.rsue3labs.repository.StatusAgreementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {
    @Autowired
    private StatusAgreementRepository statusRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
