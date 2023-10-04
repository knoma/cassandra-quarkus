package com.knoma;


import com.knoma.pojo.Person;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.UUID;

@ApplicationScoped
public class PersonService {
    private final PersonDAO personDAO;

    @Inject
    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public Uni<Void> saveReactive(Person person) {
        return Uni.createFrom().voidItem().invoke(() -> personDAO.update(person));
    }

    public Multi<Person> getAllReactive() {
        return Multi.createFrom().iterable(personDAO.findAll());
    }

    public Uni<Person> getByIdReactive(UUID id) {
        return Uni.createFrom().item(() -> personDAO.getById(id));
    }

    public Uni<Void> deleteReactive(UUID id) {
        return Uni.createFrom().voidItem().invoke(() -> personDAO.delete(id));
    }

    public Uni<Long> getCountReactive() {
        return Uni.createFrom().item(() -> personDAO.count());
    }
}
