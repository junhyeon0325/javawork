package com.example.demo.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	String zipcode;
	String address;
	String detail_address;

	// many의 의미가 customer아이디가 100번 101번 하나씩만 나오는데 여기는 address번호는 1번 2번 3번 증가하지만 cutomer아이디는 100번이 여러번 중복될 수 있다.
	@ManyToOne
	@JoinColumn(name = "customer_id")
	Customer customer;

	@Builder
	public Address(String zipcode, String address, String detail_address, Customer customer) {
		this.zipcode = zipcode;
		this.address = address;
		this.detail_address = detail_address;
		this.customer = customer;
	}

}
