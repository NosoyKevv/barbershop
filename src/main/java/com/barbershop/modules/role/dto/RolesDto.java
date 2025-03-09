package com.barbershop.modules.role.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RolesDto {
    private Long id;
    private String name;

    public RolesDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
