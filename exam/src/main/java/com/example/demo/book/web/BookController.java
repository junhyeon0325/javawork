package com.example.demo.book.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.book.service.BookService;
import com.example.demo.book.service.BookVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BookController {

	final BookService bookService;

	// 도서등록 페이지
	@GetMapping("/book")
	public ModelAndView book() {
		return new ModelAndView("book");
	}

	// 도서 등록
	@PostMapping("/book")
	public Long reg(@RequestBody BookVO bookvo) {
		return bookService.insert(bookvo);
	}

	// 도서목록조회/수정 페이지
	@GetMapping("/list")
	public ModelAndView list() {
		return new ModelAndView("list");
	}

	// 도서별 대여매출현황 페이지
	@GetMapping("/booklist")
	public ModelAndView booklist() {
		return new ModelAndView("booklist");
	}

	// 도서목록조회/수정 조회
	@GetMapping("/list/book") // localhost/board/10/reply
	public List<BookVO> select(BookVO bookvo) {
		return bookService.getbookList(bookvo);
	}
}
