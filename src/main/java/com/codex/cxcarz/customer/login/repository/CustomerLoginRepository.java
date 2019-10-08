package com.codex.cxcarz.customer.login.repository;

import com.codex.cxcarz.customer.register.dto.CustomerDTO;

public interface CustomerLoginRepository {



	boolean checkLogin(CustomerDTO dto);
}
