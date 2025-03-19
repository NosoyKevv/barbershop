package com.barbershop.modules.person.service;

import com.barbershop.modules.person.dto.PersonDto;
import com.barbershop.modules.person.dto.PersonasRolName;
import com.barbershop.modules.person.dto.RequestPerson;
import com.barbershop.modules.person.model.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPersonService {

    List<Person> findAllPerson();

    Person findPersonById(Long id);

    Person savePerson(Person person);

    ResponseEntity<Void> deletePerson(Long id);

    List<Person> findPersonsByRole(Long id);

    String findNameRolByPerson(Long id);

    List<PersonasRolName> findPersonRolesName(Long id);

    ResponseEntity<?> saveRequestPerson(RequestPerson requestPerson);
}
