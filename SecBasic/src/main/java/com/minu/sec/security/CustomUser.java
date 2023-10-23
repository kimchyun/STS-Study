package com.minu.sec.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.minu.sec.vo.MemberVO;

import lombok.Getter;

@Getter
public class CustomUser extends User {
	private static final long serialVersionUID = 1L;
	private MemberVO member;
	
	public CustomUser(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	// 시큐리티가 주는 정보가 3개 밖에 안 돼서, 우리가 필요한 걸 더 붙임 (멤버필드/속성으로)
	// 필요할 때마다 id로 select하는 것 보다 자주 쓰는 걸 그냥 붙여놓고 씀
	public CustomUser(MemberVO vo) {
		super(vo.getUserid(), vo.getUserpw(), 
			vo.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		this.member = vo;		// 이것이 실제 핵심, 추가정보 붙여놓기
	}
}
