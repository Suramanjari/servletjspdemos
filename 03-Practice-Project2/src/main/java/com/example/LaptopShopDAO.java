package com.example;


import java.math.BigDecimal;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaptopShopDAO {

	public void addLaptop(String name, String color, String price) {
		try {
			Configuration configuration = new Configuration();
			SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			laptops laptops = new laptops();
			laptops.setName(name);
			laptops.setColor(color);
			laptops.setPrice(BigDecimal.valueOf(Double.parseDouble(price)));
			session.save(laptops);
			transaction.commit();
			session.close();
		} catch(HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}
	}
}