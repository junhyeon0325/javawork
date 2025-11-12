package com.example.demo;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.Lifecycle;

import com.example.demo.repository.PostsRepository;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class PostsRepositoryTest {
	
	@Autowired
	PostsRepository postsRepository;
	
	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}
}
