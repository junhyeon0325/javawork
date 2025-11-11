package com.yedam.sample.web;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/sample/*")
public class SampleController {
	
	@GetMapping("/success")
	public String success() {
		return "/success";
	}

	@RequestMapping(value = {"insert","/"}, method = { RequestMethod.POST, RequestMethod.GET }) // /sample를 부르면 일로온다?
	public void basic() {
		log.info("basic....");
//		System.out.println("basic....");
	}
	
	@GetMapping("/ex01") // ex01?name=aaa&age=15
	public String ex01(@ModelAttribute("sample") SampleDTO sample, RedirectAttributes ra) {
		log.info("sampleDTO: " + sample);
		
		// addFlashAttribute를 하면은 처음에 등록버튼 눌렀을때 첫 화면에서는 "가입축하"라는 알림창이 나타나는데
		// 그 결과창에서 F5번을 누르면 "가입축하"가 안나옴
		// addAttribute를 하면은 F5번을 할때마다 "가입축하"가 계속 뜸
		ra.addFlashAttribute("msg", "가입축하"); // 특수문자 들어가면 인코딩을 해줘야하는데 지금 인코딩을 안하고있어서 뺐음
		ra.addAttribute("name", sample.getName());
		// 커맨더객체는 여러개를 적을 수 있다는데?
//		return "redirect:success"; // 상대경로 : http://localhost:81/sample/success
		return "redirect:/sample/success"; // 절대경로 http://localhost:81/success
	}

	@GetMapping("/ex02") // ex02?name=aaa&age=20
	// name은 필수값으로 파라미터를 넣어야하고, required false로 하면 안적어줘도된다
	// 가능하다는걸 보여준거고 for를 써라는데 무슨소리지
	public String ex02(@ModelAttribute("name")
				       @RequestParam("name") String name,
				       
				       @DateTimeFormat(pattern = "yyyy-MM-dd")
					   @RequestParam(value = "birth") Date birth,
					   @RequestParam(value = "age",
			              			 required = false,
			              			 defaultValue = "10") int age, 
					   Model model) {
		log.info(name + ":" + age + ":" + birth);
		model.addAttribute("name", name);
		return "ex02";
	}

	@GetMapping("/ex02Array") // ex02Array?ids=3&ids=4&id=10 // 체크박스
	public void ex02Array(@RequestParam("ids") List<String> ids) {
		log.info("ids:" + ids);
	}
	
	@GetMapping("/ex03")
	public ModelAndView ex03() {
		ModelAndView mv = new ModelAndView("/hello","greet","hi");
//		mv.setViewName("/hello");
//		mv.addObject("great","hi");
		
		return mv;
	}
}
