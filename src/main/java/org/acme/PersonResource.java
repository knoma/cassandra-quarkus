package org.acme;

import org.acme.pojo.Person;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Path("/person")
public class PersonResource {

    PersonService personService;

    @Inject
    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Person> all() throws ExecutionException, InterruptedException {
        return personService.getAll();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Long> count() throws ExecutionException, InterruptedException {
        return Map.of("count", personService.getCount());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getById(@PathParam("id") UUID id) throws ExecutionException, InterruptedException {
        return personService.getById(id);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") UUID id) throws ExecutionException, InterruptedException {
        personService.delete(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void save(Person person) {
        personService.save(person);
    }
}