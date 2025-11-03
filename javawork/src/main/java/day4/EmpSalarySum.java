package day4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import day3.emp.Employee;

/* 
 * 사원 급여 합계 계산
 * 클래스
 * data(필드)
 * 		List
 * 		filename
 * 
 * 기능(메서드)
 * 		List 초기화
 * 		급여계산
 * 		정렬
 * 		출력
 */
public class EmpSalarySum {
	public static void main(String[] args) throws IOException {
//		int salary = 0;
		long sum = 0;

		// emp.txt
		// 1. scanner
		Scanner scanner = new Scanner(new File("c:/Temp/emp.txt"));
		// list
		List<Employee> list = new ArrayList<Employee>();

		// 2. 라인만큼 반복문
		while (scanner.hasNext()) {

			// 3-1. 사번, 이름, 급여를 읽어드리기
			String emp = scanner.nextLine();
			String[] empArr = emp.split(","); // , 콤마 빼고 empArr배열에 넣는거

//			// 3-2. 사번, 이름, 급여를 출력
//			System.out.println("사번 : " + empArr[0] + " | 이름 : " + empArr[1] + "\t | 급여 : " + empArr[7]);

			// 4-1. 급여합계 계산
//			salary += Integer.parseInt(empArr[7]); // 급여가 지금 string이라서 parseInt로 변환

			// 3. 사번, 이름, 급여출력
			int id = Integer.parseInt(empArr[0]);
			String name = empArr[1];
			long sal = Long.parseLong(empArr[7]);
			list.add(new Employee(id, name, sal));

			// 4. 급여합계 계산, 출력
			sum += sal;

		} // end while

		// 급여순으로 정렬해서 출력
		// o1에서 o2를 빼면 오름차순
		// o2에서 o1을 빼면 내림차순
		Comparator<Employee> compare = (o1, o2) -> (int) (o2.getSalary() - o1.getSalary()); 
		list.sort(compare);
		for (Employee e : list) {
			System.out.println(e);
		}
		// 스트림
		list.stream().sorted(compare).forEach(System.out::println);
		// forEach(e -> System.out.println(e) )

		// 4-2. 급여합계 출력
		System.out.println("급여 총 합계 : " + sum);
//		System.out.println("급여 총 합계 : " + salary);
	} // end main
} // end class
