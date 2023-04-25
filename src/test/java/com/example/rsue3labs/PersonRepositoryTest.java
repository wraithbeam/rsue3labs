package com.example.rsue3labs;

import com.example.rsue3labs.entity.Person;
import com.example.rsue3labs.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void testSaveAndFindById() {
        Person testPerson = new Person();
        testPerson.setShifer("testShifer");
        testPerson.setInn("1234567890");
        testPerson.setType("PHYSICAL");

        // Save the person
        Person savedPerson = personRepository.save(testPerson);

        // Check if saved person has an ID
        assertThat(savedPerson.getId()).isNotNull();

        // Find the person by ID
        Optional<Person> foundPerson = personRepository.findById(savedPerson.getId());

        // Check if the found person exists and has the same shifer, inn, and type as the test person
        assertThat(foundPerson).isPresent();
        assertThat(foundPerson.get().getShifer()).isEqualTo(testPerson.getShifer());
        assertThat(foundPerson.get().getInn()).isEqualTo(testPerson.getInn());
        assertThat(foundPerson.get().getType()).isEqualTo(testPerson.getType());
    }
}
