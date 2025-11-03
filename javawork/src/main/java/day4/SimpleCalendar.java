package day4;

import java.util.Calendar;
import java.util.Scanner;

public class SimpleCalendar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 연도 입력
		System.out.print("연도를 입력하세요: ");		
		int year = sc.nextInt();
		
		// 월 입력
		System.out.print("월을 입력하세요: ");
		int month = sc.nextInt();

		// 1. Calendar 세팅
		Calendar cal = Calendar.getInstance(); // 기본 시간대와 로캘을 사용해서 달력을 가져온다.
		cal.set(year, month - 1, 1); // 월은 0부터 시작

		// 2. 해당 월의 1일 요일
		int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 일=1, 월=2,...토=7

		// 3. 해당 월의 마지막 날짜 구하는거 : getActualMaximum
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		// 4. 달력 출력
		System.out.println("일\t월\t화\t수\t목\t금\t토");

		// 5. 첫 주 공백 출력
		for (int i = 1; i < firstDayOfWeek; i++) {
			System.out.print("\t");
		}

		// 6. 날짜 출력
		for (int day = 1; day <= lastDay; day++) {
			System.out.print(day + "\t");
			if ((day + firstDayOfWeek - 1) % 7 == 0) { // 토요일마다 줄 바꿈
				System.out.println();
			}
		}
	}
}