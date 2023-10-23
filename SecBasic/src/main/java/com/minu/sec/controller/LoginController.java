package com.minu.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/angma/mlogin")
	public String myLogin() {
		return "mlogin";
	}
	
	@GetMapping("/mlogin")
	public String mLogin() {
		return "mlogin";
	}
	
	@GetMapping("/angel/youlogin")
	public String youLogin() {
		return "ylogin";
	}

}
