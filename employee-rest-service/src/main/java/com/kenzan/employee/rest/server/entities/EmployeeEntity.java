package com.kenzan.employee.rest.server.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.kenzan.employee.rest.server.enums.EmployeeStatus;


/**
 * @author alejandro
 * Class to represent the employee model in the database
 */
@Entity
@Table(name = "EMPLOYEES")
@SQLDelete(sql = "UPDATE EMPLOYEES SET STATUS = 'INACTIVE' WHERE ID = ?")
@Where(clause = "status <> 'INACTIVE'")
public class EmployeeEntity extends BaseEntity{
	
	@Column(name = "NAME")
	@NotNull
	private String name;
	
	@Column(name = "MIDDLE_INITIAL")
	private  String middleInitial;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@NotNull
	@Column(name = "EMAIL")
	private String email;
	
	@NotNull
	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;
	
	@NotNull
	@Column(name = "DATE_OF_EMPLOYMENT")
	private Date dateOfEmployment;
	
	@NotNull
	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private EmployeeStatus status;
	
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
	
	public EmployeeStatus getStatus() {
		return status;
	}
	
	public void setStatus(EmployeeStatus status) {
		this.status = status;
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
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleInitial == null) ? 0 : middleInitial.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		EmployeeEntity other = (EmployeeEntity) obj;
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
		if (status != other.status)
			return false;
		return true;
	}

	
}
