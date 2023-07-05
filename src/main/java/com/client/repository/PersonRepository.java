package com.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

}
