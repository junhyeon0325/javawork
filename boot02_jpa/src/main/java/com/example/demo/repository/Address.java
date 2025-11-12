package com.example.demo.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

//	@OneToOne
//	@JoinColumn(name = "customer_id")
//	Address customer;

	@Builder
	public Address(String zipcode, String address, String detail_address) {
		this.zipcode = zipcode;
		this.address = address;
		this.detail_address = detail_address;
	}

}
