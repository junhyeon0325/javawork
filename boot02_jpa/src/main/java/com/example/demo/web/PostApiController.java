package com.example.demo.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.PostService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostApiController {
	
	// final이랑 RequiredArgsConstructor이거 두개는 같이 따라다닌다.
	final PostService postService; // 생성자 주입
	
	@PostMapping("/api/v1/posts")
	public Long save(PostsSaveRequestDto requestDto) {
		postService.save(requestDto);
	}
}
