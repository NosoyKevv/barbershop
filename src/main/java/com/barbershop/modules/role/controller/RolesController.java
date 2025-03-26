package com.barbershop.modules.role.controller;


import com.barbershop.modules.role.dto.RoleCreate;
import com.barbershop.modules.role.dto.RoleResponse;
import com.barbershop.modules.role.service.Impl.RolesServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/barbershop/roles")
@Tag(name = "Roles", description = "EndPoints Roles")
public class RolesController {

    private final RolesServiceImpl rolesService;

    public RolesController(RolesServiceImpl rolesService) {
        this.rolesService = rolesService;
    }

    @PostMapping("/")
    @Operation(description = "Created rol")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Rol created"),
            @ApiResponse(responseCode = "409", description = "Rol name already exists")
    })
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody RoleCreate request) {
        rolesService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(description = "Updated rol")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Rol created"),
            @ApiResponse(responseCode = "404", description = "Rol id not found"),
            @ApiResponse(responseCode = "409", description = "Rol name already exists")
    })
    public ResponseEntity<RoleResponse> update(@Valid @PathVariable Long id, @RequestBody RoleCreate request) {
        rolesService.update(id, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    @Operation(description = "Deleted rol")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Rol deleted"),
            @ApiResponse(responseCode = "404", description = "Rol id not found")
    })
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        rolesService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(description = "List all")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Roles listed"),
    })
    public Page<RoleResponse> getAll(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return rolesService.list(pageable);
    }
}
