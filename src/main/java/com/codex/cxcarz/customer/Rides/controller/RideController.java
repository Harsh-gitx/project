package com.codex.cxcarz.customer.Rides.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codex.cxcarz.customer.Rides.DTO.RideDTO;
import com.codex.cxcarz.customer.Rides.repository.RideRepository;
import com.codex.cxcarz.customer.Rides.service.RideService;

@RestController
@RequestMapping(value = "/")
public class RideController {
	
	@Autowired
	private RideService service;

		@RequestMapping(value="/bookRide.do" ,consumes="application/json",method=RequestMethod.POST)
	public String bookRide(@RequestBody RideDTO dto) {
			System.out.println("inside the BookRide");
			service.bookRide(dto);
			return "Successfully Booked";
	}
}
