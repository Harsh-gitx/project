package com.codex.cxcarz.admin.register.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.codex.cxcarz.admin.register.dto.AdminRegisterDTO;

@Repository
public class AdminRegisterRepositoryImpl implements AdminRegisterRepository {

	private static final Logger logger = LoggerFactory.getLogger(AdminRegisterRepositoryImpl.class);
	@Autowired
	private SessionFactory factory;

	public AdminRegisterDTO findByEmailId(String emailId) throws Exception {
        //LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        //bean.setAnnotatedClasses(annotatedClasses);
		Session session = factory.openSession();
		try {
			logger.debug("Searching for Profile with this mail id");
			Criteria criteria = session.createCriteria(AdminRegisterDTO.class);
			criteria.add(Restrictions.ilike("emailId", emailId, MatchMode.EXACT));
			AdminRegisterDTO dtoFound = (AdminRegisterDTO) criteria.uniqueResult();
			if (dtoFound != null) {
				return dtoFound;
			}
		} catch (Exception e) {
			logger.error("Unable to process due to " + e.getMessage());
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public AdminRegisterDTO create(AdminRegisterDTO dtoToSave) throws Exception {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			session.save(dtoToSave);
			transaction = session.beginTransaction();
			transaction.commit();
			return dtoToSave;
		} catch (Exception e) {

			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
