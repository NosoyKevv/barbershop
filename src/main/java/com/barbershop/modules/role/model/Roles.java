package com.barbershop.modules.role.model;

import com.barbershop.common.utils.BaseEntity;
import com.barbershop.modules.user.model.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Roles extends BaseEntity {

    private String name;
    private String description;

    @OneToOne(mappedBy = "roles", cascade = CascadeType.ALL)
    private Users users;
}
