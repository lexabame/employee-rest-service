package com.kenzan.employee.rest.server.mapper;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.kenzan.employee.rest.server.entities.EmployeeEntity;
import com.kenzan.employee.rest.server.resources.model.EmployeeModel;

/**
 * @author alejandro
 * This class maps an EmployeeEntity class to an EmployeeModel class and vice-versa
 */
@Component
public class EmployeeMapper {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeMapper.class);

	public EmployeeModel map(EmployeeEntity employeeEntity) {
		
		EmployeeModel employeeModel = new EmployeeModel();
		
		//It evaluates if employeeEntity has an attribute id
		try {
			final String property = BeanUtils.getProperty(employeeEntity, "id");
			if(property != null && !property.isEmpty()) {
				BeanUtils.setProperty(employeeModel, "id", property);
			}
		}
		catch(Exception ex) {
			LOGGER.error("Property was not set properly");
		}
		
		employeeModel.setName(employeeEntity.getName());
		employeeModel.setMiddleInitial(employeeEntity.getMiddleInitial());
		employeeModel.setLastName(employeeEntity.getLastName());
		employeeModel.setEmail(employeeEntity.getEmail());
		employeeModel.setDateOfBirth(employeeEntity.getDateOfBirth());
		employeeModel.setDateOfEmployment(employeeEntity.getDateOfEmployment());
		return employeeModel;
		
	}
	
	public EmployeeEntity map(EmployeeModel employeeModel) {
		
		EmployeeEntity employeeEntity = new EmployeeEntity();
		
		//It evaluates if employeeModel object has an attribute id
		try {
			final String property = BeanUtils.getProperty(employeeModel, "id");
			if(property != null && !property.isEmpty()) {
				BeanUtils.setProperty(employeeEntity, "id", property);
			}
		}
		catch(Exception ex) {
			LOGGER.error("Property was not set properly");
		}
		
		employeeEntity.setName(employeeModel.getName());
		employeeEntity.setMiddleInitial(employeeModel.getMiddleInitial());
		employeeEntity.setLastName(employeeModel.getLastName());
		employeeEntity.setEmail(employeeModel.getEmail());
		employeeEntity.setDateOfBirth(employeeModel.getDateOfBirth());
		employeeEntity.setDateOfEmployment(employeeModel.getDateOfEmployment());
		return employeeEntity;
		
	}
	
}
