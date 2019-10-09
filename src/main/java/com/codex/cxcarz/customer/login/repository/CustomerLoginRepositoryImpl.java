package com.codex.cxcarz.customer.login.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codex.cxcarz.customer.register.dto.CustomerDTO;

@Repository
public class CustomerLoginRepositoryImpl implements CustomerLoginRepository {

	private static final Logger logger = LoggerFactory.getLogger(CustomerLoginRepositoryImpl.class);

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


	@Override
	public CustomerDTO checkLogin(CustomerDTO dto) {
		System.out.println(dto.getEmailId());
		System.out.println(dto.getPassword());
	Session sess=factory.openSession();
	Criteria crit=sess.createCriteria(CustomerDTO.class);
	Criterion criterion1=Restrictions.eq("emailId", dto.getEmailId());
	Criterion criterion2=Restrictions.eq("password", dto.getPassword());
	crit.add(criterion1);
	crit.add(criterion2);
	
	CustomerDTO customer=(CustomerDTO)crit.uniqueResult();
//	System.out.println(customer.getEmailId());
	//System.out.println(customer.isAdmin());
	if(customer!=null)
		return customer;
		// TODO Auto-generated method stub
    return null;
	}
}
