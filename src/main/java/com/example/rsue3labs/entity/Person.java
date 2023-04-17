package com.example.rsue3labs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "Шифр не может быть пустым")
    private String shifer;

    @Pattern(regexp = "^\\d{10}(\\d{2})?$",
        message = "ИНН состоит из 10 цифр для физических лиц. Или 12 для юридических.")
    private String inn;

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
