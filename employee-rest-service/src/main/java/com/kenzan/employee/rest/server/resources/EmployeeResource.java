package com.kenzan.employee.rest.server.resources;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kenzan.employee.rest.server.entities.EmployeeEntity;
import com.kenzan.employee.rest.server.mapper.EmployeeMapper;
import com.kenzan.employee.rest.server.resources.model.EmployeeModel;
import com.kenzan.employee.rest.server.resources.validations.EmployeeCreationGroup;
import com.kenzan.employee.rest.server.resources.validations.EmployeeUpdationGroup;
import com.kenzan.employee.rest.server.services.api.EmployeeService;

/**
 * @author alejandro
 * Rest controller which expose employee RESTfull operations
 */
@RestController
@RequestMapping(value = "api/v1/employees", produces= "application/json")
public class EmployeeResource{
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<EmployeeModel> getEmployee(@PathVariable String id) {
		EmployeeEntity employeeEntity = employeeService.getEmployeeById(Long.valueOf(id));
		EmployeeModel employeeModel = employeeMapper.map(employeeEntity);
                System.out.println("Employee retrieved from the database");
                System.out.println("Before returning");
		return new ResponseEntity<>(employeeModel, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeModel>> getEmployees(){
		List<EmployeeModel> employeeModelList = new ArrayList<>();
		List<EmployeeEntity> employeeList = employeeService.getAllEmployees();
		employeeList.forEach(employeeEntity -> employeeModelList.add(employeeMapper.map(employeeEntity)));
		return new ResponseEntity<>(employeeModelList, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<EmployeeModel> createEmployee(@Validated(EmployeeCreationGroup.class) @RequestBody EmployeeModel employee){
		EmployeeEntity employeeEntity = employeeMapper.map(employee);
	    EmployeeEntity employeeEntityCreated = employeeService.createEmployee(employeeEntity);
	    EmployeeModel employeeModelCreated = employeeMapper.map(employeeEntityCreated);
		return new ResponseEntity<>(employeeModelCreated, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<EmployeeModel> updateEmployee(@Validated(EmployeeUpdationGroup.class) @RequestBody EmployeeModel employee) {
		EmployeeEntity employeeEntity = employeeMapper.map(employee);
		EmployeeEntity employeeEntityUpdated = employeeService.updateEmployee(employeeEntity);
		EmployeeModel employeeModelUpdated = employeeMapper.map(employeeEntityUpdated);
		return new ResponseEntity<>(employeeModelUpdated, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{id}")
	//PreAuthorize indicates only users whose role is ROLE_ADMIN will be able to access the delete api call
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteEmployee(@PathVariable String id){
		employeeService.deleteEmployee(Long.valueOf(id));
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

}
