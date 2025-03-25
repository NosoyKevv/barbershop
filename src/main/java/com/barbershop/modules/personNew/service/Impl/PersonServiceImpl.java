package com.barbershop.modules.personNew.service.Impl;

import com.barbershop.common.exception.ResourceConflictException;
import com.barbershop.common.exception.ResourceNotFoundException;
import com.barbershop.modules.personNew.dto.PersonCreate;
import com.barbershop.modules.personNew.dto.PersonResponse;
import com.barbershop.modules.personNew.model.Person;
import com.barbershop.modules.personNew.repository.PersonRepository;
import com.barbershop.modules.personNew.service.PersonService;
import com.barbershop.modules.role.repository.RolesRepository;
import com.barbershop.modules.role.service.RolesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final RolesService rolesService; //todo CAMBIAR A NEW
    private final RolesRepository rolesRepository;

    public PersonServiceImpl(PersonRepository personRepository, RolesService rolesService, RolesRepository rolesRepository) {
        this.personRepository = personRepository;
        this.rolesService = rolesService;
        this.rolesRepository = rolesRepository;
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

    @Override
    public PersonResponse findPersonById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        if (!person.getActive()) {
            throw new ResourceConflictException("Person is not active");
        }
        return new PersonResponse(
                person.getName(),
                person.getLastName(),
                person.getEmail(),
                person.getPhone(),
                rolesService.findRoleNameById(person.getRole().getId()));
    }

    @Override
    public PersonResponse update(Long id, PersonCreate request) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        if (!person.getEmail().equals(request.getEmail()) && personRepository.existsByEmail(request.getEmail())) {
            throw new ResourceConflictException("Person email already exists");
        }
        person.setName(request.getName());
        person.setLastName(request.getLastName());
        person.setPhone(request.getPhone());
        person.setEmail(request.getEmail());
        person.setRole(rolesService.findRoleById(request.getRolId()));

        personRepository.save(person);
        return new PersonResponse(
                person.getName(),
                person.getLastName(),
                person.getEmail(),
                person.getPhone(),
                rolesService.findRoleNameById(request.getRolId())
        );
    }

    @Override
    public Page<PersonResponse> listAll(Long rolId, Pageable pageable) {
        if (!rolesRepository.existsById(rolId)) {
            throw new ResourceConflictException("Role id not exists");
        }
        return personRepository.findByRoleId(rolId, pageable);
    }

    @Override
    public void delete(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        person.setActive(false);

        personRepository.save(person);
    }
}
