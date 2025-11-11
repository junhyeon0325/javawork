package com.yedam.exam;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// @spring안해도된데
public class JacksonTest {

	@Test // 요거는 main에서는 작동안함 test패키지안에서만
	public void toObject() throws JsonMappingException, JsonProcessingException {
		// {"name":"hong","age":10}
		String json = "{\"name\":\"hong\",\"age\":10}";
		ObjectMapper objectMapper = new ObjectMapper();
		Sample sample = objectMapper.readValue(json, Sample.class); // JSON.parse()
		System.out.println("name=" + sample.getName());

	}
	
	@Test
	public void toJson() throws JsonProcessingException {
		Sample sample = new Sample();
		sample.setName("장준현");
		sample.setAge(20);
		ObjectMapper objectMapper = new ObjectMapper();
		String str = objectMapper.writeValueAsString(sample);
		System.out.println(str);
	}
}
