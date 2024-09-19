package com.guerradev.service;

import com.guerradev.exception.PersonNotFoundException;
import com.guerradev.model.Person;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class PersonService {

    public Person createPerson(Person person) {
        Person.persist(person);
        return person;
    }

    public Person getPersonById(UUID idPerson){
        return (Person) Person.findByIdOptional(idPerson).orElseThrow(PersonNotFoundException::new);
    }


    public List<Person> getAllPerson(Integer page, Integer pageSize) {
        return Person
                .findAll()
                .page(page, pageSize)
                .list();
    }
}
