package com.minu.sec.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;


@Slf4j
//@Controller
@RequestMapping("/angma")
public class SecController {
	
	@GetMapping("/minu")
	public String minu(Authentication auth) {
		log.debug("auth:" + auth);
		log.debug("auth:" + ((User)auth.getPrincipal()).getUsername());
		log.debug("auth:" + ((User)auth.getPrincipal()).getPassword());
		log.debug("auth:" + auth.getAuthorities());
		
		// 시큐리티 포인트!
		SecurityContext secCont = SecurityContextHolder.getContext();
		
		log.debug("check:" + secCont);
		
		return "minu";
	}
	
	@GetMapping("/hyunhak")
	public String hyunhak() {
		return "hyunhak";
	}
	
	@PostMapping("/yerin")
	@ResponseBody
	public String yerin(@RequestBody String mName) {
		return mName + "Stop There!";
	}
}
