package com.barbershop.modules.person.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PersonasRolName {
    private String name;
    private String lastName;
    private String role;

    public PersonasRolName(String name, String lastName, String role) {
        this.name = name;
        this.lastName = lastName;
        this.role = role;
    }
}
