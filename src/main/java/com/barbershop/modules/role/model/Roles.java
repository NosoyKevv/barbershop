package com.barbershop.modules.role.model;

import com.barbershop.common.utils.BaseEntity;
import com.barbershop.modules.person.model.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Roles extends BaseEntity {
    private String name;

    private Boolean active = true;

    @OneToMany(mappedBy = "role")
    private List<Person> persons;

    public Roles(String name, Boolean active) {
        this.name = name;
        this.active = active;
    }

    public static Roles createRol(String name, Boolean active) {
        return new Roles(name, active);
    }

}
