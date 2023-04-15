package com.example.rsue3labs.utils;

import com.example.rsue3labs.models.person.Person;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

public abstract class SampleRepository<T> {
    protected JdbcTemplate jdbcTemplate;

    public SampleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public abstract Iterable<T> findAll();
    public abstract Optional<T> findById(long id);
    public abstract T save(T object);
}
