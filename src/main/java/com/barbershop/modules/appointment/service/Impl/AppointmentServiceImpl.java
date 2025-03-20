package com.barbershop.modules.appointment.service.Impl;

import com.barbershop.common.exception.ResourceConflictException;
import com.barbershop.common.exception.ResourceNotFoundException;
import com.barbershop.modules.appointment.dto.AppointmentCreate;
import com.barbershop.modules.appointment.dto.AppointmentRequest;
import com.barbershop.modules.appointment.dto.AppointmentResponse;
import com.barbershop.modules.appointment.model.Appointment;
import com.barbershop.modules.appointment.repository.AppointmentRepository;
import com.barbershop.modules.appointment.service.AppointmentService;
import com.barbershop.modules.user.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final UsersService usersService;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, UsersService usersService) {
        this.appointmentRepository = appointmentRepository;
        this.usersService = usersService;
    }

    @Override
    public AppointmentResponse findByAppointmentId(Long id) {
        return appointmentRepository.findById(id)
                .map(appointment -> new AppointmentResponse(
                        appointment.getDescription(),
                        appointment.getDate(),
                        appointment.getDateTime(),
                        appointment.getUser().getUsername()))
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found"));
    }

    @Transactional
    @Override
    public void create(AppointmentCreate request) {
        if (appointmentRepository.existsByDescription(request.getDescription())) {
            //Solo es para probar o tener una estructura de como se hace obviamente la validacion no tiene cavida acá
            throw new ResourceConflictException("Ya existe una appointment con esa descripcion");
        }
        Appointment appointment = Appointment.createAppointment(
                request.getDescription(),
                request.getDate(),
                request.getDateTime(),
                usersService.findUserById(request.getUserId())
        );
        appointmentRepository.save(appointment);
    }

    @Transactional
    @Override
    public AppointmentResponse update(Long id, AppointmentRequest request) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontro el appointment"));
        if (appointmentRepository.existsByDescription(request.getDescription())
                && !appointment.getDescription().equals(request.getDescription())) {
            throw new ResourceConflictException("Ya existe una appointment con esa descripcion");
        }

        appointment.setDescription(request.getDescription());
        appointment.setDate(request.getDate());
        appointment.setDateTime(request.getDateTime());
        appointment.setUser(usersService.findUserById(request.getUserId()));

        appointmentRepository.save(appointment);

        return new AppointmentResponse(
                appointment.getDescription(),
                appointment.getDate(),
                appointment.getDateTime(),
                appointment.getUser().getUsername()
        );
    }
}
