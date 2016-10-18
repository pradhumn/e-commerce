package com.clothing.sarees.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import com.clothing.sarees.model.Product;

public class ProductDao implements ProductDaoInterface<Product, Serializable> {

	
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
	
	public void persist(Product entity) {
		getCurrentSession().save(entity);
		
	}

	public void update(Product entity) {
        getCurrentSession().update(entity);		
	}

	public Product findById(int id) {
		Product product= (Product) getCurrentSession().get(Product.class, id);
		return product;
	}

	public void delete(Product entity) {
		getCurrentSession().delete(entity);
		
	}

	public List<Product> findAll() {
		List<Product> products = (List<Product>) getCurrentSession().createQuery("from Product").list();
		return products;
	}

	public void deleteAll() {
		List<Product> products=findAll();
		for(Product product:products) {
			delete(product);
		}
		
	}

}
