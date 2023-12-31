package com.client.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.client.entity.EmployeeTbl;
import com.client.model.EmployeeAddressResonse;
import com.client.model.EmployeeTblModel;
import com.client.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRestController.class);

	@Autowired
	private EmployeeService empService;
	
	@PostMapping(value="/save", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeTblModel> saveEmployee(@RequestBody EmployeeTblModel model){
		LOGGER.info("==Employee model==="+model);
		EmployeeTbl  empEntity=empService.convertBeanToEntity(model);
		empEntity=empService.saveEmployee(empEntity);
		model= empService.convertEntityToBean(empEntity);
		
		return new ResponseEntity<>(model,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/fetchEmployees", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeTblModel>> fetchAllEmployees(){
		List<EmployeeTblModel> empList=empService.fetchAllEmployees();
		LOGGER.info("==fetchAllEmployees==="+empList);
		return new ResponseEntity<>(empList,HttpStatus.OK);
	}
	
	@GetMapping(value="/fetchEmployees/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeTblModel> fetchEmployeeById(@PathVariable int id){
		EmployeeTblModel empModel=empService.fetchEmployeeById(id);
				LOGGER.info("==fetchEmployeeById==="+empModel);
		return new ResponseEntity<>(empModel,HttpStatus.OK);
	}
	
	@PutMapping(value="/updateEmployees", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeTblModel> updateEmployeeById(@RequestBody EmployeeTblModel model){
		
		EmployeeTbl  empEntity=empService.convertBeanToEntity(model);
		empEntity=empService.saveEmployee(empEntity);
		model= empService.convertEntityToBean(empEntity);
		
		return new ResponseEntity<>(model,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/fetchEmpBySortPage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeTblModel>> fetchEmployeesSortAndPaginated(
			@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "5") int pageSize,
			@RequestParam(defaultValue = "empName") String name) {
		List<EmployeeTblModel> empList = empService.fetchEmployeesBySortPage(pageNo, pageSize, name);
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteEmployeeById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteEmpById(@PathVariable("id") int id){
		
		String response=empService.deleteEmpById(id);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	@PutMapping(value="/updateEmployeeUsingQuery", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateEmployeeUsingQuery(@RequestBody EmployeeTblModel model){
		
		String response= empService.updateEmpNameUsingQuery(model.getEmpName(), model.getEmpId());
		
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/fetchEmployeeByIdUsingQuery/{empName}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeTblModel> fetchEmployeeByIdUsingQuery(@PathVariable String empName){
		EmployeeTblModel model =empService.findByEmpName(empName);
		return new ResponseEntity<>(model,HttpStatus.OK);
	}
	
	@GetMapping(value="/fetchEmployeeAddressInfo", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeAddressResonse>> fetchEmployeeAddressInfo(){
		List<EmployeeAddressResonse> response =empService.findEmpAddInfo();
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
