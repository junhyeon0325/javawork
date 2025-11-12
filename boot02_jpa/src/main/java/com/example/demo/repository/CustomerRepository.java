package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> { // <불러올타입?,여기가 기본타입>

	List<Customer> findByName(String name);

	List<Customer> findByNameLike(String name);

	// 특정단어가 포함된 이메일 조회 containing
	List<Customer> findByEmailContaining(String email);

	// 특정 OR
	List<Customer> findByNameOrEmailContaining(String name, String email);

	// Object[] 로 결과 받기
//	@Query(value = "select * from customer where phone = ?1 or name = ?2", nativeQuery = true) // nativeQuery를 true로 넣으면 알고있는 쿼리문 사용 가능
	@Query(value = "select * from customer where phone = :phone or name = :name", nativeQuery = true) // nativeQuery를 true로 넣으면 알고있는 쿼리문 사용 가능
	List<Object[]> findAllNative(@Param("phone") String phone,@Param("name") String name);
	
	@Query(value = "select * from customer where phone = :phone or name = :name", nativeQuery = true) // nativeQuery를 true로 넣으면 알고있는 쿼리문 사용 가능
	List<CustomerNative> findAllNativeVO(@Param("phone") String phone,@Param("name") String name);
	
	// JPQL
	@Query("select c from Customer c order by id DESC")
	List<Customer> findAllQuery();

}