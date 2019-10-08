package com.codex.cxcarz.admin.Dashboard.repository;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codex.cxcarz.admin.Dashboard.DTO.DashboardDTO;
import com.codex.cxcarz.customer.Rides.DTO.RideDTO;
import com.codex.cxcarz.driver.register.dto.DriverDTO;
import com.mysql.cj.jdbc.Driver;

@Repository
public class DashboardRepository {

	@Autowired
	private SessionFactory sf;
	
	
	public Collection<RideDTO> getRides() {
			Session session=sf.openSession();
			Criteria crit=session.createCriteria(RideDTO.class);
			List<RideDTO> l1=crit.list();
			return l1;
	}

	public void assignRideToDriver(RideDTO dto) {
		Session session=sf.openSession();
		Criteria crit2=session.createCriteria(DriverDTO.class);
		Criterion criterion2=Restrictions.eq("id", 1);
		crit2.add(criterion2);
		List<DriverDTO> driver=crit2.list();
		for (DriverDTO driverDTO : driver) {
			if(driverDTO.getFirstName()!=null) {
				driverDTO.setRide(dto);
				session.update(driverDTO);
				session.beginTransaction().commit();
				break;
			}
		}

		// TODO Auto-generated method stub
	}
}
