package com.minu.merong.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice // 일일이 컨트롤러에 등록하지 않고, 예외처리 공통사용!
public class CommonExceptionHandler {

	// NullPointerException 핸들링(운전)!
	@ExceptionHandler(NullPointerException.class)
//	@ResponseBody
	public String nullHandle(NullPointerException e, Model model) {
		log.debug("여기로 왔나?"); // 여기 왔는 지 체크!
		model.addAttribute("exception","예외!" + e.getMessage());
		return "This is Null Common " + e.getMessage();
	}
	
	// 못 찾겠다 핸들링
	@ExceptionHandler(NullPointerException.class)
	@ResponseBody
	public String notFoundHandle(NoHandlerFoundException e) {
		log.debug("여기로 왔나?"); // 여기 왔는 지 체크!
		return "Not Found" + e.getMessage();
	}

	// 별로 필요한 예외처리들 등록
	
	// 맨 마지막엔 이걸 넣어서, 기타 예외들 처리하면 됨!
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String exception(Exception e) {
		return "관심없는 예외들 " + e.getMessage();
	}

}
