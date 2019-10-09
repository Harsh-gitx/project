package com.codex.cxcarz.customer.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codex.cxcarz.customer.login.service.CustomerLoginService;
import com.codex.cxcarz.customer.register.dto.CustomerDTO;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private CustomerLoginService service;
	
	@RequestMapping(value="/loginUser.do",method=RequestMethod.POST)
	public ResponseEntity<CustomerDTO> loginUser(@RequestBody CustomerDTO dto) {
		CustomerDTO cust=service.checkLogin(dto);
			if(cust!=null) {
				return new ResponseEntity<CustomerDTO>(cust,HttpStatus.OK);
			}
		return null;
	}
	
}
