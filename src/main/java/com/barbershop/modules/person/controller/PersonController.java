package com.barbershop.modules.person.controller;

import com.barbershop.modules.person.dto.PersonCreate;
import com.barbershop.modules.person.dto.PersonResponse;
import com.barbershop.modules.person.service.PersonService;
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

    @GetMapping("/list/{id}")
    @Operation(description = "List person")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Person listed"),
            @ApiResponse(responseCode = "409", description = "Person not active"),
            @ApiResponse(responseCode = "404", description = "Person id not found")
    })
    public PersonResponse listPerson(@PathVariable Long id) {
        return personService.findPersonById(id);
    }

    @PutMapping("/{id}")
    @Operation(description = "Update person")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Person successfully updated"),
            @ApiResponse(responseCode = "404", description = "Person id not found"),
            @ApiResponse(responseCode = "409", description = "Person email already exists")
    })
    public PersonResponse update(@Valid @PathVariable Long id, @RequestBody PersonCreate request) {
        return personService.update(id, request);
    }

    @GetMapping("/page/{rolId}")
    @Operation(description = "List page person")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Person page listed"),
            @ApiResponse(responseCode = "404", description = "Person rol id not found")
    })
    public Page<PersonResponse> listAll(@PathVariable Long rolId,
                                        @RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return personService.listAll(rolId, pageable);

    }

    @PutMapping("/delete{id}")
    @Operation(description = "Deleted soft")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Person deleted soft"),
            @ApiResponse(responseCode = "404", description = "Person not found"),
    })
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }
}
