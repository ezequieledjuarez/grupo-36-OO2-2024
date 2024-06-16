package com.unla.grupo36.services;
import java.util.List;
import java.util.Optional;

import com.unla.grupo36.dtos.PersonDTO;
import com.unla.grupo36.entities.Person;

public interface IPersonService {

	public List<Person> getAll();

	public Optional<Person> findById(int id) throws Exception;

	public Person findByName(String name) throws Exception;

	public Person insertOrUpdate(Person person);

	public boolean remove(int id);

	public List<PersonDTO> findByDegreeName(String degreeName);
}

