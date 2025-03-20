package com.barbershop.modules.appointment.controller;

import org.springframework.http.ResponseEntity;
import com.barbershop.modules.appointment.dto.AppointmentCreate;
import com.barbershop.modules.appointment.dto.AppointmentRequest;
import com.barbershop.modules.appointment.dto.AppointmentResponse;
import com.barbershop.modules.appointment.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/barbershop/Appointment")
@Tag(name = "Appointment", description = "API Appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{id}")
    @Operation(description = "Find appointment by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Appointment exist"),
            @ApiResponse(responseCode = "404", description = "Appointment not found")
    })
    public AppointmentResponse findById(@PathVariable Long id) {
        return appointmentService.findByAppointmentId(id);
    }

    @PostMapping("/")
    @Operation(description = "Created new appointment")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Appointment created"),
            @ApiResponse(responseCode = "409", description = "Conflict: Description already in use")
    })
    public ResponseEntity<HttpStatus> createdAppointment(@Valid @RequestBody AppointmentCreate appointmentCreate) {
        appointmentService.create(appointmentCreate);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(description = "Updated new appointment")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Appointment successfully updated"),
            @ApiResponse(responseCode = "404", description = "Appointment not found"),
            @ApiResponse(responseCode = "409", description = "Conflict: Description already in use")
    })
    public AppointmentResponse updatedAppointment(@Valid @PathVariable Long id, @RequestBody AppointmentRequest request) {
        return appointmentService.update(id, request);
    }

}
