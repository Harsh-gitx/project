package com.codex.cxcarz.admin.Dashboard.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name = "carTable")
@Entity

public class CarDTO {
	@GenericGenerator(name = "customerId", strategy = "increment")
	@Id
	@GeneratedValue(generator = "customerId")
	@Column
	private int carID;

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private long price;
	@Column(name = "year")
	private String year;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
