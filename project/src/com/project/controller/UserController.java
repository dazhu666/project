package com.project.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@RequestMapping("/user")
@Controller
public class UserController {
	
	@RequestMapping("/register")
	public @ResponseBody Map register(){
		Map<String, Object> map=new HashMap<>();
		Map<String,String> m1=new HashMap<>();
		m1.put("2", "2");
		Map<String,String> m2=new HashMap<>();
		m2.put("2", "2");
		map.put("a", m1);
		map.put("b", m2);
	
		return map;
	}

}
