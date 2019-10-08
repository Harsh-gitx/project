package com.codex.cxcarz.customer.Rides.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codex.cxcarz.customer.Rides.DTO.RideDTO;

@Repository
public class RideRepository {
	
	@Autowired
	private SessionFactory factory;
	
	public RideDTO bookRide(RideDTO dto) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		session.save(dto);
		session.beginTransaction().commit();
		return dto;
	}

	
	
}
	