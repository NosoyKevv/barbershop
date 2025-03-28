package com.barbershop.modules.person.repository;

import com.barbershop.modules.person.dto.PersonResponse;
import com.barbershop.modules.person.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Long>, PersonRepositoryCustom {

    boolean existsByEmail(String email);

    @Query("SELECT new com.barbershop.modules.person.dto.PersonResponse (p.name,p.lastName,p.email,p.phone,r.name)  " +
            "FROM Person p " +
            "INNER JOIN  p.role r " +
            "WHERE r.id = :rolId " +
            "AND p.active != FALSE")
    Page<PersonResponse> findByRoleId(@Param("rolId") Long rolId, Pageable pageable);
}
