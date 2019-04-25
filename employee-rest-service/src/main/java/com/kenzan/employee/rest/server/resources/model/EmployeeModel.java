package com.kenzan.employee.rest.server.resources.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.kenzan.employee.rest.server.enums.EmployeeStatus;
import com.kenzan.employee.rest.server.resources.validations.EmployeeCreationGroup;
import com.kenzan.employee.rest.server.resources.validations.EmployeeUpdationGroup;

/**
 * @author alejandro
 * This class represent an employee for the clients who will consume our api. Every employee information
 * our api return should be wrapped by this object.
 */
public class EmployeeModel implements Serializable {
	
	static final long serialVersionUID = -5996794534128224040L;

	@NotEmpty(groups = {EmployeeUpdationGroup.class})
	private String id;
	
	@NotEmpty( groups = {EmployeeCreationGroup.class, EmployeeUpdationGroup.class})
	private String name;
	
	private String middleInitial;
	
	private String lastName;
	
	@NotEmpty( groups = {EmployeeCreationGroup.class, EmployeeUpdationGroup.class})
	private String email;
	
	@NotNull( groups = {EmployeeCreationGroup.class, EmployeeUpdationGroup.class})
	private Date dateOfBirth;
	
	@NotNull( groups = {EmployeeCreationGroup.class, EmployeeUpdationGroup.class})
	private Date dateOfEmployment;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMiddleInitial() {
		return middleInitial;
	}
	
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfEmployment() {
		return dateOfEmployment;
	}

	public void setDateOfEmployment(Date dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((dateOfEmployment == null) ? 0 : dateOfEmployment.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleInitial == null) ? 0 : middleInitial.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeModel other = (EmployeeModel) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (dateOfEmployment == null) {
			if (other.dateOfEmployment != null)
				return false;
		} else if (!dateOfEmployment.equals(other.dateOfEmployment))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleInitial == null) {
			if (other.middleInitial != null)
				return false;
		} else if (!middleInitial.equals(other.middleInitial))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
}
