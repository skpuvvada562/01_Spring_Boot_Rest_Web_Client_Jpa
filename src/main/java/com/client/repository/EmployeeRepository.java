package com.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.entity.EmployeeTbl;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeTbl,Integer>{

}
