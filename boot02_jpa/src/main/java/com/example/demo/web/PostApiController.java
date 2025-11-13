package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.PostService;
import com.example.demo.service.PostsSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostApiController {
	
	// final이랑 RequiredArgsConstructor이거 두개는 같이 따라다닌다.
	final PostService postService; // 생성자 주입
	
	// RequestBody 는 json방식으로 하는거다.
	@PostMapping("/api/v1/posts")
	public Long save(@RequestBody PostsSaveRequestDto requestDto) {
		return postService.save(requestDto);
	}
	
	// 요렇게도 페이지 이동이 가능하다
//	@GetMapping("/posts")
//	public ModelAndView posts() {
//		return new ModelAndView("posts");
//	}
}
