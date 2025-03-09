package com.barbershop.modules.role.service;

import com.barbershop.modules.role.model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IRolesService {

    List<Roles> listRoles();

    Roles findRoleById(Long id);

    Roles saveRoles(Roles roles);

    ResponseEntity<String> deleteRoles(Long id);
}
