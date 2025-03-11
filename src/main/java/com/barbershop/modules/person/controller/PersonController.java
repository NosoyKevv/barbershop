package com.barbershop.modules.person.controller;

import com.barbershop.modules.person.dto.PersonDto;
import com.barbershop.modules.person.model.Person;
import com.barbershop.modules.person.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping
    public List<PersonDto> getAllPersons() {
        return personService.findAllPersons()
                .stream()
                .map(PersonDto::new) // Convertir cada Person a PersonDto
                .collect(Collectors.toList()); // Convertir el Stream en una lista
    }


    @GetMapping("/{id}")
    public PersonDto findPersonById(@PathVariable Long id) {
        Person person = personService.findPersonById(id);
        return new PersonDto(person);
    }

    @PostMapping
    public Person savePerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        person.setId(id);
        return personService.savePerson(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }

}
