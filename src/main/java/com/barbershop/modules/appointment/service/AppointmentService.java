package com.barbershop.modules.appointment.service;

import com.barbershop.modules.appointment.dto.AppointmentCreate;
import com.barbershop.modules.appointment.dto.AppointmentResponse;
import com.barbershop.modules.appointment.dto.AppointmentRequest;


public interface AppointmentService {

    AppointmentResponse findByAppointmentId(Long id);

    void create(AppointmentCreate request);

    AppointmentResponse update(Long id, AppointmentRequest request);

}
