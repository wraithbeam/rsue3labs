package com.example.rsue3labs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "type_agreement")
public class TypeAgreement {
    @Id
    @GeneratedValue
    private long id;
    private String type;
}
