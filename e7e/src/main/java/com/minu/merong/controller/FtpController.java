package com.minu.merong.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.minu.merong.utils.FtpUtils;

@Controller
@RequestMapping("/ftp")
public class FtpController {
	
	@Autowired
	private FtpUtils ftpUtils;
	
	@GetMapping("/main")
	public String main() {
		return "ftpmain";
	}
	
	@GetMapping("/download/{fName}")
	public void down(@PathVariable String fName, HttpServletResponse resp) throws IOException {
		ftpUtils.downlod(fName,resp);
	}
	
	@PostMapping("/upTest")
	@ResponseBody	// 그냥 jsp 안 만들라고!
	public String upTest(MultipartFile myFile) throws IOException {
		
		ftpUtils.upload(myFile);
		return "OK";
	}
}
