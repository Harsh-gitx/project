package com.codex.cxcarz.driver.register.repository;

import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codex.cxcarz.driver.register.dto.DriverDTO;

@Repository
public class DriverRegImpl implements DriverRegRepository {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(DriverRegImpl.class);
	
	public DriverRegImpl(){
		System.out.println("object created for "+this.getClass().getSimpleName());
	}
	
	@Autowired
	private SessionFactory factory;
	Session session;
	public DriverDTO searchByEmail(String email) throws Exception {
		
		try{
			LOGGER.debug("Entering search by email ID");
			session = factory.openSession();
			
			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(DriverDTO.class);
			criteria.add(Restrictions.ilike("email", email));
			DriverDTO driverDTOPresent = (DriverDTO) criteria.uniqueResult();
			return driverDTOPresent;
		}catch (Exception e) {
			LOGGER.error("Operation failed due to exception");
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return null;
	}
	@Override
	public DriverDTO create(DriverDTO dto) {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			
			System.out.println("inside DAO");
			session.save(dto);
			transaction = session.beginTransaction();
			transaction.commit();
			return dto;
		} catch (Exception e) {

			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	

}
