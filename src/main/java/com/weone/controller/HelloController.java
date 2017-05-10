package com.weone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {
	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView("/hello");
		mav.addObject("hello", "hello");
		return mav;
	}
	
	@RequestMapping("/")
	public ModelAndView home() {
		return  new ModelAndView("/home");
	}
}
