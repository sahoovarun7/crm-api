package com.ghostack.webtrackerapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ghostack.webtrackerapi.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	private EntityManager sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.unwrap(Session.class);
		Query<Customer> query = currentSession.createQuery("FROM Customer ORDER BY firstName",Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session currentSession = sessionFactory.unwrap(Session.class);
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(Integer custID) {
		Session currentSession = sessionFactory.unwrap(Session.class);
		Customer customer = currentSession.get(Customer.class, custID);
		return customer;
	}

	@Override
	public void deleteCustomer(Integer custID) {
		Session currentSession = sessionFactory.unwrap(Session.class);
		Query query = currentSession.createQuery("DELETE FROM Customer c WHERE c.id=:custID");
		query.setParameter("custID", custID);
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomer(String searchName) {
		Session currentSession = sessionFactory.unwrap(Session.class);
		Query<Customer> query = null;
		if(searchName != null && searchName.trim().length() > 0) {
			query = currentSession.createQuery("FROM Customer c WHERE c.firstName like :first ",Customer.class);
			query.setParameter("first", "%" + searchName + "%");
		}
		else
			query = currentSession.createQuery("FROM Customer",Customer.class); 
		return query.getResultList();
	}

}
