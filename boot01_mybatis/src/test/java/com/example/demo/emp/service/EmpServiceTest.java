package com.example.demo.emp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmpServiceTest {
	
	@Autowired
	EmpService empService;
	
	@Test
	public void 단건조회() {
		// given
		EmpVO vo = new EmpVO();
		vo.setEmployeeId("100");
		// when
		EmpVO result = empService.getEmp(vo);
		// then
		assertEquals(result.getEmployeeId(), vo.getEmployeeId());
	}
}
