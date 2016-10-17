package com.clothing.sarees;

import java.util.Date;
import org.hibernate.Session;
import com.clothing.sarees.dao.HibernateUtil;
import com.clothing.sarees.model.customer;

public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate Annotation + Oracle");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		customer user = new customer();
		
		
		user.setCustomerId(120);
		user.setFirstName("fn");
		user.setLastName("ln");
		user.setEmail("email.id");
		user.setPassword("pass");
		session.delete(user);
		session.save(user);
		session.getTransaction().commit();
	}
}
