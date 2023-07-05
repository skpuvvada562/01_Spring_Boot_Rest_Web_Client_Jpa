package com.client.service;

import org.springframework.stereotype.Service;

import com.client.entity.Person;

@Service
public interface PersonService {

	public Person savePerson(Person person);
}
