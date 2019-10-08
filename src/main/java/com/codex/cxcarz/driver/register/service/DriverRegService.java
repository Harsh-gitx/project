package com.codex.cxcarz.driver.register.service;

import com.codex.cxcarz.driver.register.dto.DriverDTO;

public interface DriverRegService {
	
	DriverDTO presave(DriverDTO dto) throws Exception;
	
	DriverDTO create(DriverDTO dto) throws Exception;

}
