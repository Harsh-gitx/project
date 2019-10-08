package com.codex.cxcarz.customer.Rides.DTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ride_table")
public class RideDTO implements Serializable {

	@GenericGenerator(name="rideGen",strategy="increment")
	@GeneratedValue(generator="rideGen")
	@Id
	private int id;
	@Column(name="ride_src")
	private String source;
	@Column(name="ride_dest")
	private String destination;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
}
