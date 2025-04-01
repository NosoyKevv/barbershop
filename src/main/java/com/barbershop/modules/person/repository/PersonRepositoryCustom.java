package com.barbershop.modules.person.repository;

import com.barbershop.modules.person.dto.PersonRequest;
import com.barbershop.modules.person.dto.PersonResponse;

import java.util.List;

public interface PersonRepositoryCustom {

    List<PersonResponse> findPersonByRolAndLastName(PersonRequest request);
}
