package com.codex.cxcarz.admin.register.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Table(name = "ADMIN")
@Entity

public class AdminRegisterDTO implements Serializable {
	
private static final Logger logger = LoggerFactory.getLogger(AdminRegisterDTO.class);
	
	public AdminRegisterDTO() {
	logger.debug("Object created for "+this.getClass().getSimpleName());
	}
	
	@Id
	@GenericGenerator(name = "adminId", strategy = "increment")
	@GeneratedValue(generator = "adminId")
	private Integer adminId;
	private String fName;
	private String lName;
	private Long mobileNumber;
	private String emailId;
    private String password;
	@Override
	public String toString() {
		return "AdminRegisterDTO [adminId=" + adminId + ", fName=" + fName + ", lName=" + lName + ", mobileNumber="
				+ mobileNumber + ", emailId=" + emailId + ", password=" + password + "]";
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	
}
