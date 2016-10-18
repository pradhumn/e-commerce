package com.clothing.sarees.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.clothing.sarees.model.customer;

public class CustomerDao implements CustomerDaoInterface<customer, Integer> {

	private Session currentSession;
	private Transaction currentTransaction;

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	public SessionFactory getSessionFactory() {
		try {
			// For XML mapping
			// return new Configuration().configure().buildSessionFactory();

			// For Annotation
			return new AnnotationConfiguration().configure().buildSessionFactory();

		} catch (Throwable ex) {

			throw new ExceptionInInitializerError(ex);
		}
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void persist(customer entity) {
		getCurrentSession().save(entity);
	}

	public void update(customer entity) {
		getCurrentSession().update(entity);
	}

	public customer findById(int id) {
		customer customer = (customer) getCurrentSession().get(customer.class, id);
		return customer;
	}

	public void delete(customer entity) {
		getCurrentSession().delete(entity);

	}

	public List<customer> findAll() {
		List<customer> customer = (List<customer>) getCurrentSession().createQuery("from customer").list();
		return customer;
	}

	public void deleteAll() {
		 List<customer> entityList = findAll();
		  for (customer entity : entityList) {
		  delete(entity);
	}
	}

}
