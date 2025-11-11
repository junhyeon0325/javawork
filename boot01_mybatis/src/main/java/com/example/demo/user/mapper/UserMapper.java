package com.example.demo.user.mapper;

import java.util.List;

import com.example.demo.user.service.UserVO;

public interface UserMapper {
	UserVO getUser(String loginId);
	List<String> getRole(Long id);
}
