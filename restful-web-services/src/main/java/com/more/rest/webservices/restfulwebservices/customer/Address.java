package com.more.rest.webservices.restfulwebservices.customer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;

@ApiModel(description="Customer address details")
@Entity
//@JsonFilter(value = "CustomerFilter")
//@JsonIgnoreProperties("password")
@JsonInclude(Include.NON_NULL)
public class Address {
	
	@javax.persistence.Id
	@GeneratedValue
	@Column(name="address_id")
	private Long Id;
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date rowCreate;
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date rowMod;
	private String rowModBy;
	//@ManyToOne
	private Long customerId;
	private String city;
	private String country;
	private String state;
	private String firstName;
	private String lastName;
	private String zip;
	private String dayPhone;
	private String dayPhoneExt;
	private String eveningPhone;
	private String locationType;
	private String addressType;
	private String addressPurpose;
	private String latitude;
	private String longitude;
	private String streetAddress;
	private String address1;
	private String address2;
	private String fax;
	private String personalNotes;

	public Address() {
	}

	public Address(Long id, Date rowCreate, Date rowMod, String rowModBy, Long customerId, String city, String country,
			String state, String firstName, String lastName, String zip, String dayPhone, String dayPhoneExt,
			String eveningPhone, String locationType, String addressType, String addressPurpose, String latitude,
			String longitude, String streetAddress, String address1, String address2, String fax,
			String personalNotes) {
		super();
		Id = id;
		this.rowCreate = rowCreate;
		this.rowMod = rowMod;
		this.rowModBy = rowModBy;
		this.customerId = customerId;
		this.city = city;
		this.country = country;
		this.state = state;
		this.firstName = firstName;
		this.lastName = lastName;
		this.zip = zip;
		this.dayPhone = dayPhone;
		this.dayPhoneExt = dayPhoneExt;
		this.eveningPhone = eveningPhone;
		this.locationType = locationType;
		this.addressType = addressType;
		this.addressPurpose = addressPurpose;
		this.latitude = latitude;
		this.longitude = longitude;
		this.streetAddress = streetAddress;
		this.address1 = address1;
		this.address2 = address2;
		this.fax = fax;
		this.personalNotes = personalNotes;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getRowCreate() {
		return rowCreate;
	}

	public void setRowCreate(Date rowCreate) {
		this.rowCreate = rowCreate;
	}

	public Date getRowMod() {
		return rowMod;
	}

	public void setRowMod(Date rowMod) {
		this.rowMod = rowMod;
	}

	public String getRowModBy() {
		return rowModBy;
	}

	public void setRowModBy(String rowModBy) {
		this.rowModBy = rowModBy;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getDayPhone() {
		return dayPhone;
	}

	public void setDayPhone(String dayPhone) {
		this.dayPhone = dayPhone;
	}

	public String getDayPhoneExt() {
		return dayPhoneExt;
	}

	public void setDayPhoneExt(String dayPhoneExt) {
		this.dayPhoneExt = dayPhoneExt;
	}

	public String getEveningPhone() {
		return eveningPhone;
	}

	public void setEveningPhone(String eveningPhone) {
		this.eveningPhone = eveningPhone;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddressPurpose() {
		return addressPurpose;
	}

	public void setAddressPurpose(String addressPurpose) {
		this.addressPurpose = addressPurpose;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPersonalNotes() {
		return personalNotes;
	}

	public void setPersonalNotes(String personalNotes) {
		this.personalNotes = personalNotes;
	}
	
	
	

	
}
