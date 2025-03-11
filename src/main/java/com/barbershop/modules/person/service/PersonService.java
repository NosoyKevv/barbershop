package com.barbershop.modules.person.service;

import com.barbershop.modules.person.dto.PersonDto;
import com.barbershop.modules.person.model.Person;
import com.barbershop.modules.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService implements IPersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person findPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el id " + id));
    }

    @Override
    public Person savePerson(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        this.personRepository.deleteById(id);
    }
}
