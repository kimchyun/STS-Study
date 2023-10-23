package com.minu.merong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.minu.merong.service.Yerin;
import com.minu.merong.vo.YerinVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/rest")
public class YerinController {
	
	@Autowired
	private Yerin yerinSVC;
	
	@GetMapping("/index")
	public String getView() {
		return "yerin";
	}
	
	// RESTFUL방식을 적용하면 기본 5가지(get(리스트,1개),post,delete)
	// 리스트 조회
	@ResponseBody
	@GetMapping(value="/yerins", produces="application/json;charset=utf-8")
	public List<YerinVO> getYerins() {
		log.debug("체킁킁:"+yerinSVC);	// null이 찍혀야 함! 왜? autowired 안 했으니까
		return yerinSVC.listData();
	}
	
	// 1개 조회
	@ResponseBody
	@GetMapping(value="/yerin/{title}", produces="application/json;charset=utf-8")
	public YerinVO getYerin(@PathVariable String title) {
		YerinVO yerinVO = new YerinVO();
		yerinVO.setTitle(title);
		return yerinSVC.oneData(yerinVO);
	}
	
	// 1개 insert
	@ResponseBody
	@PostMapping(value="/yerin", produces="application/json;charset=utf-8")
	public String postYerin(@RequestBody YerinVO yerinVO) {
		return Integer.toString(yerinSVC.insertData(yerinVO));
	}

	// 1개 수정
	@ResponseBody
	@PutMapping(value="/yerin", produces="application/json;charset=utf-8")
	public String putYerin(@RequestBody YerinVO yerinVO) {
		return Integer.toString(yerinSVC.updateData(yerinVO));
	}
	
	// 1개 삭제
	@ResponseBody
	@DeleteMapping(value="/yerin/{title}", produces="application/json;charset=utf-8")
	public String deleteYerins(@PathVariable String title) {
		YerinVO yerinVO = new YerinVO();
		yerinVO.setTitle(title);
		return Integer.toString(yerinSVC.deleteData(yerinVO));
	}
	
	// 컨트롤러마다 일일이 별도 예외처리를 하면 너무 힘들다!
	/*
	// NullPointerException 핸들링(운전)!
	@ExceptionHandler(NullPointerException.class)
	@ResponseBody
	public String nullHandle(NullPointerException e) {
		log.debug("여기로 왔나?");		// 여기 왔는 지 체크!
		return "Are you Null " + e.getMessage();
	}
	
	// 못 찾겠다 핸들링(운전)!
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseBody
	public String notFoundHandle(NullPointerException e) {
		return e.getMessage();
	}
	*/
}
