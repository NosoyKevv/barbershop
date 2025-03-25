package com.barbershop.modules.personNew.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PersonResponse {

    @NotNull(message = "el name es obligatorio")
    @Size(max = 50)
    @JsonProperty(value = "person_name")
    private String name;

    @NotNull(message = "el last_name es obligatorio")
    @Size(max = 50)
    @JsonProperty(value = "person_last_name")
    private String lastName;

    @NotNull(message = "el email es obligatorio")
    @Size(max = 50)
    @JsonProperty(value = "person_email")
    private String email;

    @NotNull(message = "el phone es obligatorio")
    @Size(max = 50)
    @JsonProperty(value = "person_phone")
    private String phone;

    @NotNull(message = "el rolName es obligatorio")
    @Size(max = 50)
    @JsonProperty(value = "person_rol_name")
    private String rolName;

}
