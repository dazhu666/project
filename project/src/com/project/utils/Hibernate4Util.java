package com.project.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Hibernate4Util{

	private static SessionFactory sessionFactory;
	private static Session session;

	static {
		Configuration config = new Configuration().configure();
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties());
		StandardServiceRegistry ssr = ssrb.build();
		sessionFactory = config.buildSessionFactory(ssr);
	}

	/**
	 * ��ȡSessionFactory
	 * 
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getCurrentSession() {
		session = sessionFactory.openSession();
		return session;
	}

	public static void closeSession(Session session) {

		if (null != session) {
			session.close();
		}
	}

}
