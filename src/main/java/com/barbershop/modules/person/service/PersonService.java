package com.barbershop.modules.person.service;

import com.barbershop.modules.person.dto.PersonCreate;
import com.barbershop.modules.person.dto.PersonRequest;
import com.barbershop.modules.person.dto.PersonResponse;
import com.barbershop.modules.person.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface PersonService {

    void create(PersonCreate request);

    PersonResponse findPersonById(Long id);

    PersonResponse update(Long id, PersonCreate request);

    Page<PersonResponse> listAll(Long rolId, Pageable pageable);

    void delete(Long id);

    Person findById(Long id);

    List<PersonResponse> criteria(PersonRequest request);
}
