package com.barbershop.modules.person.repository;

import com.barbershop.modules.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
