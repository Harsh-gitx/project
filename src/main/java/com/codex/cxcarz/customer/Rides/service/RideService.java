package com.codex.cxcarz.customer.Rides.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codex.cxcarz.customer.Rides.DTO.RideDTO;
import com.codex.cxcarz.customer.Rides.repository.RideRepository;

@Service
public class RideService {
	
	@Autowired
	private RideRepository repo;

	public RideDTO bookRide(RideDTO dto) {
		
		if(repo.bookRide(dto)!=null) {
			return dto;
		}
		return null;
	}

}
