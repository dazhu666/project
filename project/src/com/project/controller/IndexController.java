package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/index")
@Controller
public class IndexController {

	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView modelAndView=new ModelAndView();
		System.out.println("qqq");
		modelAndView.setViewName("index");
		return modelAndView;
	}
	@RequestMapping("/login")
	public ModelAndView login(){
		ModelAndView modelAndView=new ModelAndView();
		System.out.println("qqq");
		modelAndView.setViewName("login");
		return modelAndView;
	}
}
