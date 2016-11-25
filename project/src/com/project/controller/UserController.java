package com.project.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.dao.UserDao;



@RequestMapping("/user")
@Controller
public class UserController {
	
	@RequestMapping("/register")
	public @ResponseBody Map register(String login,String password,String mobile){
		
	UserDao dao=new UserDao();
	dao.saveUser(login, mobile, login, password);
	
	Map map=new HashMap<>();
	map.put("message", "注册成功！");
		return map;
	}

}
