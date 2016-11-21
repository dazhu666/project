package com.project.dao;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.model.User;
import com.project.utils.Hibernate4Util;
import com.project.utils.RedisUtil;

import redis.clients.jedis.Jedis;

public class UserDao {
	public static void main(String[] args) {
		Jedis jedis=RedisUtil.getJedis();
		if(jedis.hexists("DZ", "d1")){
			System.out.println(jedis.hget("DZ", "d1"));
		}else{
			jedis.hset("DZ", "d1", "成功存入redis");
		}
		RedisUtil.returnResource(jedis);
	}
	
	public String saveUser(String name,String mobile,String login,String password){
		Session session=Hibernate4Util.getCurrentSession();
		Transaction tx=session.beginTransaction();
		User user=new User();
		user.setLogin(login);
		user.setPassword(password);
		user.setMobile(mobile);
		user.setName(name);
		session.save(user);
		tx.commit();
		Hibernate4Util.closeSession(session);
		return "保存成功！";
	}
	
	public User getUser(){
		Session session=Hibernate4Util.getCurrentSession();
		UUID uuid=UUID.fromString("@�k�UG�_��^");
		User u=(User) session.get(User.class, uuid);
		return u;
	}

}
