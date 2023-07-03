package com.client.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.client.entity.EmployeeTbl;
import com.client.model.EmployeeTblModel;

@Service
public interface EmployeeService {
	
	public EmployeeTbl saveEmployee(EmployeeTbl empEntity);

	public EmployeeTbl convertBeanToEntity(EmployeeTblModel empModel);
	
	public EmployeeTblModel convertEntityToBean(EmployeeTbl empEntity);
	
	public List<EmployeeTblModel> fetchAllEmployees();
	
	public EmployeeTblModel fetchEmployeeById(int id);
	
	public List<EmployeeTblModel> fetchEmployeesBySortPage(int pageNo, int pageSize, String name);
}
