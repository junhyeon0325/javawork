package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.repository.PostsRepository;
import com.example.demo.service.PostService;
import com.example.demo.service.PostsSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

	final PostsRepository postsRepository;

	@Override
	public Long save(PostsSaveRequestDto requestDto) {
		// postsRepository.save(requestDto.toEntity()) 이거는 return값이 posts이다보니 Long타입인 getId로 return
		return postsRepository.save(requestDto.toEntity()).getId();
	}

}
