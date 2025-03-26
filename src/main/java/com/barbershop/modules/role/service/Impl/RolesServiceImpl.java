package com.barbershop.modules.role.service.Impl;

import com.barbershop.common.exception.ResourceConflictException;
import com.barbershop.common.exception.ResourceNotFoundException;
import com.barbershop.modules.role.dto.RoleCreate;
import com.barbershop.modules.role.dto.RoleResponse;
import com.barbershop.modules.role.model.Roles;
import com.barbershop.modules.role.repository.RolesRepository;
import com.barbershop.modules.role.service.RolesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class RolesServiceImpl implements RolesService {

    private final RolesRepository rolesRepository;

    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public void create(RoleCreate request) {
        if (rolesRepository.existsByName(request.getName())) {
            throw new ResourceConflictException("Role name already exists");
        }
        Roles role = Roles.createRol(
                request.getName(),
                request.getActive());

        rolesRepository.save(role);
    }

    @Override
    public Roles findRoleById(Long id) {
        return rolesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not found"));
    }

    @Override
    public String findRoleNameById(Long id) {
        Roles role = rolesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not found"));
        return role.getName();
    }

    @Override
    public RoleResponse update(Long id, RoleCreate request) {
        Roles role = rolesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not found"));
        if (rolesRepository.existsByName(request.getName())) {
            throw new ResourceConflictException("Role name already exists");
        }
        role.setName(request.getName());
        role.setActive(request.getActive());

        rolesRepository.save(role);

        String active = role.getActive() ? "ACTIVE" : "INACTIVE";

        return new RoleResponse(role.getName(), active);
    }

    @Override
    public void delete(Long id) {
        Roles role = rolesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not found"));
        role.setActive(false);

        rolesRepository.save(role);
    }

    @Override
    public Page<RoleResponse> list(Pageable pageable) {
        Page<Roles> roles = rolesRepository.findAll(pageable);
        return roles.map(role -> new RoleResponse(role.getName(),
                role.getActive() ? "ACTIVE" : "INACTIVE"));//todo se aplica a cada elemento de la lista
    }
}