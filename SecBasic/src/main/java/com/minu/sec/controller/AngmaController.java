package com.minu.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/angma")
public class AngmaController {
	
	@GetMapping("/aaa")
	public String getAAA() {
		return "home";	// 그냥 home.jsp로
	}

}
