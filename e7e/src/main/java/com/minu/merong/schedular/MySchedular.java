package com.minu.merong.schedular;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MySchedular {
	
	@Scheduled(fixedDelay = 3000)	// 3초마다 강혁이 미움!
	public void gangHate() {
		log.debug("강혁이 정말 미워! 밉당!");
	}
					 //초  분 시간 일 월 요일  - 10초가 되면 시작하라 (ex: 1분 10초, 2분 10초)
	@Scheduled(cron = "10 37 * * * *" )	// 3초마다 강혁이 미움!
	public void gangHate2() {
		log.debug("강혁이 정말 미워! 37분 10초에 밉당!");
	}
}
