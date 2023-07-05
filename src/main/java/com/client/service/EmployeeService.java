package com.client.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.client.entity.EmployeeTbl;
import com.client.model.EmployeeAddressResonse;
import com.client.model.EmployeeTblModel;

@Service
public interface EmployeeService {
	
	public EmployeeTbl saveEmployee(EmployeeTbl empEntity);

	public EmployeeTbl convertBeanToEntity(EmployeeTblModel empModel);
	
	public EmployeeTblModel convertEntityToBean(EmployeeTbl empEntity);
	
	public List<EmployeeTblModel> fetchAllEmployees();
	
	public EmployeeTblModel fetchEmployeeById(int id);
	
	public List<EmployeeTblModel> fetchEmployeesBySortPage(int pageNo, int pageSize, String name);
	
	public String deleteEmpById(int id);
	
	public String updateEmpNameUsingQuery(String empName,int id);
	
	public EmployeeTblModel findByEmpName(String empName);
	
	public List<EmployeeAddressResonse> findEmpAddInfo();
	
}
