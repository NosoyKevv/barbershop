package com.barbershop.modules.person.model;

import com.barbershop.common.utils.BaseEntity;
import com.barbershop.modules.appointment.model.Appointment;
import com.barbershop.modules.role.model.Roles;
import com.barbershop.modules.user.model.Users;
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
public class Person extends BaseEntity {

    private String name;

    private String lastName;

    private String email;

    private String phone;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false, foreignKey = @ForeignKey(name = "fk_person_role"))
    private Roles role;

}


