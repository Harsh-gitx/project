package com.codex.cxcarz.entity;

import java.time.LocalDate;

public class RegistrationDetailEntity {

	private String firstName;
	private String lastName;
	private String emailId;
	private Long phoneNumber;
	private LocalDate dateOfBirth;

	@Override
	public String toString() {
		return "RegistrationDetailEntity [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		/*DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setPassword("root");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/cxcarz");
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(driverManagerDataSource);
        SessionFactory factory = bean.getObject();
*/		this.firstName = firstName;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
