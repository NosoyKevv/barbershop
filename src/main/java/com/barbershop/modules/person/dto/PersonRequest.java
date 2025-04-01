package com.barbershop.modules.person.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.Date;

@Getter
public class PersonRequest {

    @Size(max = 50)
    @JsonProperty(value = "person_name")
    private String name;

    @Size(max = 50)
    @JsonProperty(value = "person_last_name")
    private String lastName;

    @Size(max = 50)
    @JsonProperty(value = "person_email")
    private String email;

    @Size(max = 50)
    @JsonProperty(value = "person_phone")
    private String phone;

    @Size(max = 50)
    @JsonProperty(value = "person_rol_name")
    private String rolName;
}
