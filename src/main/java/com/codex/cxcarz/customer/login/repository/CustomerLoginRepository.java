package com.codex.cxcarz.customer.login.repository;

import com.codex.cxcarz.customer.register.dto.CustomerDTO;

public interface CustomerLoginRepository {



	CustomerDTO checkLogin(CustomerDTO dto);
}
