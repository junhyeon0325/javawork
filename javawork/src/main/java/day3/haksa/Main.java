package day3.haksa;

import java.util.ArrayList;

// 패키지. import
public class Main {

	public static void main(String[] args) {

		// 부모타입의 참조변수가 자식객체를 참조할 수 있다.(자동형변환)
		Member student = new Student(1, "홍길동", 4);
		Member professor = new Professor(100, "나교수", 4000);

		ArrayList<Member> list = new ArrayList<Member>();
		list.add(student); // student는 재정의를 했고
		list.add(professor); // professor는 재정의를 안했기때문에
		// student는 재정의한게 출력이되고 professor는 부모 Member의 재정의가 나온다

		for (Member member : list) {
			// 다형성 : 참조하는 자식객체의 메서드를 호출 => 실행결과 다르게
			System.out.println(member.toString());
		}
		
		for (Member member : list) {
//			System.out.println(member.toString()); 요렇게 toString이 생략된거임
			System.out.println(member.name); // Member 필드만 보임
			if (member instanceof Student) {
				Student temp = (Student) member; // 강제형변환
				System.out.println(temp.getGrade());
			} else {
				Professor temp = (Professor) member; // 강제형변환
				System.out.println(temp.salary);
			}
//			System.out.println((member instanceof Student) ? ((Student)member).getGrade() : ((Professor)member).salary );
			// instanceof는 실제로 생성된 타입을 비교하는거다
		}

		// 기본적으로 Object를 상속받는다
//		Object object = null;

	}

}
