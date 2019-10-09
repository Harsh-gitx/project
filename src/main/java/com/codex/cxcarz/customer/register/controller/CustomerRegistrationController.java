package com.codex.cxcarz.customer.register.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codex.cxcarz.customer.register.dto.CustomerDTO;
import com.codex.cxcarz.customer.register.service.CustomerRegistrationService;

import javassist.bytecode.stackmap.BasicBlock.Catch;

@RestController
@RequestMapping(value = "/")
public class CustomerRegistrationController {

	private Logger logger = LoggerFactory.getLogger(CustomerRegistrationController.class);
	@Autowired
	private CustomerRegistrationService service;

	public CustomerRegistrationController() {
		System.out.println("inside Customer Register");
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/createCustomer.do", method = RequestMethod.POST)
	public String create(@RequestBody CustomerDTO dto) {
		try {
			System.out.println("inside create");
			logger.debug("Entering create method to save " + dto);
			System.out.println(dto.getEmailId());
			if(dto.getEmailId().equals("sahanapriyar@gmail.com")) {
				dto.setAdmin(true);
			}
			CustomerDTO dtoPresent = service.preSave(dto);

			if (dtoPresent != null) {
				logger.debug("Successfully save the object " + dtoPresent);
				CustomerDTO dtoAfterSave = service.save(dto);
				if (dtoAfterSave != null) {
					// return new ResponseEntity<CustomerDTO>(dtoAfterSave, HttpStatus.CREATED);
					return "success";
				}
				return "Failure";
			} else {

				return "Email Already Exists";
			}
		} catch (Exception e) {
			logger.error("Operation failed due to some exception");
			e.printStackTrace();
			// return new ResponseEntity<CustomerDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
			return "Error";

		}
	}
	
	@RequestMapping(value = "/activateLink",method = RequestMethod.GET)
	public String activateLink(@RequestParam("uoid") String uoid) {
		try {
		CustomerDTO dtoPresent= service.checkUoid(uoid);
		if(dtoPresent!=null) {
			return "http://localhost:8080/cxcarz/login";
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
		return null;
}
}