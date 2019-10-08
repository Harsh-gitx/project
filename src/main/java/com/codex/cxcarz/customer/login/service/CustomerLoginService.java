package com.codex.cxcarz.customer.login.service;

import com.codex.cxcarz.customer.register.dto.CustomerDTO;

public interface CustomerLoginService {

	boolean checkLogin(CustomerDTO dto);

}
