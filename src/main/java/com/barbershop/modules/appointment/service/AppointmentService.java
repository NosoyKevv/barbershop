package com.barbershop.modules.appointment.service;

import com.barbershop.modules.appointment.dto.AppointmentCreate;
import com.barbershop.modules.appointment.dto.AppointmentList;
import com.barbershop.modules.appointment.dto.AppointmentResponse;
import com.barbershop.modules.appointment.dto.AppointmentRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface AppointmentService {

    AppointmentResponse findByAppointmentId(Long id);

    void create(AppointmentCreate request);

    AppointmentResponse update(Long id, AppointmentRequest request);

    void delete(Long id);

    Page<AppointmentList> findAll(Long userId, Pageable pageable);

}
