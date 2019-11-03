package sabillon.spring.profile.example.service;

import java.util.List;

public interface PersonService<E, O> {

    String logInitializedPersonService();

    void save(E object);

    List<O> findAll();
}
