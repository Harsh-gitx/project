package com.codex.cxcarz.admin.Dashboard.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codex.cxcarz.admin.Dashboard.repository.DashboardRepository;
import com.codex.cxcarz.customer.Rides.DTO.RideDTO;


@Repository
public class DashboardService {

	@Autowired
	private DashboardRepository repo;
	
	public Collection<RideDTO> getRides() {
		return repo.getRides();
	}

	public void assignRideToDriver(RideDTO dto) {

		repo.assignRideToDriver(dto);
	}
	
}
