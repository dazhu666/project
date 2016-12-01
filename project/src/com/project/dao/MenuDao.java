package com.project.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.Menu;
import com.project.utils.Hibernate4Util;

public class MenuDao {

	public String addMenu(Menu menu){
		Session session=Hibernate4Util.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		return "菜单新增成功";
	}
}
