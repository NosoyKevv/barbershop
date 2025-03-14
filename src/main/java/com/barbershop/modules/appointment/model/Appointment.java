package com.barbershop.modules.appointment.model;

import com.barbershop.common.utils.BaseEntity;
import com.barbershop.modules.user.model.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Appointment extends BaseEntity {
    private String description;
    private Date date;

    @Column(name = "date_time")
    private Time dateTime;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true, foreignKey = @ForeignKey(name = "fk_appointment_users"))
    private Users user;
}
