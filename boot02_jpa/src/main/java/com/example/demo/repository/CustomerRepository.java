package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> { // <불러올타입?,여기가 기본타입>
	
}
