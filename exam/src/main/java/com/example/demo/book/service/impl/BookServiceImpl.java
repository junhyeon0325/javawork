package com.example.demo.book.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.book.mapper.BookMapper;
import com.example.demo.book.service.BookService;
import com.example.demo.book.service.BookVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
	
	private final BookMapper bookMapper;

	@Override
	public Long insert(BookVO book) {
		return bookMapper.insert(book);
	}

	@Override
	public List<BookVO> getbookList(BookVO bookvo) {
		return bookMapper.getbookList(bookvo);
	}

}
