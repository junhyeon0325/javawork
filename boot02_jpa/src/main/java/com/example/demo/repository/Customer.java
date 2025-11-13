package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.common.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/* ORM */
// 지금 하고 있는게 orm 매핑해서 테이블을 알아서 만들어 준다
// 그래서 이걸할려면 Entity annotation을 만들어줘야한다.
// @Id 를 넣어서 기본키, primary키를 설정
// setter는 안넣음 setter는 업데이트? 뭐 하는거라 안만든다?

//@DynamicUpdate
@NoArgsConstructor
@Getter 
@Entity
public class Customer extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(length = 20, nullable = false)
	String name;
	String phone;
	
	String email;
	
	
	
	// 하나의 사람이 여러개의 주소를 가짐
	// JoinColumn은 한군데에서만
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER) // eager = 즉시조회?
	List<Address> address = new ArrayList<Address>();
	
	// 이렇게 하면 3개만 추가 할 수 있다.
	// 이친구가 들어가면 기본생성자가 필요하다 noargsconstructor
	@Builder
	public Customer(String name, String phone, String email, Address address) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address.add(address); // 배열이니까 = 이 아니라 .add로
	}
	
	public void updateNameAndEmail(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	
}
