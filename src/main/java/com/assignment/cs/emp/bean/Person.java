package com.assignment.cs.emp.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Version;

import org.springframework.data.orient.commons.repository.annotation.Vertex;

/**
 * 
 * @author sanjib.pramanick
 *
 */
@Vertex
@JsonIgnoreProperties(value = { "handler" })
public class Person {

	@Id
	private String id;

	@Version
	@JsonIgnore
	private Long version;

	private String firstName;

	private String lastName;

	private Date dob;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", version=" + version + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dob=" + dob + "]";
	}

}
