package com.example.rsue3labs.controllers;

import com.example.rsue3labs.contollers.CreatingPersonController;
import com.example.rsue3labs.entity.Person;
import com.example.rsue3labs.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CreatingPersonController.class)
public class CreatingPersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonRepository personRepository;

    private Person testPerson;

    @BeforeEach
    void setUp() {
        testPerson = new Person();
        testPerson.setId(1L);
        testPerson.setShifer("testShifer");
        testPerson.setInn("1234567890");
        testPerson.setType("PHYSICAL");
    }

    @Test
    void testShowForm() throws Exception {
        mockMvc.perform(get("/create-person"))
                .andExpect(status().is4xxClientError())
                .andExpect(view().name("create-person"))
                .andExpect(model().attributeExists("person"));
    }

    @Test
    void testProcessPerson() throws Exception {
        mockMvc.perform(post("/create-person")
                .param("shifer", "testShifer")
                .param("inn", "1234567890")
                .param("cb_physical", "true"))
                .andExpect(status().is4xxClientError())
                .andExpect(redirectedUrl("/"));

        verify(personRepository, times(1)).save(any(Person.class));
    }
}