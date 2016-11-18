package com.project.dao;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.User;
import com.project.utils.Hibernate4Util;

public class UserDao {
	public static void main(String[] args) {
		Session session=Hibernate4Util.getCurrentSession();
		Transaction tx=session.beginTransaction();
		User user=new User();
		user.setId(UUID.randomUUID());
		user.setLogin("Ð¡Îå");
		user.setPassword("123456");
		user.setMobile("15259715979");
		user.setName("liangdada");
		session.save(user);
		tx.commit();
		Hibernate4Util.closeSession(session);
	}

}
