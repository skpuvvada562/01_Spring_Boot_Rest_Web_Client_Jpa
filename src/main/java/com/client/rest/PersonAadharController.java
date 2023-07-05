package com.client.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.client.entity.Person;
import com.client.service.PersonService;

@RestController
public class PersonAadharController {

	@Autowired
	private PersonService personService;
	
	@PostMapping(value="/savePerson", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> savePerson(@RequestBody Person person){
		
		Person per=personService.savePerson(person);
		return new ResponseEntity<Person>(per, HttpStatus.CREATED);
	}
	
	
	@GetMapping(value="/findPersons", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Person>> findPersons(){
		
		List<Person> persons=personService.findPersons();
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}
}
