package com.barbershop.modules.role.service;

import com.barbershop.modules.role.dto.RoleCreate;
import com.barbershop.modules.role.dto.RoleResponse;
import com.barbershop.modules.role.model.Roles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

public interface RolesService {


    void create(RoleCreate request);

    Roles findRoleById(Long id);

    String findRoleNameById(Long id);

    RoleResponse update(@PathVariable Long id, RoleCreate request);

    void delete(Long id);

    Page<RoleResponse> list(Pageable pageable);
}
