package com.codex.cxcarz.driver.register.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codex.cxcarz.customer.Rides.DTO.RideDTO;

@Table(name = "Driver_Reg")
@Entity
public class DriverDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(DriverDTO.class);

	public DriverDTO() {
		LOGGER.debug("object created for " + this.getClass().getSimpleName());
	}

	@Id
	@GenericGenerator(name = "driverID", strategy = "increment")
	@GeneratedValue(generator = "driverID")
	private Integer driverID;
	private String firstName;
	private String lastName;
	private String DOB;
	private String email;
	private Long phoneNum;
	private String userName;
	private String pwd;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ride_col")
	private RideDTO ride;

	public RideDTO getRide() {
		return ride;
	}

	public void setRide(RideDTO ride) {
		this.ride = ride;
	}

	public Integer getDriverID() {
		return driverID;
	}

	public void setDriverID(Integer driverID) {
		this.driverID = driverID;
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

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "DriverDTO [firstName=" + firstName + ", lastName=" + lastName + ", DOB=" + DOB + ", email=" + email
				+ ", phoneNum=" + phoneNum + ", userName=" + userName + ", pwd=" + pwd + ", driverID=" + driverID + "]";
	}


}
