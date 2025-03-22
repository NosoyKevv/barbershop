package com.barbershop.modules.appointment.model;

import com.barbershop.common.utils.BaseEntity;
import com.barbershop.modules.user.model.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Appointment extends BaseEntity {

    private String description;

    private Date date;

    @Column(name = "date_time")
    private Time dateTime;

    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true, foreignKey = @ForeignKey(name = "fk_appointment_users"))
    private Users user;

    private Appointment(String description, Date date, Time dateTime, Users user) {
        this.description = description;
        this.date = date;
        this.dateTime = dateTime;
        this.user = user;
    }

    public static Appointment createAppointment(String description, Date date, Time dateTime, Users user) {
        return new Appointment(description, date, dateTime, user);
    }
}
