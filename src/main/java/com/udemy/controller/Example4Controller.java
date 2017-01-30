package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example4")
public class Example4Controller {

	private final static String ERROR = "500";
	
	@GetMapping("/test")
	public String doTest(){
		return ERROR;
	}
}
