package com.kenzan.employee.rest.server.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.kenzan.employee.rest.server.entities.EmployeeEntity;
import com.kenzan.employee.rest.server.enums.EmployeeStatus;
import com.kenzan.employee.rest.server.repositories.EmployeeRepository;
import com.kenzan.employee.rest.server.services.api.EmployeeService;
import com.kenzan.employee.rest.server.services.exceptions.EntityAlreadyExistsException;
import com.kenzan.employee.rest.server.services.exceptions.EntityNotFoundException;

/**
 * @author alejandro
 * Component providing business logic operations for employees
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
	public EmployeeEntity getEmployeeById(Long id) {
		
		Optional<EmployeeEntity> employeepOptional = employeeRepository.findById(id);
		
		if(!employeepOptional.isPresent()) {
			throw new EntityNotFoundException("ERROR-0001", "Employee entity was not found");
		}
		return employeepOptional.get();
		
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
	public List<EmployeeEntity> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = false)
	public EmployeeEntity createEmployee(EmployeeEntity employee) {
		
		EmployeeEntity employeeEntity = employeeRepository.findEmployeeEntityByEmail(employee.getEmail());
		
		if(employeeEntity != null){
			throw new EntityAlreadyExistsException("ERROR-0002", "The email is already in use");
		}
		
		employee.setStatus(EmployeeStatus.ACTIVE);
		
		return employeeRepository.save(employee);
		
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = false)
	public EmployeeEntity updateEmployee(EmployeeEntity employee) {
		
		Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(employee.getId());
		
		if(!employeeOptional.isPresent()) {
			throw new EntityNotFoundException("ERROR-0001", "Employee entity was not found");
		}
		
        EmployeeEntity employeeEntity = employeeRepository.findEmployeeEntityByEmail(employee.getEmail());
		
		if(employeeEntity != null){
			throw new EntityAlreadyExistsException("ERROR-0002", "The email is already in use");
		}
		
		
		EmployeeEntity employeeToUpdate = employeeOptional.get();
		
		//we are passing the new info to the existing entity and then saving it
		employeeToUpdate.setName(employee.getName());
		employeeToUpdate.setMiddleInitial(employee.getMiddleInitial());
		employeeToUpdate.setLastName(employee.getLastName());
		employeeToUpdate.setEmail(employee.getEmail());
		employeeToUpdate.setDateOfBirth(employee.getDateOfBirth());
		employeeToUpdate.setDateOfEmployment(employee.getDateOfEmployment());
		
		return employeeRepository.save(employeeToUpdate);
		
		
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = false)
	public void deleteEmployee(Long id) {
		
		Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(id);
		
		if(!employeeOptional.isPresent()) {
			throw new EntityNotFoundException("ERROR-0001", "Employee entity was not found");
		}
		
		EmployeeEntity employeeToDelete = employeeOptional.get();
		
		employeeRepository.delete(employeeToDelete);

	}

}
