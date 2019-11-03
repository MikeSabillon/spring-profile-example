package sabillon.spring.profile.example.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sabillon.spring.profile.example.dto.PersonDTO;
import sabillon.spring.profile.example.service.PersonService;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataBootstrap implements CommandLineRunner {

    private final PersonService personService;

    @Override
    public void run(String... args) throws Exception {
        // Log person repository to identify which repo is being initialized
        log.info(this.personService.logInitializedPersonService());
        log.info("Creating person");
        this.personService.save(PersonDTO.builder()
                .name("Miguel")
                .lastName("Sabillon")
                .age(25)
                .build());
        log.info("Retrieving Data");
        this.personService.findAll().forEach(dbPerson -> log.info(dbPerson.toString()));
    }

}
