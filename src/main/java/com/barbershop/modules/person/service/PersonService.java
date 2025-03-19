package com.barbershop.modules.person.service;

import com.barbershop.common.exception.UserNotFoundException;
import com.barbershop.modules.person.dto.PersonasRolName;
import com.barbershop.modules.person.model.Person;
import com.barbershop.modules.person.repository.PersonRepository;
import com.barbershop.modules.role.model.Roles;
import com.barbershop.modules.role.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

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

    public List<Person> findPersonsByRole(Long id) {
        return personRepository.findPersonsByRole(id);
    }

    public String findNameRolByPerson(Long id) {
        if (!this.rolesRepository.existsById(id)) {
            throw new UserNotFoundException("Rol no encontrado con ID: " + id);
        }
        return this.personRepository.findNameByRole(id);
    }

    public List<PersonasRolName> findPersonRolesName(Long id) {
        if (!this.rolesRepository.existsById(id)) {
            throw new UserNotFoundException("Rol no encontrado con ID: " + id);
        }
        return this.personRepository.findPersonRolesName(id);
    }
}

