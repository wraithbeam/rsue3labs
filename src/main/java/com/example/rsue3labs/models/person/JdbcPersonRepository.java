package com.example.rsue3labs.models.person;

import com.example.rsue3labs.utils.SampleRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcPersonRepository extends SampleRepository<Person> {
    public JdbcPersonRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public Iterable<Person> findAll() {
        return jdbcTemplate.query("select * from Person", this::mapRowToPerson);
    }

    @Override
    public Optional<Person> findById(long id) {
        List<Person> results = jdbcTemplate.query(
                "select * from Person where id=?",
                this::mapRowToPerson, id);
        return results.size() == 0 ?
                Optional.empty() :
                Optional.of(results.get(0));
    }

    @Override
    public Person save(Person person) {
        jdbcTemplate.update(
                "insert into Person(id, shifer, inn, type, date) values (?,?,?,?,?)",
                person.getId(), person.getShifer(), person.getInn(), person.getType(), person.getDate()
        );
        return person;
    }

    private Person mapRowToPerson(ResultSet row, int rowNum)
            throws SQLException {
        return new Person(
                row.getLong("id"),
                row.getString("name"),
                row.getInt("inn"),
                row.getString("type"),
                row.getDate("date"));
    }
}
