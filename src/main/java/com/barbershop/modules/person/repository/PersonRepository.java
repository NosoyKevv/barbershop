package com.barbershop.modules.person.repository;

import com.barbershop.modules.person.dto.PersonasRolName;
import com.barbershop.modules.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    //Obtener personas con cierto rol que pasa por parametros
    @Query("SELECT p FROM Person p WHERE p.role.id =:id")
    List<Person> findPersonsByRole(@Param("id") Long id);

    //Obtener nombre del id q ingresa
    @Query("SELECT r.name FROM Roles r WHERE r.id = :id ")
    String findNameByRole(@Param("id") Long id);

    //Obtener personas y su rol
    @Query("SELECT new com.barbershop.modules.person.dto.PersonasRolName(p.name,p.lastName,r.name) FROM Person p INNER JOIN p.role r WHERE r.id =:id")
    List<PersonasRolName> findPersonRolesName(@Param("id") Long id);


}
