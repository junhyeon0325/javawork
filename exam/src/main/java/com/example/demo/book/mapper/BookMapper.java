package com.example.demo.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.book.service.BookVO;

@Mapper
public interface BookMapper {
	// 등록
	public Long insert(BookVO book);
	// 전체조회
	public List<BookVO> getbookList(BookVO bookvo);
}
