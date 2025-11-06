package com.yedam.sample.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/sample/*")
public class SampleController {

	@RequestMapping(value = "insert", method = { RequestMethod.POST, RequestMethod.PUT }) // /sample를 부르면 일로온다?
	public void basic() {
		log.info("basic....");
//		System.out.println("basic....");
	}
	
	@GetMapping("/ex01") // ex01?name=aaa&age=15
	public void ex01(SampleDTO sample) {
		log.info("sampleDTO: " + sample);
	}

	@GetMapping("/ex02") // ex02?name=aaa&age=20
	// name은 필수값으로 파라미터를 넣어야하고, required false로 하면 안적어줘도된다
	public String ex02(@RequestParam("name") String name,
			@RequestParam(value = "age", required = false, defaultValue = "10") int age) {
		log.info(name + ":" + age);
		return "ex02";
	}

	@GetMapping("/ex02Array") // ex02Array?ids=3&ids=4&id=10 // 체크박스
	public void ex02Array(@RequestParam("ids") List<String> ids) {
		log.info("ids:" + ids);
	}
}
