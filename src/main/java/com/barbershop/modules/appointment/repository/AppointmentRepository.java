package com.barbershop.modules.appointment.repository;

import com.barbershop.modules.appointment.dto.AppointmentList;
import com.barbershop.modules.appointment.model.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    boolean existsByDescription(String description);

    @Query("SELECT new com.barbershop.modules.appointment.dto.AppointmentList (a.description,a.date,a.dateTime,p.name) FROM Appointment a " +
            "INNER JOIN a.user u " +
            "INNER JOIN u.person p " +
            "WHERE u.id =:userId AND a.active = TRUE " +
            "ORDER BY a.createdDateTime DESC ")
    Page<AppointmentList> findAllAppointmentBarberName(@Param("userId") Long userId, Pageable pageable);
}
