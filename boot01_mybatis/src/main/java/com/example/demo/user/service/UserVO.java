package com.example.demo.user.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserVO implements UserDetails { 
	// 머머 추상메소드를 만들어야한다고하심
	// UserVO는 우리가 사용하는 머머다 라고 하시면서 만듬
	private Long id;
	private String loginId;
	private String password;
	private String fullName;
	private String deptName;
	private List<String> role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<>();
		for(String r : role) {
			list.add(new SimpleGrantedAuthority(r));
		}
		return list;
	}

	@Override
	public String getUsername() {
		return loginId;
	}

	
	
	
}
