package com.client.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.client.entity.EmployeeTbl;
import com.client.model.EmployeeTblModel;
import com.client.repository.EmployeeRepository;

@Component
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public EmployeeTbl saveEmployee(EmployeeTbl empEntity){
		return empRepo.save(empEntity);
	}
	
	@Override
	public EmployeeTbl convertBeanToEntity(EmployeeTblModel empModel) {
		EmployeeTbl emp=new EmployeeTbl();
		if(empModel.getEmpId()>0)
			emp.setEmpId(empModel.getEmpId());
		emp.setEmpName(empModel.getEmpName());
		emp.setEmpAge(empModel.getEmpAge());
		emp.setEmpSalary(empModel.getEmpSalary());
		emp.setCreatedOn(new Date());
		emp.setLastLogin(new Date());
		return emp;
	}

	@Override
	public EmployeeTblModel convertEntityToBean(EmployeeTbl empEntity) {
		EmployeeTblModel model=new EmployeeTblModel();
		model.setEmpId(empEntity.getEmpId());
		model.setEmpName(empEntity.getEmpName());
		model.setEmpAge(empEntity.getEmpAge());
		model.setEmpSalary(empEntity.getEmpSalary());
		return model;
	}
	
	@Override
	public List<EmployeeTblModel> fetchAllEmployees() {
		List<EmployeeTbl> empList = empRepo.findAll();
		return empList.stream().map(emp -> convertEntityToBean(emp)).collect(Collectors.toList());
	}
	
	@Override
	public EmployeeTblModel fetchEmployeeById(int id) {
		Optional<EmployeeTbl> empOptional = empRepo.findById(id);
		if(empOptional.isPresent())
			return convertEntityToBean(empOptional.get());
		return new EmployeeTblModel(0, "dummy", 0, 0.0);
	}
	
	@Override
	public List<EmployeeTblModel> fetchEmployeesBySortPage(int pageNo, int pageSize, String name){
		Pageable pageable=PageRequest.of(pageNo, pageSize, Sort.by(name));
		Page<EmployeeTbl> data=empRepo.findAll(pageable);
		return data.toList().stream().map(emp->convertEntityToBean(emp)).collect(Collectors.toList());
	}

}
