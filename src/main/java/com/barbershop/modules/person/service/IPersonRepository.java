package com.barbershop.modules.person.service;

import com.barbershop.modules.person.model.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPersonRepository {

    List<Person> findAllPerson();

    Person findPersonById(Long id);

    Person savePerson(Person person);

    ResponseEntity<Person> delete(Long id);
}
