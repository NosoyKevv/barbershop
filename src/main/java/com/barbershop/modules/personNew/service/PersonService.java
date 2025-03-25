package com.barbershop.modules.personNew.service;

import com.barbershop.modules.personNew.dto.PersonCreate;
import com.barbershop.modules.personNew.dto.PersonResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PersonService {

    void create(PersonCreate request);

    PersonResponse findPersonById(Long id);

    PersonResponse update(Long id, PersonCreate request);

    Page<PersonResponse> listAll(Long rolId, Pageable pageable);

    void delete(Long id);
}
