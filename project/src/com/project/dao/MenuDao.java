package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.Menu;
import com.project.utils.Hibernate4Util;

public class MenuDao {
	public static void main(String[] args) {
		Menu menu=new Menu();
		menu.setCode("adminConfig");
		menu.setHaveChild(true);
		menu.setTitle("用户管理");
		menu.setRank(1);
		menu.setLink("");
		menu.setParentNode("");
		MenuDao dao=new MenuDao();
		System.out.println(dao.addMenu(menu));
		
	}

	public String addMenu(Menu menu){
		Session session=Hibernate4Util.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.save(menu);
		transaction.commit();
		Hibernate4Util.closeSession(session);
		return "菜单新增成功";
	}
	
	public List<Menu> getMenuList(){
		Session session=Hibernate4Util.getCurrentSession();
		List<Menu> list=(List<Menu>) session.createQuery("from Menu menu").list();
		return list;
	}
}
