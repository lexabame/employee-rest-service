package com.kenzan.employee.rest.server.services.api;

import java.util.List;

import com.kenzan.employee.rest.server.entities.EmployeeEntity;

public interface EmployeeService {

	EmployeeEntity getEmployeeById(final Long id);
	
	List<EmployeeEntity> getAllEmployees();
	
	EmployeeEntity createEmployee(EmployeeEntity employee);
	
	EmployeeEntity updateEmployee(EmployeeEntity employee);
	
	void deleteEmployee(final Long id);
	
}
