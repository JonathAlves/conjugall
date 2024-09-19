package com.guerradev.controller;

import com.guerradev.model.Person;
import com.guerradev.service.PersonService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/person")
public class PersonResource {
    private final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @POST
    @Transactional
    public Response createPerson(@Valid Person person) {
        return Response.ok(personService.createPerson(person)).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") UUID id) {
        return Response.ok(personService.getPersonById(id)).build();
    }

    @GET
    public Response getAllPerson(@QueryParam("page") @DefaultValue("0") Integer page, @QueryParam("pageSize") @DefaultValue("10") Integer pageSize){
        return Response.ok(personService.getAllPerson(page, pageSize)).build();
    }
}
