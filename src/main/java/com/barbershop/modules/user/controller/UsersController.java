package com.barbershop.modules.user.controller;


import com.barbershop.modules.user.dto.UserCreate;
import com.barbershop.modules.user.dto.UserPasswordChange;
import com.barbershop.modules.user.model.Users;
import com.barbershop.modules.user.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/barbershop/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/{id}")
    @Operation(description = "Find by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Users exists"),
            @ApiResponse(responseCode = "404", description = "Users not found")
    })
    public Users findById(@PathVariable long id) {
        return usersService.findById(id);
    }

    @PostMapping
    @Operation(description = "Users created")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "User created"),
            @ApiResponse(responseCode = "409", description = "User already exists")
    })
    public ResponseEntity<HttpStatus> create(@RequestBody UserCreate request) {
        usersService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(description = "Update data user")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Updated data"),
            @ApiResponse(responseCode = "409", description = "Data already exists"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<HttpStatus> updatePass(@PathVariable Long id, @RequestBody UserPasswordChange request) {
        usersService.updatePass(id, request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
