package com.kenzan.employee.rest.server.mapper;

import org.springframework.stereotype.Component;

import com.kenzan.employee.rest.server.entities.EmployeeEntity;
import com.kenzan.employee.rest.server.resources.model.EmployeeModel;

@Component
public class EmployeeMapper {

	public EmployeeModel map(EmployeeEntity employeeEntity) {
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setId(String.valueOf(employeeEntity.getId()));
		employeeModel.setName(employeeEntity.getName());
		employeeModel.setMiddleInitial(employeeEntity.getMiddleInitial());
		employeeModel.setLastName(employeeEntity.getLastName());
		employeeModel.setDateOfBirth(employeeEntity.getDateOfBirth());
		employeeModel.setStatus(employeeEntity.getStatus());
		return employeeModel;
	}
	
	public EmployeeEntity map(EmployeeModel employeeModel) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setId(Long.parseLong(employeeModel.getId()));
		employeeEntity.setName(employeeModel.getName());
		employeeEntity.setMiddleInitial(employeeModel.getMiddleInitial());
		employeeEntity.setLastName(employeeModel.getLastName());
		employeeEntity.setDateOfBirth(employeeModel.getDateOfBirth());
		employeeEntity.setStatus(employeeModel.getStatus());
		return employeeEntity;
		
	}
	
}
