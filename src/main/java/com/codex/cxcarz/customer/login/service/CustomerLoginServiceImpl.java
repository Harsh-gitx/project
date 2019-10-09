package com.codex.cxcarz.customer.login.service;

import java.util.Objects;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.codex.cxcarz.customer.login.repository.CustomerLoginRepository;
import com.codex.cxcarz.customer.register.dto.CustomerDTO;
import com.codex.cxcarz.customer.register.repository.CustomerRegisterRepository;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerLoginServiceImpl.class);

	@Autowired
	private CustomerLoginRepository repository;


	public CustomerDTO checkLogin(CustomerDTO dto) {
		return repository.checkLogin(dto);
	}


	
}
