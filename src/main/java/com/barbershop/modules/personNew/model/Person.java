package com.barbershop.modules.personNew.model;

import com.barbershop.common.utils.BaseEntity;
import com.barbershop.common.utils.document_type.DocumentType;
import com.barbershop.modules.role.model.Roles;
import com.barbershop.modules.user.model.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person extends BaseEntity {

    private String name;

    private String lastName;

    private String email;

    private String phone;

    private DocumentType documentType;

    private Boolean active = true;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false, foreignKey = @ForeignKey(name = "fk_person_role"))
    private Roles role;

    private Person(String name, String lastName, String email, String phone, DocumentType documentType, Roles role) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.documentType = documentType;
        this.role = role;
    }

    public static Person createPerson(String name, String lastName, String email, String phone, DocumentType documentType, Roles role) {
        return new Person(name, lastName, email, phone, documentType, role);
    }
}
