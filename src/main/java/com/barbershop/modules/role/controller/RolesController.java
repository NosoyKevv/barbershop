package com.barbershop.modules.role.controller;

import com.barbershop.modules.role.dto.RolesDto;
import com.barbershop.modules.role.model.Roles;
import com.barbershop.modules.role.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/barbershop/roles")
public class RolesController {

    @Autowired
    private IRolesService rolesService;

    @GetMapping
    public ResponseEntity<List<RolesDto>> listRoles() {
        List<Roles> roles = rolesService.listRoles();
        List<RolesDto> rolesDto = roles.stream()
                .map(role -> new RolesDto(role.getId(), role.getName())).toList();
        return ResponseEntity.ok(rolesDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolesDto> findRoleById(@PathVariable Long id) {
        Roles role = this.rolesService.findRoleById(id);
        RolesDto rolesDto = new RolesDto(role.getId(), role.getName());
        return ResponseEntity.ok(rolesDto);
    }

    @PostMapping
    public ResponseEntity<RolesDto> createRole(@RequestBody Roles roles) {
        Roles role = this.rolesService.saveRoles(roles);
        RolesDto rolesDto = new RolesDto(role.getId(), role.getName());
        return ResponseEntity.ok(rolesDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolesDto> updateRole(@PathVariable Long id, @RequestBody RolesDto requestRoleDto) {
        Roles role = this.rolesService.findRoleById(id);
        if (role == null) {
            return ResponseEntity.notFound().build();
        }
        role.setName(requestRoleDto.getName());

        this.rolesService.saveRoles(role);

        RolesDto rolesDto = new RolesDto(role.getId(), role.getName());
        return ResponseEntity.ok(rolesDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id) {
        this.rolesService.deleteRoles(id);
        return ResponseEntity.ok("Rol eliminado correctamente -> " + id);

    }


}
