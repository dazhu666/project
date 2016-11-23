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
	public @ResponseBody String register(){
		Map<String, String> map=new HashMap<>();
		map.put("a", "1");
		map.put("b", "2");
	
		return "aa";
	}

}
