package com.client.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.client.entity.Person;

@Service
public interface PersonService {

	public Person savePerson(Person person);
	
	public List<Person> findPersons();
}
