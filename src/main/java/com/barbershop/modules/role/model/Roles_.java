package com.barbershop.modules.role.model;

import com.barbershop.common.utils.BaseEntity;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Roles.class)
public abstract class Roles_ extends BaseEntity {
    public static volatile SingularAttribute<Roles, String> name;
    public static volatile SingularAttribute<Roles, Boolean> active;
}
