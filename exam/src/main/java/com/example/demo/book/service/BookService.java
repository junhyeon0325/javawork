package com.example.demo.book.service;

import java.util.List;

public interface BookService {
	
	// 등록
	public Long insert(BookVO book);
	
	// 도서목록조회
	List<BookVO> getbookList(BookVO bookvo);
}
