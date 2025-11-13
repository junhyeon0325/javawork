package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 이게 들어가야 페이지가 열림
public class MvcConfig implements WebMvcConfigurer{

	// 단순하게 뷰 페이지로 이동해야하면 요렇게 해도 된다?
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//.setViewName("posts")이게 template폴더 안에 posts를 추적한다
		registry.addViewController("/posts").setViewName("posts");
	}

}// end of class
