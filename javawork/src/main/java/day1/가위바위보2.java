package day1;

import java.util.Random;
import java.util.Scanner;

public class 가위바위보2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		String user = "";	// 사용자값
		String username = "";	// 사용자이름
		int computer = 0;	// 컴퓨터난수값
		String computerChange = "";	// 컴퓨터 난수값 문자로 바꾸기
		int draw = 0;	// 무승부값
		int win = 0;	// 승리값
		int lose = 0;	// 패배값
		// 반목문
		while (true) {
			// 메뉴출력
			System.out.print("가위 바위 보 종료");

			// 사용자 값을 입력
			user = scanner.next();
			
			// 사용자이름 입력 출력
			System.out.print("사용자 이름을 입력해주세요 : ");
			username = scanner.next();
			
			// 종료
			if (user.equals("종료"))
				break; // while 문 빠져나가는거

			// 가위 바위 보 가 아니면 다시 입력
			if (!user.equals("가위") || !user.equals("바위") || !user.equals("보") || !user.equals("종료"))
				continue; // continue 다시 처음으로 가서 실행하는거
			
			// 컴퓨터의 선택 생성
			computer = random.next(3) + 1;

			// 사용자와 컴퓨터 선택 출력
			System.out.println("사용자 : " + user + ", 컴퓨터 : " + computer);

			// 승패 판정 로직
			if (user == computer) {
				System.out.println("무승부!");
				draw++;
			} else if ((user == 1 && computer == 3) || (user == 2 && computer == 1) || (user == 3 && computer == 2)) {
				System.out.println("사용자 승리!");
				win++;
			} else {
				System.out.println("컴퓨터 승리!");
				lose++;
			}
			
			// 현재 전적 출력
			System.out.println("현재 전적 : " + win + "승 " + draw + "무 " + lose + "패");
			
		}
		System.out.println("최종 결과 : " + win + "승 " + draw + "무 " + lose + "패");
	}

}
