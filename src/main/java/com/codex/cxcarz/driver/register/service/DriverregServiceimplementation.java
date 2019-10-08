package com.codex.cxcarz.driver.register.service;

import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.codex.cxcarz.driver.register.dto.DriverDTO;
import com.codex.cxcarz.driver.register.repository.DriverRegRepository;
import com.codex.cxcarz.admin.register.dto.AdminRegisterDTO;

@Service
public class DriverregServiceimplementation implements DriverRegService {

	public DriverregServiceimplementation() {
		System.out.println("object created for " + this.getClass().getSimpleName());
	}

	private static final Logger logger = LoggerFactory.getLogger(DriverregServiceimplementation.class);
	
	@Autowired
	private DriverRegRepository driverRegRepository;
	
	public DriverDTO presave(DriverDTO dto) throws Exception {

		logger.debug("Entering presave method of driverDTO");

		if (!StringUtils.isEmpty(dto.getEmail()) && !StringUtils.isEmpty(dto.getFirstName())
				&& !StringUtils.isEmpty(dto.getLastName())) {
			logger.debug("Compleated validation for string types ");
			DriverDTO dto2Present = driverRegRepository.searchByEmail(dto.getEmail());
			if (Objects.nonNull(dto.getDOB()) && Objects.nonNull(dto.getPhoneNum())) {
				logger.debug("completed validation of non-string types");
				return dto2Present;
			}
		}
		return null;
	}
	public DriverDTO create(DriverDTO dtoToSave) throws Exception {
		System.out.println("inside create of service");
		if(driverRegRepository.create(dtoToSave)!=null) {
			return dtoToSave;
		}
		return null;
	}
	

}
