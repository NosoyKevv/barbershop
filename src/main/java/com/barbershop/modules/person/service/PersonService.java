package com.barbershop.modules.person.service;

import com.barbershop.common.exception.UserNotFoundException;
import com.barbershop.modules.person.model.Person;
import com.barbershop.modules.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;


    @Override
    public List<Person> findAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Person findPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Persona no se encontro con ese ID: " + id));
    }

    @Override
    public Person savePerson(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public ResponseEntity<Void> deletePerson(Long id) {
        Person person = this.personRepository.findById(id)
                .orElseThrow(
                        () -> new UserNotFoundException("Persona no encontrado con ID: " + id));
        this.personRepository.delete(person);
        return ResponseEntity.ok().build();
    }
}

