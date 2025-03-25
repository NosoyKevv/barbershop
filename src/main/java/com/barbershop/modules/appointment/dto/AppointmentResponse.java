package com.barbershop.modules.appointment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@Getter
public class AppointmentResponse {

    @NotBlank
    @Size(max = 50)
    @JsonProperty(value = "appointment_description")
    private String description;

    @NotNull(message = "el date es obligatorio")
    @JsonProperty(value = "appointment_date")
    private Date date;

    @NotNull(message = "el date_time es obligatorio")
    @JsonProperty(value = "appointment_date_time")
    private Time dateTime;

    @NotNull(message = "el user_name es obligatorio")
    @JsonProperty(value = "appointment_user_name")
    private String userName;
}
