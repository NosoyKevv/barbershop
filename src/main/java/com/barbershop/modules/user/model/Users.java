package com.barbershop.modules.user.model;

import com.barbershop.common.utils.BaseEntity;
import com.barbershop.modules.person.model.Person;
import com.barbershop.modules.role.model.Roles;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users extends BaseEntity {
    @Column(name = "user_name")
    private String userName;

    private String password;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_person_user"))
    private Person person;

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_role_user"))
    @JsonBackReference
    private Roles roles;
}
