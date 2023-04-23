package com.example.rsue3labs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "status_agreement")
public class StatusAgreement {
    @Id
    @GeneratedValue
    private long id;
    private String status;

    @Override
    public String toString() {
        return "StatusAgreement{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
