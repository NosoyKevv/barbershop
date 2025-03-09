package com.barbershop.modules.person.service;

import com.barbershop.modules.person.model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonRepository {
    @Override
    public List<Person> findAllPerson() {
        return List.of();
    }

    @Override
    public Person findPersonById(Long id) {
        return null;
    }

    @Override
    public Person savePerson(Person person) {
        return null;
    }

    @Override
    public ResponseEntity<Person> delete(Long id) {
        return null;
    }
}

