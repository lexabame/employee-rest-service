package com.kenzan.employee.rest.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kenzan.employee.rest.server.entities.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
	
	EmployeeEntity findEmployeeEntityByEmail(final String email);

}
