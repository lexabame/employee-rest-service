package com.kenzan.employee.rest.server.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.kenzan.employee.rest.server.entities.EmployeeEntity;
import com.kenzan.employee.rest.server.exceptions.EntityNotFoundException;
import com.kenzan.employee.rest.server.repositories.EmployeeRepository;
import com.kenzan.employee.rest.server.services.api.EmployeeService;

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
		
		return employeeRepository.save(employee);
		
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = false)
	public EmployeeEntity updateEmployee(EmployeeEntity employee) {
		
		Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(employee.getId());
		
		if(!employeeOptional.isPresent()) {
			throw new EntityNotFoundException("ERROR-0001", "Employee entity was not found");
		}
		
		EmployeeEntity employeeToUpdate = employeeOptional.get();
		
		employeeToUpdate.setName(employee.getName());
		employeeToUpdate.setMiddleInitial(employee.getMiddleInitial());
		employeeToUpdate.setLastName(employee.getLastName());
		employeeToUpdate.setDateOfBirth(employee.getDateOfBirth());
		employeeToUpdate.setStatus(employee.getStatus());
		
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
