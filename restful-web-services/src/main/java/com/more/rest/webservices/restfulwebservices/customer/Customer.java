package com.more.rest.webservices.restfulwebservices.customer;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Customer account details")
@Table(
	    uniqueConstraints=
	        @UniqueConstraint(columnNames={"customer_id", "siteId"})
	)
@Entity
//@JsonFilter(value = "CustomerFilter")
@JsonIgnoreProperties("password")
@JsonInclude(Include.NON_NULL)
public class Customer {

	@javax.persistence.Id
	@GeneratedValue
	@Column(name="customer_id")
	private Long Id;
	
	private String email;
	private String altEmail;
		
	//@Column(nullable=true)
	private String gender;
	private String password;
	//@Column(nullable=true)
	private String status;
	private String salt;
	@Column(columnDefinition="varchar(50) default 'ftd'")
	private String siteId;
	//@Column(nullable=true)
	private String isShared;
	private String workPhone;
	private String workPhoneExt;
	private String homePhone;
	private String mobilePhone;
	private String primaryPhone;
	private String dayPhone;
	private String nightPhone;
	private String fax;
	private Date activationDate;
	private String nickName;
	private String emailType;
	private String title;
	private String siteGroup;
	//@Column(nullable=true)
	private String myAccountFlag;
	private String blackListReason;
	private String websiteURL;
	//@Column(nullable=true)
	private String marketingPreference;
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date rowCreate;
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date rowMod;
	private String rowModBy;
	
	@Size(min=2, message="First Name should have atleast 2 characters")
	@ApiModelProperty(notes="First Name should have atleast 2 characters")
	private String firstName;
	
	@Size(min=2, message="Last Name should have atleast 2 characters")
	@ApiModelProperty(notes="Last Name should have atleast 2 characters")
	private String lastName;
	
	@OneToMany(cascade=CascadeType.ALL ,fetch=FetchType.LAZY, mappedBy="customerId")
	private List<Address> addresses;
	
	public Customer() {
	}

	
	
	public List<Address> getAddresses() {
		return addresses;
	}



	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}



	public Customer(Long id, String email, String altEmail, String gender, String password, String status, String salt,
			String siteId, String isShared, String workPhone, String workPhoneExt, String homePhone, String mobilePhone,
			String primaryPhone, String dayPhone, String nightPhone, String fax, Date activationDate, String nickName,
			String emailType, String title, String siteGroup, String myAccountFlag, String blackListReason,
			String websiteURL, String marketingPreference, Date rowCreate, Date rowMod, String rowModBy,
			@Size(min = 2, message = "First Name should have atleast 2 characters") String firstName,
			@Size(min = 2, message = "Last Name should have atleast 2 characters") String lastName) {
		super();
		Id = id;
		this.email = email;
		this.altEmail = altEmail;
		this.gender = gender;
		this.password = password;
		this.status = status;
		this.salt = salt;
		this.siteId = siteId;
		this.isShared = isShared;
		this.workPhone = workPhone;
		this.workPhoneExt = workPhoneExt;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.primaryPhone = primaryPhone;
		this.dayPhone = dayPhone;
		this.nightPhone = nightPhone;
		this.fax = fax;
		this.activationDate = activationDate;
		this.nickName = nickName;
		this.emailType = emailType;
		this.title = title;
		this.siteGroup = siteGroup;
		this.myAccountFlag = myAccountFlag;
		this.blackListReason = blackListReason;
		this.websiteURL = websiteURL;
		this.marketingPreference = marketingPreference;
		this.rowCreate = rowCreate;
		this.rowMod = rowMod;
		this.rowModBy = rowModBy;
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public String getAltEmail() {
		return altEmail;
	}


	public void setAltEmail(String altEmail) {
		this.altEmail = altEmail;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getSalt() {
		return salt;
	}


	public void setSalt(String salt) {
		this.salt = salt;
	}


	public String getSiteId() {
		return siteId;
	}


	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}


	public String getIsShared() {
		return isShared;
	}


	public void setIsShared(String isShared) {
		this.isShared = isShared;
	}


	public String getWorkPhone() {
		return workPhone;
	}


	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}


	public String getWorkPhoneExt() {
		return workPhoneExt;
	}


	public void setWorkPhoneExt(String workPhoneExt) {
		this.workPhoneExt = workPhoneExt;
	}


	public String getHomePhone() {
		return homePhone;
	}


	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}


	public String getMobilePhone() {
		return mobilePhone;
	}


	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}


	public String getPrimaryPhone() {
		return primaryPhone;
	}


	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}


	public String getDayPhone() {
		return dayPhone;
	}


	public void setDayPhone(String dayPhone) {
		this.dayPhone = dayPhone;
	}


	public String getNightPhone() {
		return nightPhone;
	}


	public void setNightPhone(String nightPhone) {
		this.nightPhone = nightPhone;
	}


	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = fax;
	}


	public Date getActivationDate() {
		return activationDate;
	}


	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getEmailType() {
		return emailType;
	}


	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSiteGroup() {
		return siteGroup;
	}


	public void setSiteGroup(String siteGroup) {
		this.siteGroup = siteGroup;
	}


	public String getMyAccountFlag() {
		return myAccountFlag;
	}


	public void setMyAccountFlag(String myAccountFlag) {
		this.myAccountFlag = myAccountFlag;
	}


	public String getBlackListReason() {
		return blackListReason;
	}


	public void setBlackListReason(String blackListReason) {
		this.blackListReason = blackListReason;
	}


	public String getWebsiteURL() {
		return websiteURL;
	}


	public void setWebsiteURL(String websiteURL) {
		this.websiteURL = websiteURL;
	}


	public String getMarketingPreference() {
		return marketingPreference;
	}


	public void setMarketingPreference(String marketingPreference) {
		this.marketingPreference = marketingPreference;
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

	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
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
