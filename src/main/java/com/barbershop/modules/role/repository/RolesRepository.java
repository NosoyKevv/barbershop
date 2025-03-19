package com.barbershop.modules.role.repository;

import com.barbershop.modules.role.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    //Validamos si el id existe
    boolean existsById(Long id);


}
