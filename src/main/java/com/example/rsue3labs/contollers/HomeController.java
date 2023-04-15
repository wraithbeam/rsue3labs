package com.example.rsue3labs.contollers;

import com.example.rsue3labs.models.agreement.JdbcAgreementRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        var a = new JdbcAgreementRepo(new JdbcTemplate()).findAll();
        return "home";
    }
}
