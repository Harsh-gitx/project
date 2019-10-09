package com.codex.cxcarz.customer.register.service;

import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.codex.cxcarz.customer.register.dto.CustomerDTO;
import com.codex.cxcarz.customer.register.repository.CustomerRegisterRepository;

@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRegistrationServiceImpl.class);
	
	@Autowired
	private CustomerRegisterRepository rep;
//	@Autowired
//	private CustomerRegisterRepository repositrory;
//	
//	@Autowired
//	private CustomerRegisterRepository repo;
	@Autowired
	private JavaMailSender mailSender;

	public CustomerDTO preSave(CustomerDTO dto) throws Exception {
		try {
			//LOGGER.debug("Entering preSave method " + dto);
			if (!StringUtils.isEmpty(dto.getEmailId()) ) {
//				LOGGER.debug("Completed validation for String types");
				CustomerDTO dtoPresent = rep.searchByMailId(dto.getEmailId());
				System.out.println(dtoPresent);
				if (dtoPresent != null) {
					repeatSendMail(dtoPresent);
					return null;
				}else {
//					if(!dto.isAdmin())
//						{
//							successSendMail(dto);
//						}
				}
				
					return dtoPresent;

				

			}
		} catch (Exception e) {

		}
		return null;
	}

	private void repeatSendMail(CustomerDTO dtoPresent) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(dtoPresent.getEmailId());
		mailMessage.setSubject("Repeated Registration");
		mailMessage.setText("Hi " + dtoPresent.getUserName() + ""
				+ "you have already successfully registered for cxcarz" + "." + "So you cannot register again");
	}

	public CustomerDTO save(CustomerDTO dto) {
		dto.setUuid(UUID.randomUUID().toString());
		CustomerDTO dtoAfterSave = rep.save(dto);
		System.out.println("Inside save"+dtoAfterSave.getEmailId());
		System.out.println(dtoAfterSave.getEmailId());
		if (dtoAfterSave != null) {
			
			successSendMail(dtoAfterSave);
			return dtoAfterSave;
		}
		return null;
	}

	private void successSendMail(CustomerDTO dtoAfterSave) {
		try {
			//LOGGER.debug("Enter successSendMail method");
			System.out.println("entering email sending method");
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(dtoAfterSave.getEmailId());
			mailMessage.setSubject("Registration Confirmation mail");
			mailMessage.setText("Hi " + dtoAfterSave.getUserName()  
					+ "you have successfully registered for cx carz. The username: " + dtoAfterSave.getUserName()
					+ "and password: " + dtoAfterSave.getPassword()
					+ " for future communication. Please do click on activation link http://localhost:8080/cxcarz/activateLink?uoid="
					+ dtoAfterSave.getUuid());
			mailSender.send(mailMessage);
			System.out.println("success");
		} catch (Exception e) {
			System.out.println("unable to send mail");
			//LOGGER.error("Sorry unable to send mail due to some exception " + e.getMessage());
		}

	}

	@Override
	public CustomerDTO checkUoid(String uoid) {
	    try {
			if (!StringUtils.isEmpty(uoid)) {
				LOGGER.debug("Validation completed");
				 CustomerDTO dto= rep.getByUOID(uoid);
				 if(dto!=null) {
					 return dto;
				 }
			}
		} catch (Exception e) {
			LOGGER.error("Sorry unable to process due to some exception "+e.getMessage());
		}
		return null;
	}

}
