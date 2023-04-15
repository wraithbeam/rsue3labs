package com.example.rsue3labs.models.type;

import com.example.rsue3labs.models.person.Person;
import com.example.rsue3labs.models.status.StatusAgreement;
import com.example.rsue3labs.utils.SampleRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JdbcTypeAgreementRepo extends SampleRepository<TypeAgreement> {
    public JdbcTypeAgreementRepo(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public Iterable<TypeAgreement> findAll() {
        return jdbcTemplate.query("select * from TypeAgreement", this::mapRowToType);
    }

    @Override
    public Optional<TypeAgreement> findById(long id) {
        List<TypeAgreement> results = jdbcTemplate.query(
                "select * from TypeAgreement where id=?",
                this::mapRowToType, id);
        return results.size() == 0 ?
                Optional.empty() :
                Optional.of(results.get(0));
    }

    @Override
    public TypeAgreement save(TypeAgreement agreement) {
        jdbcTemplate.update(
                "insert into TypeAgreement(id, type) values (?,?)",
                agreement.getId(), agreement.getType());
        return agreement;
    }

    private TypeAgreement mapRowToType(ResultSet row, int rowNum)
            throws SQLException {
        return new TypeAgreement(
                row.getLong("id"),
                row.getString("type"));
    }
}
