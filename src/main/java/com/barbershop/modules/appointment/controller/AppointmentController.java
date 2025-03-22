package com.barbershop.modules.appointment.controller;

import com.barbershop.modules.appointment.dto.AppointmentList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
@Tag(name = "Appointment", description = "EndPoints Appointment")
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

    @PutMapping("/delete/{id}")
    @Operation(description = "Delete soft")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Appointment deleted soft"),
            @ApiResponse(responseCode = "404", description = "Appointment not found"),
    })
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.delete(id);
    }

    @GetMapping("/listAppointment/{id}")
    @Operation(description = "List all")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Appointment list all"),
            @ApiResponse(responseCode = "404", description = "Appointment user not found")
    })
    public Page<AppointmentList> findAll(@PathVariable Long id,
                                         @RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return appointmentService.findAll(id, pageable);
    }

}
