package com.codex.cxcarz.customer.register.service;

import com.codex.cxcarz.customer.register.dto.CustomerDTO;

public interface CustomerRegistrationService {

	CustomerDTO preSave(CustomerDTO dto) throws Exception;
	CustomerDTO save(CustomerDTO dto);
	CustomerDTO checkUoid(String uoid);

}
