package com.barbershop.modules.personNew.controller;

import com.barbershop.modules.personNew.dto.PersonCreate;
import com.barbershop.modules.personNew.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/barbershop/Person")
@Tag(name = "Person", description = "EndPoints Person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/")
    @Operation(description = "Create person")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Person created"),
            @ApiResponse(responseCode = "409", description = "Person email already exists")
    })
    public ResponseEntity<HttpStatus> createPerson(@Valid @RequestBody PersonCreate request) {
        personService.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
