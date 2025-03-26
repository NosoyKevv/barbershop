package com.barbershop.modules.role.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RoleResponse {
    private String roleName;

    private String active;
}
