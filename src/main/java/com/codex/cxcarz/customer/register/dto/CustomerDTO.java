package com.codex.cxcarz.customer.register.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Table(name = "CUSTOMER_REG")
@Entity
public class CustomerDTO implements Serializable {

	private static final Logger logger = LoggerFactory.getLogger(CustomerDTO.class);

	public CustomerDTO() {
		logger.debug("Object created for " + this.getClass().getSimpleName());
	}
    @Id
    @GenericGenerator(name = "customerId" ,strategy = "increment")
    @GeneratedValue(generator = "customerId")
	private Integer customerId;
	private String firstName;
	private String lastName;
	private String emailId;
	private Long phoneNumber;
	private String dateOfBirth;
	private String userName;
	private String password;
	private String uuid;

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth
				+ ", userName=" + userName + ", password=" + password + ", uuid=" + uuid + "]";
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
