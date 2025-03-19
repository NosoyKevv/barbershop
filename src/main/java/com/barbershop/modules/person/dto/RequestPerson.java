package com.barbershop.modules.person.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestPerson {
    private String name;

    private String lastName;

    private String email;

    private String phone;

    private Long id;
}
