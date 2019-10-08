package com.codex.cxcarz.customer.register.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codex.cxcarz.customer.register.dto.CustomerDTO;

@Repository
public class CustomerRegisterRepositoryImpl implements CustomerRegisterRepository {

	private static final Logger logger = LoggerFactory.getLogger(CustomerRegisterRepositoryImpl.class);

	@Autowired
	private SessionFactory factory;

	public CustomerDTO searchByMailId(String emailId) throws Exception {
		Session session = null;
		try {
			logger.debug("Entering searchByMailId method");
			session = factory.openSession();

			Criteria criteria = session.createCriteria(CustomerDTO.class);
			criteria.add(Restrictions.ilike("emailId", emailId));
			CustomerDTO dtoPresent = (CustomerDTO) criteria.uniqueResult();
			if (dtoPresent != null) {
				return dtoPresent;
			}
		} catch (Exception e) {
			logger.error("Operation failed due to some exception");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public CustomerDTO save(CustomerDTO dto) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			logger.debug("Entering searchByMailId method");
			session.save(dto);
			transaction.commit();
			return dto;
		} catch (Exception e) {
			transaction.rollback();
			logger.error("Unable to process due to some exception " + e.getMessage());
		} finally {
			session.close();
		}
		return dto;

	}

	@Override
	public CustomerDTO getByUOID(String uoid) {

		Session session = null;
		try {
			logger.debug("Entering getByUOID method");
			session = factory.openSession();

			Criteria criteria = session.createCriteria(CustomerDTO.class);
			criteria.add(Restrictions.ilike("uuid", uoid));
			CustomerDTO dtoPresent = (CustomerDTO) criteria.uniqueResult();
			if (dtoPresent != null) {
				return dtoPresent;
			}
		} catch (Exception e) {
			logger.error("Operation failed due to some exception");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;

	}
}
