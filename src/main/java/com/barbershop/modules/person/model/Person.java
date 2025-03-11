package com.barbershop.modules.person.model;

import com.barbershop.common.utils.BaseEntity;
import com.barbershop.modules.user.model.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person extends BaseEntity {

    private String name;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String phone;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Users users;
}


