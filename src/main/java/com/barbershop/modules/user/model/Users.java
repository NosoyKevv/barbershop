package com.barbershop.modules.user.model;

import com.barbershop.common.utils.BaseEntity;
import com.barbershop.modules.appointment.model.Appointment;
import com.barbershop.modules.person.model.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users extends BaseEntity {
    private String username;
    private String password;
    private boolean active = true; // Se inicializa como activo

    @OneToOne
    @JoinColumn(name = "person_id", unique = true, nullable = false, foreignKey = @ForeignKey(name = "fk_user_person"))
    private Person person;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;
}
