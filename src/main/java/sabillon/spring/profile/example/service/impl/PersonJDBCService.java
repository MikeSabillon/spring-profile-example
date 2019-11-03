package sabillon.spring.profile.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sabillon.spring.profile.example.dto.PersonDTO;
import sabillon.spring.profile.example.repository.PersonJDBCRepository;
import sabillon.spring.profile.example.service.PersonService;

import java.util.List;

@Profile("jdbc")
@Service
@RequiredArgsConstructor
public class PersonJDBCService implements PersonService<PersonDTO, PersonDTO> {

    private final PersonJDBCRepository personJDBCRepository;

    @Override
    public String logInitializedPersonService() {
        return "Initializing JDBC Service";
    }

    @Override
    public void save(PersonDTO object) {
        this.personJDBCRepository.save(object);
    }


    @Override
    public List<PersonDTO> findAll() {
        return this.personJDBCRepository.findAll();
    }
}
