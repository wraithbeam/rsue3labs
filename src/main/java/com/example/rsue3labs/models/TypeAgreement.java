package com.example.rsue3labs.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class TypeAgreement {
    @Id
    private long id;
    private String type;
}
