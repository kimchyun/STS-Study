package com.minu.merong.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.minu.merong.vo.TestVO;

import lombok.extern.slf4j.Slf4j;

//@Controller + @ResponseBody
//@RestController
@Slf4j
@Controller
@RequestMapping(value="/silver")
public class SilverRainController {
	
	@GetMapping("/test")
	public String getTest() {
		return "test";
	}
	
	//@RequestMapping(value="/rain",method = RequestMethod.GET)
	@GetMapping("/rain/{name2}")
	@ResponseBody
	public String getRain(@PathVariable String name2) {
		System.out.println("체킁:"+name2);
		return "GoldRain";
	}
	
	@PostMapping(value="/rain",produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<String> postRain(@RequestBody List<String> myList) {
		log.debug(""+myList);
		
		
		//return "{\"name\":\"KGB\"}"; // {name:"kgb"}
		
		/*
		List<String> myList = new ArrayList<String>();
		for(int i=0; i<10; i++) {
			myList.add("Hello"+i);
		}
		*/
		
		return myList;
	}
	
	@PutMapping(value="/rain",produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String, String> putRain() {
		Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("name", "메롱");
		myMap.put("age", "19");
		
		return myMap;
	}
	
	@DeleteMapping("/rain")
	@ResponseBody
	public TestVO deleteRain(@RequestBody TestVO testVO) {
		
		log.debug(""+testVO);
		/*
		System.out.println(myMap.get("name"));
		System.out.println(myMap.get("age"));
		System.out.println(myMap.get("alias"));
		*/
		
		return testVO;
		//return "This is delete";
	}
	
	/* @ResponseBody의 역할
	public void getRain(HttpServletResponse resp) throws Exception {
		
		resp.getWriter().write("Silver Merong");
		//return "SilverRain";
	}
	*/
}
