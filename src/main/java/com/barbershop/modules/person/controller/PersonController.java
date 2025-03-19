package com.barbershop.modules.person.controller;

import com.barbershop.modules.person.dto.PersonDto;
import com.barbershop.modules.person.dto.PersonRoleDto;
import com.barbershop.modules.person.dto.PersonasRolName;
import com.barbershop.modules.person.model.Person;
import com.barbershop.modules.person.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/barbershop/person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonDto>> findAll() {
        List<Person> person = this.personService.findAllPerson();
        List<PersonDto> personDtoSimples = person.stream()
                .map(p -> new PersonDto(p.getName(),
                        p.getLastName(),
                        p.getEmail(),
                        p.getPhone())).toList();

        return ResponseEntity.ok(personDtoSimples);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> findById(@PathVariable Long id) {
        Person person = this.personService.findPersonById(id);
        PersonDto personDto = new PersonDto(person.getName(), person.getLastName(), person.getEmail(), person.getPhone());

        return ResponseEntity.ok(personDto);
    }

    @PostMapping
    public ResponseEntity<PersonRoleDto> savePerson(@RequestBody Person person) {
        Person savedPerson = this.personService.savePerson(person);
        PersonRoleDto personRoleDto = new PersonRoleDto(
                savedPerson.getName(),
                savedPerson.getLastName(),
                savedPerson.getEmail(),
                savedPerson.getPhone());
        return ResponseEntity.ok(personRoleDto);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        Person updatePerson = this.personService.findPersonById(id);

        updatePerson.setName(person.getName());
        updatePerson.setLastName(person.getLastName());
        updatePerson.setEmail(person.getEmail());
        updatePerson.setPhone(person.getPhone());

        this.personService.savePerson(updatePerson);
        return ResponseEntity.ok("La persona se actualizo correctamente -> " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        this.personService.deletePerson(id);
        return ResponseEntity.ok("Persona eliminado correctamente -> " + id);
    }

    //Buscar personas por un mismo rol -> id ->  ?id=2
    @GetMapping("/buscar")
    public List<PersonDto> findPersonsByRole(@RequestParam Long id) {
        List<Person> person = this.personService.findPersonsByRole(id);
        List<PersonDto> personDto = person.stream()
                .map(p -> new PersonDto(p.getName(), p.getLastName(), p.getEmail(), p.getPhone())).toList();
        return personDto;
    }

    //Buscar nombre del rol por id
    @GetMapping("/buscar/{id}")
    public String findNameRolByPerson(@PathVariable Long id) {
        return this.personService.findNameRolByPerson(id);
    }

    //Buscar personas con cierto rol y devolver un dto con esa info
    @GetMapping("/personrol/{id}")
    public List<PersonasRolName> findPersonRolesName(@PathVariable Long id) {
        return this.personService.findPersonRolesName(id);
    }
}
