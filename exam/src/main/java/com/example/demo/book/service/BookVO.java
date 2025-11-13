package com.example.demo.book.service;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BookVO {
	private Long bookNo;
	private String bookName;
	private String bookCoverimg;
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date bookDate;
	private Long bookPrice;
	private String bookPublisher;
	private String bookInfo;
}
