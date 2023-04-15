package com.example.rsue3labs.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Data
@Table
public class Agreement {
    @Id
    private long id;
    private long personId;
    private long typeAgreementId;
    private long statusAgreementId;
    private long numberAgreement;
    private Date dateOpen;
    private Date dateClose;

    public Agreement(Person person, TypeAgreement typeAgreement, StatusAgreement statusAgreement, long numberAgreement, Date dateOpen, Date dateClose) {
        this.personId = person.getId();
        this.typeAgreementId = typeAgreement.getId();
        this.statusAgreementId = statusAgreement.getId();
        this.numberAgreement = numberAgreement;
        this.dateOpen = dateOpen;
        this.dateClose = dateClose;
    }
}
