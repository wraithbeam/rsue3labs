package com.example.rsue3labs.models.status;

import com.example.rsue3labs.models.person.Person;
import com.example.rsue3labs.utils.SampleRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcStatusAgreementRepo extends SampleRepository<StatusAgreement> {
    public JdbcStatusAgreementRepo(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public Iterable<StatusAgreement> findAll() {
        return null;
    }

    @Override
    public Optional<StatusAgreement> findById(long id) {
        List<StatusAgreement> results = jdbcTemplate.query(
                "select * from StatusAgreement where id=?",
                this::mapRowToStatus, id);
        return results.size() == 0 ?
                Optional.empty() :
                Optional.of(results.get(0));
    }

    @Override
    public StatusAgreement save(StatusAgreement status) {
        jdbcTemplate.update(
                "insert into StatusAgreement(id, type) values (?,?)",
                status.getId(), status.getStatus());
        return status;
    }

    private StatusAgreement mapRowToStatus(ResultSet row, int rowNum)
            throws SQLException {
        return new StatusAgreement(
                row.getLong("id"),
                row.getString("status"));
    }
}
