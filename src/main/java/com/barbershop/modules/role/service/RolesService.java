package com.barbershop.modules.role.service;

import com.barbershop.common.exception.UserNotFoundException;
import com.barbershop.modules.role.model.Roles;
import com.barbershop.modules.role.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService implements IRolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public List<Roles> listRoles() {
        return this.rolesRepository.findAll();
    }

    @Override
    public Roles findRoleById(Long id) {
        return this.rolesRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Rol no encontrado con ID: " + id));
    }

    @Override
    public Roles saveRoles(Roles roles) {
        return this.rolesRepository.save(roles);
    }

    @Override
    public ResponseEntity<String> deleteRoles(Long id) {
        if (!this.rolesRepository.existsById(id)) {
            throw new UserNotFoundException("Rol no encontrado con ID: " + id);
        }
        this.rolesRepository.deleteById(id);

        return ResponseEntity.ok("Rol eliminado correctamente -> " + id);
    }
}
