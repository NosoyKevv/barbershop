package com.barbershop.modules.person.model;

import com.barbershop.common.utils.BaseEntity;
import com.barbershop.common.utils.document_type.DocumentType;
import com.barbershop.modules.role.model.Roles;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Person.class)
public abstract class Person_ extends BaseEntity {
    public static volatile SingularAttribute<Person, Long> personId;
    public static volatile SingularAttribute<Person, String> name;
    public static volatile SingularAttribute<Person, String> lastName;
    public static volatile SingularAttribute<Person, String> email;
    public static volatile SingularAttribute<Person, String> phone;
    public static volatile SingularAttribute<Person, DocumentType> documentType;
    public static volatile SingularAttribute<Person, Roles> role;
}
