package sabillon.spring.profile.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sabillon.spring.profile.example.dto.PersonDTO;
import sabillon.spring.profile.example.model.Person;
import sabillon.spring.profile.example.repository.PersonJPARepository;
import sabillon.spring.profile.example.service.PersonService;

import java.util.ArrayList;
import java.util.List;

@Profile("jpa")
@Service
@RequiredArgsConstructor
public class PersonJPAService implements PersonService<PersonDTO, PersonDTO> {

    private final PersonJPARepository personJPARepository;

    @Override
    public String logInitializedPersonService() {
        return "Initializing JPA Service";
    }

    @Override
    public void save(PersonDTO object) {
        this.personJPARepository.save(Person.builder()
                .id(object.getId())
                .name(object.getName())
                .lastName(object.getLastName())
                .age(object.getAge())
                .build());
    }

    @Override
    public List<PersonDTO> findAll() {
        List<PersonDTO> personsDtos = new ArrayList<>();
        List<Person> dbPerson = this.personJPARepository.findAll();

        dbPerson.forEach(person -> personsDtos.add(PersonDTO.builder()
                .id(person.getId())
                .name(person.getName())
                .lastName(person.getLastName())
                .age(person.getAge())
                .build()));

        return personsDtos;
    }
}
