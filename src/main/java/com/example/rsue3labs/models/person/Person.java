package com.example.rsue3labs.models.person;

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


    public Person(long id, String shifer, int inn, String type, Date date) {
        this.id = id;
        this.shifer = shifer;
        this.inn = inn;
        this.type = type;
        this.date = date;
    }
}
