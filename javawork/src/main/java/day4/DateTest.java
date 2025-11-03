package day4;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class DateTest {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now(); // 현재시간 출력

		// 생일 출력
		LocalDate birth = //LocalDate.of(1999, 03, 25); // of써도되고 
							LocalDate.parse("1999-03-25"); // parse써도되고
		
		Period period = Period.between(birth, date);
		System.out.println("내가 살아온 날은" + period.getYears());
		System.out.println( period.getMonths());
		System.out.println( period.getDays());
		
		// 시간
		LocalTime stime = LocalTime.of(9, 10);
		LocalTime etime = LocalTime.of(16, 30);
		Duration duration = Duration.between(stime, etime);
		System.out.println(duration.toHours());
		System.out.println(duration.toMinutes());
	}
}
