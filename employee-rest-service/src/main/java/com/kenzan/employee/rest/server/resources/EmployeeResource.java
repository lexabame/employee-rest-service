package com.kenzan.employee.rest.server.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kenzan.employee.rest.server.entities.EmployeeEntity;
import com.kenzan.employee.rest.server.mapper.EmployeeMapper;
import com.kenzan.employee.rest.server.resources.model.EmployeeModel;
import com.kenzan.employee.rest.server.services.api.EmployeeService;

@RestController
@RequestMapping(value = "api/v1/employees", produces= "application/json")
public class EmployeeResource{
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<EmployeeModel> getEmployee(@PathVariable Long id) {
		EmployeeEntity employeeEntity = employeeService.getEmployeeById(id);
		EmployeeModel employeeModel = employeeMapper.map(employeeEntity);
		return new ResponseEntity<>(employeeModel, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeEntity>> getEmployees(){
		List<EmployeeEntity> employeeList = employeeService.getAllEmployees();
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}
	

}
