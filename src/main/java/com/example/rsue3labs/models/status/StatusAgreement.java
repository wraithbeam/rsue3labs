package com.example.rsue3labs.models.status;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class StatusAgreement {
    @Id
    private long id;
    private String status;

    public StatusAgreement(long id, String status) {
        this.id = id;
        this.status = status;
    }
}
