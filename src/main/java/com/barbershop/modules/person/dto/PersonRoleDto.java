package com.barbershop.modules.person.dto;

import com.barbershop.modules.role.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonRoleDto {
    private String name;

    private String lastName;

    private String email;

    private String phone;

}
