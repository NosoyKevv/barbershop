package com.barbershop.modules.person.service;

import com.barbershop.modules.person.dto.PersonDto;
import com.barbershop.modules.person.model.Person;

import java.util.List;

public interface IPersonService {

    public List<Person> findAllPersons(); // Obtener todas las personas

    public Person findPersonById(Long id); // Buscar por id

    public Person savePerson(Person person); // Guardar nueva persona o actualizar

    public void deletePerson(Long id); // Eliminar persona por id

}
