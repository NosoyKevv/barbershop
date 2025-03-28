package com.barbershop.modules.person.repository.Impl;

import com.barbershop.modules.person.dto.PersonResponse;
import com.barbershop.modules.person.model.Person;
import com.barbershop.modules.person.model.Person_;
import com.barbershop.modules.person.repository.PersonRepositoryCustom;
import com.barbershop.modules.role.model.Roles;
import com.barbershop.modules.role.model.Roles_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;

import java.util.List;


public class PersonRepositoryImpl implements PersonRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    @Override
//    public List<PersonResponse> findPersonByRolAndLastName(Long id, String lastName) {
    public List<PersonResponse> findPersonByRolAndLastName(String rolName) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        List<PersonResponse> result = null;

        try {
            CriteriaQuery<PersonResponse> cq = cb.createQuery(PersonResponse.class);
            Root<Person> root = cq.from(Person.class);
            Join<Person, Roles> rolesJoin = root.join(Person_.role, JoinType.INNER);

            cq.select(cb.construct(
                            PersonResponse.class,
                            root.get(Person_.name),
                            root.get(Person_.lastName),
                            root.get(Person_.email),
                            root.get(Person_.phone),
                            rolesJoin.get(Roles_.name)
                    )
            );
            cq.where(cb.equal(rolesJoin.get(Roles_.name), rolName));    //,cb.equal(root.get(Person_.lastName),lastName)
            result = em.createQuery(cq).getResultList();
        } catch (Exception ex) {
            System.out.println("Error en consulta Criteria getAllDiagnostics  {} " + ex.getMessage());
        }
        em.close();
        return result;
    }
}

