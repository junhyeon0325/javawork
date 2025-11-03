package day4;
/*
 * main에서는 이렇게 간단하게 만들어야한다.
 * 이게 객체지향언어다.
 * 재사용성 확장성 이거 때문에 class를 조립품으로 만들어서 계속 쓰는거다.
 */
public class EmpSalaryTest {
	public static void main(String[] args) {
		EmpSalary empSalary = new EmpSalary("c:/Temp/emp.txt");
		empSalary.init(); // 초기화
		empSalary.cal(); // 급여계산
		empSalary.sort(); // 정렬
		empSalary.print(); // 출력
		System.out.println("급여합계 = " + empSalary.getSum());
	} // end main
} // end class
