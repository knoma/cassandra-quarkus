package org.acme;

import org.acme.pojo.Person;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class PersonService {
    PersonDAO personDAO;

    @Inject
    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public void save(Person person) {
        personDAO.update(person);
    }

    public List<Person> getAll() {
        return personDAO.findAll().all();
    }

    public Person getById(UUID id) {
        return personDAO.getById(id);
    }

    public void delete(UUID id) {
        personDAO.delete(id);
    }

    public Long getCount() {
        return personDAO.count();
    }
}
