package com.barbershop.modules.appointment.repository;

import com.barbershop.modules.appointment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    boolean existsByDescription(String description);
}
