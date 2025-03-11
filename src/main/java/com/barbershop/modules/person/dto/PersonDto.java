package com.barbershop.modules.person.dto;

import com.barbershop.modules.person.model.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDto {

    private String name;
    private String lastName;
    private String email;
    private String phone;

    // Constructor para convertir una entidad Person en un DTO
    public PersonDto(Person person) {
        this.name = person.getName();
        this.lastName = person.getLastName();
        this.email = person.getEmail();
        this.phone = person.getPhone();
    }
}
