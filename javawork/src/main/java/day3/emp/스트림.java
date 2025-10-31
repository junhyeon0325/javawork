package day3.emp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class 스트림 {
	public static void main(String[] args) {
		String[] strArr = { "키위", "포도", "바나나", "사과", "감", "사과" };
		Stream.of(strArr) //
				.sorted() //
				.limit(3) //
				.forEach(System.out::println);

		// 사과가 몇개 있나? filter count
		long cnt = Stream.of(strArr).filter(e -> e.equals("사과")).count();
		System.out.println(cnt);

		List<Employee> list = Arrays.asList(new Employee(100, "동길동", 4000), new Employee(101, "남길동", 3000),
				new Employee(102, "서길동", 2000));

		// 급여합계
		long sum = list.stream().mapToLong(i -> i.getSalary()).sum();
		System.out.println(sum);
		

	}
}
