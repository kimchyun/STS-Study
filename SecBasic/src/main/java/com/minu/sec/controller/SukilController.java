package com.minu.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SukilController {
	
	@GetMapping("/slogin")
	public String sukilLogin() {
		return "slogin";	// id, 암호 입력 페이지!
	}
}
