package com.example.rsue3labs.settings.models;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<MyUser, Long> {
    MyUser findByUsername(String username);
}
