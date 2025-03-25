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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Roles extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "role")
    private List<Person> persons;
}
