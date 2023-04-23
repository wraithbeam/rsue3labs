package com.example.rsue3labs.contollers;

import com.example.rsue3labs.entity.Person;
import com.example.rsue3labs.repository.PersonRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import static com.example.rsue3labs.utils.Consts.JURIDICAL;
import static com.example.rsue3labs.utils.Consts.PHYSICAL;

@Controller
@Slf4j
@RequestMapping("/create-person")
public class CreatingPersonController {
    private final PersonRepository personRepository;

    @Autowired
    CreatingPersonController(PersonRepository personRepo) {
        personRepository = personRepo;
    }

    @GetMapping
    public String showForm(Model model) {
        Map<String, Person> map = new HashMap<>();
        map.put("person", new Person());
        model.addAllAttributes(map);
        return "create-person";
    }

    @PostMapping
    public String processPerson(
            @Valid @ModelAttribute Person person, Errors errors,
            @RequestParam(name = "cb_physical", required = false) boolean isPhysical) {
        if (errors.hasErrors())
            return "create-person";

        person.setRegistrationDate(new Date(System.currentTimeMillis()));
        processType(person, isPhysical);
        personRepository.save(person);
        log.info("Added: {}", person);
        return "redirect:/";
    }

    private void processType(Person person, boolean isPhysical) {
        if (isPhysical)
            person.setType(PHYSICAL);
        else
            person.setType(JURIDICAL);
    }
}
