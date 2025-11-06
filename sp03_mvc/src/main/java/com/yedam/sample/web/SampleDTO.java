package com.yedam.sample.web;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class SampleDTO {
	private String name;
	private Integer age;
	private Date date;
	private MultipartFile file;
}
