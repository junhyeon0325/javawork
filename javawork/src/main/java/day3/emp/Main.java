package day3.emp;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// asList가 배열을 list로 만들어주는 거
		List<Employee> list = Arrays.asList(new Employee(100, "동길동", 4000), new Employee(101, "남길동", 3000),
				new Employee(102, "서길동", 2000));

		EmployeeList empList = new EmployeeList(list);

		// 전체출력
//		empList.selectAll();
		// 조건조회
//		System.out.println(empList.findById(101));
//		System.out.println(empList.findByName("동길동"));
//		System.out.println(empList.findOrderByName());
		System.out.println(empList.findOrderBySalary());

	}
}
