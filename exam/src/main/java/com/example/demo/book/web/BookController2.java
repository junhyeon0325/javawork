package com.example.demo.book.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.book.service.BookService;
import com.example.demo.book.service.BookVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BookController2 {

	final BookService bookService;

//	// 도서등록 페이지
//	@GetMapping("/book")
//	public ModelAndView book() {
//		return new ModelAndView("book");
//	}
//
//	// 도서 등록
//	@PostMapping("/book")
//	public Long reg(@RequestBody BookVO bookvo) {
//		return bookService.insert(bookvo);
//	}
	
//	// 도서별 대여매출현황 페이지
//	@GetMapping("/booklist")
//	public ModelAndView booklist() {
//		return new ModelAndView("booklist");
//	}

	// 도서목록조회/수정 페이지 (기존 @GetMapping("/list") 메소드 사용)
    @GetMapping("/list")
    public String list(Model model) { // Model 객체를 파라미터로 받음
        
        // 1. DB에서 도서 목록을 조회합니다.
        List<BookVO> bookList = bookService.getbookList(new BookVO()); 
        
        // 2. 조회된 목록을 Model 객체에 "bookList"라는 이름으로 담아 뷰로 전달합니다.
        model.addAttribute("bookList", bookList);
        
        // 3. 뷰 템플릿 이름("list.html")을 반환합니다.
        return "list"; 
    }

}
