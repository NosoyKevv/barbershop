package com.barbershop.modules.person.model;

import com.barbershop.modules.person.dto.RequestPerson;
import com.barbershop.modules.role.model.Roles;
import com.barbershop.modules.role.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    @Autowired
    private RolesRepository rolesRepository;

    public Person toEntity(RequestPerson dto) {
        Person person = new Person();
        person.setName(dto.getName());
        person.setLastName(dto.getLastName());
        person.setEmail(dto.getEmail());
        person.setPhone(dto.getPhone());

        Roles role = rolesRepository.findById(dto.getId()).orElseThrow(() -> new IllegalArgumentException("No se encontro el rol"));
        person.setRole(role);
        return person;
    }

}
