package com.codex.cxcarz.customer.register.repository;

import com.codex.cxcarz.customer.register.dto.CustomerDTO;

public interface CustomerRegisterRepository {

	CustomerDTO searchByMailId(String emailId) throws Exception;
	CustomerDTO save(CustomerDTO dto);
	CustomerDTO getByUOID(String uoid);
}
