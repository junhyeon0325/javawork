package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.example.demo.repository.Customer;
import com.example.demo.repository.CustomerRepository;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class CustomerRepositoryTest {

	@Autowired
	CustomerRepository customerRepository;

	// customerRepository.
	// customerRepository. 하고 ctrl space하면 나온느데 이거 다 customerRepository에서
	// jparepository에서 다 상속받은거다
	
	@Test
	public void 고객_조회() {
		// given
		String name = "홍길동";
		String phone = "011";
		Customer customer = Customer.builder().name(name).phone(phone).build();
		customerRepository.save(customer);
		// when
		List<Customer> customerList = (List<Customer>) customerRepository.findAll();
		// then
		assertEquals(customerList.get(0).getName(), name);
		log.info("조회된	고객	이름:	{}", customerList.get(0).getName());

	}
}
