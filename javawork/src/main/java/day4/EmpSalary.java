package day4;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import day3.emp.Employee;

public class EmpSalary {
	String filename;
	List<Employee> list = new ArrayList<Employee>();
	private long sum;
	
	// 생성자
	// filename을 받아와야하니까 filename만 생성자를 만들고 main에서 매개변수값을 보내는거
	public EmpSalary(String filename) { 
		super();
		this.filename = filename;
	}

	// getter setter
	public long getSum() {
		return sum;
	}

	// 초기화
	public void init() {
		try {
			Scanner scanner = new Scanner(new File(filename));
			// 2. 라인만큼 반복문
			while (scanner.hasNext()) {
				// 3. 사번, 이름, 급여출력
				String emp = scanner.nextLine();
				String[] empArr = emp.split(","); // , 콤마 빼고 empArr배열에 넣는거
				int id = Integer.parseInt(empArr[0]);
				String name = empArr[1];
				long sal = Long.parseLong(empArr[7]);
				list.add(new Employee(id, name, sal));
			} // end while
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end init()

	// 급여계산
	public void cal() {
		// 명령형 프로그래밍( 절차지향, 객체지향 ) why
		for (Employee e : list) {
			sum += e.getSalary();
		}

		// 선언형 프로그래밍( 함수형 ) what
		// 이렇게하면 훨씬 빠르다. +멀티스레드
		sum = list.stream().mapToLong(Employee::getSalary).sum();
	}

	// 정렬
	public void sort() {
		Comparator<Employee> compare = (o1, o2) -> (int) (o2.getSalary() - o1.getSalary());
		list.sort(compare);
	}

	// 출력
	public void print() {
		for (Employee e : list) {
			System.out.println(e);
		}
	}

}// end class
