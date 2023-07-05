package com.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.client.entity.Person;
import com.client.repository.PersonRepository;

@Component
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonRepository personRepo;

	@Override
	public Person savePerson(Person person) {
		return personRepo.save(person);
	}

	@Override
	public List<Person> findPersons() {
		return personRepo.findAll();
	}
	
	
	
}
