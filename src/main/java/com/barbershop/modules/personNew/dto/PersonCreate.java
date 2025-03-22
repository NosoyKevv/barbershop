package com.barbershop.modules.personNew.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class PersonCreate {
    @NotBlank
    @Size(max = 50)
    @JsonProperty(value = "person_name")
    private String name;

    @NotBlank
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

    @NotNull(message = "person document type obligatorio")
    @Size(max = 50)
    @JsonProperty(value = "document_type")
    private String documentType;

    @NotBlank
    @JsonProperty(value = "person_rol_id")
    private Long rolId;
}
