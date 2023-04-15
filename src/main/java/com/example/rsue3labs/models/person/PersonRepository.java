package com.example.rsue3labs.models.person;

import java.util.Optional;

public interface PersonRepository {
    Iterable<Person> findAll();
    Optional<Person> findById(long id);
    Person save(Person person);
}
