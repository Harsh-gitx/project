package com.codex.cxcarz.admin.register.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codex.cxcarz.admin.register.dto.AdminRegisterDTO;
import com.codex.cxcarz.admin.register.service.AdminRegisterSvc;

@RestController
@RequestMapping("/")
public class AdminRegistrationController {

	private Logger logger = LoggerFactory.getLogger(AdminRegistrationController.class);
	@Autowired
	private AdminRegisterSvc service;
	public AdminRegistrationController() {
		System.out.println("inside constructor");
	}
	
	@RequestMapping(value="/createAdmin.do",method = RequestMethod.POST,consumes ="application/json",produces="application/json" )
	public ResponseEntity<AdminRegisterDTO> create(@RequestBody AdminRegisterDTO dtoToSave)
	{
		try {
			AdminRegisterDTO dtoAfterSave= service.preSave(dtoToSave);
			if(dtoAfterSave != null) {
				logger.debug("Object is saved successfully for admin and new profile created "+dtoAfterSave);
				return new ResponseEntity<AdminRegisterDTO>(dtoAfterSave, HttpStatus.CREATED);
			}
			else {
				service.create(dtoToSave);
				return new ResponseEntity<AdminRegisterDTO>(dtoToSave, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			logger.error("Unable to process request due to "+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	
}
