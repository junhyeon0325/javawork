package day3.emp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 람다식 {
	public static void main(String[] args) {
		// asList가 배열을 list로 만들어주는 거
		List<Employee> list = Arrays.asList(new Employee(100, "동길동", 2000), new Employee(101, "남길동", 4000),
				new Employee(102, "서길동", 3000));

		// 1번 방법, Comparator 구현객체를 넣어준거다.
//		list.sort(new MySort());
//		System.out.println(list);

		// 2번 방법, 익명클래스 잘안씀 람다식만 잘 봐줬으면 좋겠다
//		list.sort(new Comparator<Employee>() {
//
//			@Override
//			public int compare(Employee o1, Employee o2) {
//				// 급여가 작은거부터
////				return (int) (o1.getSalary() - o2.getSalary());
//				// 급여가 큰거부터
//				return (int) (o2.getSalary() - o1.getSalary());
//			}
//
//		});
//		System.out.println(list);

		// 3번 방법, 람다표현식, 자바스크립트에 화살표 함수랑 같다. 이게 가장 많이 사용될거다
		// 급여
//		list.sort((Employee o1, Employee o2) -> (int) (o1.getSalary() - o2.getSalary()));
//		list.sort((Employee o1, Employee o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
//		System.out.println(list);

		// 4번 방법 Comparator 스태틱 매서드
//		list.sort(Comparator.comparing((Employee e) -> e.getSalary()));
//		System.out.println(list);

		// 5번 방법, 스태틱 메서드를 쓰는데 메서드 참조(더블콜론 - 람다표현식 축약문법)
//		list.sort(Comparator.comparing(Employee::getSalary));
//		System.out.println(list);

//		list.forEach( e -> System.out.println(e));
		// 바로 위에거 축약형, 어짜피 e가 출력되는거니까
		list.forEach(System.out::println);

	}
}

// class를 여러개 만들 수 있지만 public은 한개여야함
// implements 하면 무조건 구현해야함 Mysort에 마우스 갖다대면 추가할 수 있음
class MySort implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// 작으면 음수 크면 양수 같으면 0 이 나올거임
//		return o1.getEmployeeId() - o2.getEmployeeId();
		// 위에꺼 반대로 하면 반대로 sort됨
		return o2.getEmployeeId() - o1.getEmployeeId();
	}

}
