package com.yedam.emp.mapper;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
public class Employee {
	private int employeeId;
	private String firstName;
	private String email;
	private long salary;
	private Date hireDate;

}
