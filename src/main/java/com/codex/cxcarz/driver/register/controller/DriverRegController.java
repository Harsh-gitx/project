package com.codex.cxcarz.driver.register.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codex.cxcarz.driver.register.dto.DriverDTO;
import com.codex.cxcarz.driver.register.service.DriverRegService;

@RestController
@RequestMapping(value = "/")
public class DriverRegController {

	private Logger logger = LoggerFactory.getLogger(DriverRegController.class);

	public DriverRegController() {
		System.out.println("object created for " + this.getClass().getName());
	}

	@Autowired
	private DriverRegService regService;

	@RequestMapping(value = "/createDriver.do", method = RequestMethod.POST)
	public ResponseEntity<DriverDTO> create(@RequestBody DriverDTO driverDTO) {
		System.out.println(driverDTO.getEmail());
		try {
			DriverDTO dtoAfterSave = regService.presave(driverDTO);
			if (dtoAfterSave == null) {
				logger.debug("Successfully save the object " + dtoAfterSave);
				System.out.println(driverDTO.getEmail());
				regService.create(driverDTO);
				return new ResponseEntity<DriverDTO>(driverDTO, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			logger.error("operation failed due to some error");
			e.printStackTrace();
			return new ResponseEntity<DriverDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<DriverDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
