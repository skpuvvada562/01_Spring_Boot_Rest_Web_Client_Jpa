package com.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.client.entity.EmployeeTbl;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeTbl,Integer>{
	
	@Modifying
	@Query("update EmployeeTbl emp set emp.empName=:empName where emp.empId=:id")
	public void updateEmpNameUsingQuery(@Param("empName") String empName, @Param("id") int id);
	
	@Query("select emp from EmployeeTbl emp where emp.empName=:empName")
	public EmployeeTbl findByEmpName(@Param("empName") String empName);

}
