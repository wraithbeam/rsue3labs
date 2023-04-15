package com.example.rsue3labs.models.agreement;

import com.example.rsue3labs.models.type.TypeAgreement;
import com.example.rsue3labs.utils.SampleRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JdbcAgreementRepo extends SampleRepository<Agreement> {

    public JdbcAgreementRepo(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public Iterable<Agreement> findAll() {
        return jdbcTemplate.query("select * from Agreement", this::mapRowToAgreement);
    }

    @Override
    public Optional<Agreement> findById(long id) {
        List<Agreement> results = jdbcTemplate.query(
                "select * from Agreement where id=?",
                this::mapRowToAgreement, id);
        return results.size() == 0 ?
                Optional.empty() :
                Optional.of(results.get(0));
    }

    @Override
    public Agreement save(Agreement object) {
        return null;
    }

    private Agreement mapRowToAgreement(ResultSet row, int rowNum)
            throws SQLException {
        return new Agreement(
                row.getLong("id"),
                row.getLong("personId"),
                row.getLong("typeAgreementId"),
                row.getLong("statusAgreementId"),
                row.getLong("numberAgreement"),
                row.getDate("dateOpen"),
                row.getDate("dateClose")
                );
    }
}
