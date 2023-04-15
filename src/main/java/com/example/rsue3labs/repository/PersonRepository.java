package com.example.rsue3labs.repository;

import com.example.rsue3labs.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
