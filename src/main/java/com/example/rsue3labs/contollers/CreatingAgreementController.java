package com.example.rsue3labs.contollers;

import com.example.rsue3labs.entity.Agreement;
import com.example.rsue3labs.entity.Person;
import com.example.rsue3labs.entity.StatusAgreement;
import com.example.rsue3labs.entity.TypeAgreement;
import com.example.rsue3labs.repository.AgreementRepository;
import com.example.rsue3labs.repository.PersonRepository;
import com.example.rsue3labs.repository.StatusAgreementRepository;
import com.example.rsue3labs.repository.TypeAgreementRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/create-agreement")
public class CreatingAgreementController {
    private final AgreementRepository agreementRepository;
    private final PersonRepository personRepository;
    private final TypeAgreementRepository typeAgreementRepository;
    private final StatusAgreementRepository statusAgreementRepository;

    @Autowired
    public CreatingAgreementController(AgreementRepository agreementRepository, PersonRepository personRepository, TypeAgreementRepository typeAgreementRepository, StatusAgreementRepository statusAgreementRepository) {
        this.agreementRepository = agreementRepository;
        this.personRepository = personRepository;
        this.typeAgreementRepository = typeAgreementRepository;
        this.statusAgreementRepository = statusAgreementRepository;
    }

    @GetMapping
    public String showForm(Model model) {
        putAgreement(model);
        putOptions(model);
        return "create-agreement";
    }

    private void putAgreement(Model model) {
        Map<String, Agreement> map = new HashMap<>();
        map.put("agreement", new Agreement());
        model.addAllAttributes(map);
    }

    private void putOptions(Model model) {
        List<StatusAgreement> statuses = castToList(statusAgreementRepository.findAll());
        List<TypeAgreement> types = castToList(typeAgreementRepository.findAll());
        List<Person> persons = castToList(personRepository.findAll());
        model.addAttribute("statuses", statuses);
        model.addAttribute("types", types);
        model.addAttribute("persons", persons);
    }

    private <T> List<T> castToList(Iterable<T> iterable) {
        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    private <T> Map<String, T> surroundMap(String name, T object) {
        return (Map<String, T>) new HashMap<>().put(name, object);
    }

    @PostMapping
    public String processAgreement(
            @Valid @ModelAttribute Agreement agreement, Errors errors) {
        if (errors.hasErrors())
            return "create-agreement";

        agreement.setDateOpen(new Date(System.currentTimeMillis()));
        agreementRepository.save(agreement);
        log.info("Added: {}", agreement);
        return "redirect:/";
    }


}
