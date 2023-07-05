package com.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.entity.Aadhar;

@Repository
public interface AadharRepository extends JpaRepository<Aadhar, Integer>{

}
