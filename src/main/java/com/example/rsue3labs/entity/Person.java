package com.example.rsue3labs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue
    private long id;
    private String shifer;
    private int inn;
    private String type;
    private Date date;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", shifer='" + shifer + '\'' +
                ", inn=" + inn +
                ", type='" + type + '\'' +
                ", date=" + date +
                '}';
    }
}
