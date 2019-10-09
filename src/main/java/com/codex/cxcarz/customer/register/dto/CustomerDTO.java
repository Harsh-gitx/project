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
    @GenericGenerator(name = "customerId" ,strategy = "increment")
    @Id
    @GeneratedValue(generator = "customerId")
	private Integer customerId;
	private String emailId;
	private String userName;
	private String password;
	private String uuid;
	private boolean isAdmin;
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public static Logger getLogger() {
		return logger;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	

	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
