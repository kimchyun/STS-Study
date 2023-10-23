package com.minu.sec.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.minu.sec.vo.AuthVO;
import com.minu.sec.vo.MemberVO;

@Mapper	// mybatis-scan 설정해 놓았기 때문에 생략가능
public interface MemberMapper {
	
	// 테스트용 2개 메소드
	public int insertMember(MemberVO member);
	public int insertAuth(AuthVO auth);	
	
	// 실제 필요한 메소드는 이것만
	public MemberVO read(String userid);
}
