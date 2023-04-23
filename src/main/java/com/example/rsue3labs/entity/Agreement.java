package com.example.rsue3labs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "agreement")
public class Agreement {
    @Id
    @GeneratedValue
    private long id;
    private long personId;
    private long typeAgreementId;
    private long statusAgreementId;
    private long numberAgreement;
    private Date dateOpen;
    private Date dateClose;

    @Override
    public String toString() {
        return "Agreement{" +
                "id=" + id +
                ", personId=" + personId +
                ", typeAgreementId=" + typeAgreementId +
                ", statusAgreementId=" + statusAgreementId +
                ", numberAgreement=" + numberAgreement +
                ", dateOpen=" + dateOpen +
                ", dateClose=" + dateClose +
                '}';
    }
}
