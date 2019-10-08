package com.codex.cxcarz.admin.Dashboard.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codex.cxcarz.admin.Dashboard.service.DashboardService;
import com.codex.cxcarz.customer.Rides.DTO.RideDTO;

@RestController
@RequestMapping("/")
public class DashboardController {

	@Autowired
	private DashboardService service;
	
	@RequestMapping(value="/getRides.do",method=RequestMethod.GET)
	public ResponseEntity<Collection<RideDTO>> getRidesFromCustomers() {
		 return new ResponseEntity<Collection<RideDTO>>(service.getRides(), HttpStatus.OK);
	}
	@RequestMapping(value="/assignRides.do",method=RequestMethod.POST)
	public boolean assignRideToDriver(RideDTO dto) {
		service.assignRideToDriver(dto);
		return true;
	}
}
