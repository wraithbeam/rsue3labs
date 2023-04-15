package com.example.rsue3labs.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;


@Data
@Table
public class Person {
    @Id
    private long id;
    private String shifer;
    private int inn;
    private String type;
    private Date date;
}
