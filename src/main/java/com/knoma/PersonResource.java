package com.knoma;

import com.knoma.pojo.Person;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import java.util.Map;
import java.util.UUID;

@Path("/person")
public class PersonResource {

    private final PersonService personService;

    @Inject
    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Multi<Person> all() {
        return personService.getAllReactive();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Map<String, Long>> count() {
        return personService.getCountReactive().map(count -> Map.of("count", count));
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Person> getById(@PathParam("id") UUID id) {
        return personService.getByIdReactive(id);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Void> delete(@PathParam("id") UUID id) {
        return personService.deleteReactive(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Void> save(Person person) {
        return personService.saveReactive(person);
    }
}
