package com.barbershop.modules.personNew.repository;

import com.barbershop.modules.personNew.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    boolean existsByEmail(String email);
}
