package sabillon.spring.profile.example.repository;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sabillon.spring.profile.example.model.Person;

@ConditionalOnProperty(
        value = "spring.profiles.active",
        havingValue = "jpa",
        matchIfMissing = true)
@Repository
public interface PersonJPARepository extends JpaRepository<Person, Long> {

}
