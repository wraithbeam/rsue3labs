package com.example.rsue3labs.models.agreement;

import com.example.rsue3labs.models.status.StatusAgreement;
import com.example.rsue3labs.models.type.TypeAgreement;
import com.example.rsue3labs.models.person.Person;
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

    public Agreement(long id, long person, long typeAgreement, long statusAgreement, long numberAgreement, Date dateOpen, Date dateClose) {
        this.id = id;
        this.personId = person;
        this.typeAgreementId = typeAgreement;
        this.statusAgreementId = statusAgreement;
        this.numberAgreement = numberAgreement;
        this.dateOpen = dateOpen;
        this.dateClose = dateClose;
    }
}
