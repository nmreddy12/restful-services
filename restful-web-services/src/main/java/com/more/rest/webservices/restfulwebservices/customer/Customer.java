package com.more.rest.webservices.restfulwebservices.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All details about a Customer")
@Entity
public class Customer {

	@javax.persistence.Id
	@GeneratedValue
	private Integer Id;
	private String email;
	
	@Size(min=2, message="First Name should have atleast 2 characters")
	@ApiModelProperty(notes="First Name should have atleast 2 characters")
	private String firstName;
	
	@Size(min=2, message="Last Name should have atleast 2 characters")
	@ApiModelProperty(notes="Last Name should have atleast 2 characters")
	private String lastName;
	
	
	public Customer() {
	}


	public Customer(Integer id, String email, String firstName, String lastName) {
		super();
		Id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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

	
}
