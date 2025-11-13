package com.example.demo.service;

import com.example.demo.repository.Posts;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 기본생성자 생성
@Data // 여기는 읽고 쓰고가 가능해야해서 Data를 사용함
public class PostsSaveRequestDto {
	
	String title;
	String content;
	String author;
	
	// source해서 생성자 생성
	@Builder
	public PostsSaveRequestDto(String title, String content, String author) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	public Posts toEntity() {
		return Posts.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
	}
}
