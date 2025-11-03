package day4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
	// throws해서 사용한곳에서 try catch를 해서 예외처리를 해야한다.
	public static int menuInput() throws InputMismatchException, MenuException {
		Scanner sc = new Scanner(System.in);
		System.out.print("가위(1), 바위(2), 보(3), 종료(0): ");
		int user;
		user = sc.nextInt();
//		try {
//			user = sc.nextInt();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			user = 0;
//		}
		if(user > 3) {
//			throw new Exception("입력범위오류"); // 업무규칙위배에러를 직접 만들 수 있음
			throw new MenuException("입력범위오류");
		}
		return user;
	}
	

	public static void main(String[] args) {
		int menu = 0;
		// throws해서 넘긴 에러를 try catch문을 이용해서 예외처리를 함
		try {
			menu = menuInput();
			
		// catch문은 여러개중에서 하나만 실행된다
		} catch (InputMismatchException e) { // inputMismatchExcption
//			e.printStackTrace(); // 메소드 호출과정이 다 보임
			System.out.println(e.getMessage()); // 직접만든 에러 출력
			menu = 0;
		} catch (MenuException e) { // 내가 만든 입력범위오류
//			e.printStackTrace();
			System.out.println(e.getMessage()); // 직접만든 에러 출력
			menu = 1;
		} catch (Exception e) { // else처럼 앞에 catch조건에 해당하지 않으면 맨 마지막 catch가 실행된다.
			//
		}
		System.out.println(menu);
		System.out.println("the end");
	}
}
