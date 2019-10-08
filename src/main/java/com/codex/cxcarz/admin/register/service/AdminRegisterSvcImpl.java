package com.codex.cxcarz.admin.register.service;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.codex.cxcarz.admin.register.dto.AdminRegisterDTO;
import com.codex.cxcarz.admin.register.service.AdminRegisterSvc;

import com.codex.cxcarz.admin.register.repository.AdminRegisterRepository;

@Service
public class AdminRegisterSvcImpl implements AdminRegisterSvc {

	private static final Logger logger = LoggerFactory.getLogger(AdminRegisterSvcImpl.class);
	@Autowired
	private AdminRegisterRepository repository;
	public AdminRegisterDTO preSave(AdminRegisterDTO dtoToSave) throws Exception {
		try {
			if (StringUtils.isEmpty(dtoToSave.getEmailId()) && StringUtils.isEmpty(dtoToSave.getfName())
					&& StringUtils.isEmpty(dtoToSave.getlName()) && StringUtils.isEmpty(dtoToSave.getPassword())) {
              logger.debug("Completed String validation ");
              AdminRegisterDTO dtoIsPresent= repository.findByEmailId(dtoToSave.getEmailId());
			  if(dtoIsPresent != null) {
				  logger.debug("He/She is alraedy a registered user");
				  return null;
			  }
			  if(Objects.nonNull(dtoToSave.getMobileNumber())) {
				  logger.debug("Validation for non-String validation");
				   AdminRegisterDTO dtoAfterSave= repository.create(dtoToSave);
			       if(dtoAfterSave!=null)
			       {
			    	   logger.debug("Profile created for "+dtoAfterSave.getfName() +""+ dtoAfterSave.getlName());
			           return dtoAfterSave; 
			       }
			  }
			}

		} catch (Exception e) {
			logger.error("Unable to process in service due to "+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public AdminRegisterDTO create(AdminRegisterDTO dtoToSave) throws Exception {
		return repository.create(dtoToSave);
	}

}
