package com.codex.cxcarz.driver.register.repository;

import com.codex.cxcarz.driver.register.dto.DriverDTO;

public interface DriverRegRepository {
	
	DriverDTO searchByEmail(String email) throws Exception;
	DriverDTO create(DriverDTO dto);
}
