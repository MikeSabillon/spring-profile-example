package sabillon.spring.profile.example.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sabillon.spring.profile.example.dto.PersonDTO;

import java.util.List;

@ConditionalOnProperty(
        value = "spring.profiles.active",
        havingValue = "jdbc",
        matchIfMissing = true)
@Repository
@RequiredArgsConstructor
public class PersonJDBCRepository {

    private static final String CREATE_PERSON = "INSERT INTO PERSON (id, name, last_name, age) VALUES(?,?,?,?)";
    private static final String GET_ALL_PERSONS_QUERY = "SELECT * FROM PERSON";

    private final JdbcTemplate jdbcTemplate;

    public List<PersonDTO> findAll() {
        return this.jdbcTemplate.query(GET_ALL_PERSONS_QUERY,
                (rs, rowNum) -> PersonDTO.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .lastName(rs.getString("last_name"))
                        .age(rs.getInt("age")).build());
    }

    public void save(PersonDTO entity) {
        this.jdbcTemplate.update(CREATE_PERSON,
                entity.getId(),
                entity.getName(),
                entity.getLastName(),
                entity.getAge());
    }

}
