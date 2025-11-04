package com.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.factory.TV;

public class 자바기반설정 {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		TV tv = (TV) context.getBean("tv");
		tv.powerOn(); // 다형성 - 참조하는 객체의 메서드(오버라이딩된)를 호출
		tv.volumeUp();
	}
}
