package com.barbershop.modules.personNew.service.Impl;

import com.barbershop.common.exception.ResourceConflictException;
import com.barbershop.modules.personNew.dto.PersonCreate;
import com.barbershop.modules.personNew.model.Person;
import com.barbershop.modules.personNew.repository.PersonRepository;
import com.barbershop.modules.personNew.service.PersonService;
import com.barbershop.modules.role.service.RolesService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final RolesService rolesService; //todo CAMBIAR A NEW

    public PersonServiceImpl(PersonRepository personRepository, RolesService rolesService) {
        this.personRepository = personRepository;
        this.rolesService = rolesService;
    }

    @Override
    public void create(PersonCreate request) {
        if (personRepository.existsByEmail(request.getEmail())) {
            throw new ResourceConflictException("Person email already exists");
        }
        Person person = Person.createPerson(request.getName(),
                request.getLastName(),
                request.getPhone(),
                request.getEmail(),
                request.getDocumentType(),
                rolesService.findRoleById(request.getRolId())
        );
        personRepository.save(person);

    }

}
