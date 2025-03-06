package com.barbershop.modules.user.model;

import com.barbershop.common.utils.BaseEntity;
import com.barbershop.modules.person.model.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users extends BaseEntity {
    private String username;
    private String password;

    @OneToOne
    @JoinColumn(name = "person_id", unique = true, nullable = false, foreignKey = @ForeignKey(name="fk_user_person"))
    private Person person;
}
