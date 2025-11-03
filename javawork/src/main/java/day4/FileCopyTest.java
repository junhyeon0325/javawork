package day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Ignore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FileCopyTest {

	@Ignore // 테스트할 때 실행되지않게 할려면 Ignore를 넣어주면 된다.
//	@Test // JUnit 테스트뭐 할 때 하는거라는데?
	@DisplayName("파일복사") // 이름을 지정해 줄 수 있다는데?
	public void copy() throws IOException {
		FileOutputStream fw = new FileOutputStream("c:/Temp/copy.txt"); // 출력 스트림
		FileInputStream inputStream = new FileInputStream("c:/Temp/data.txt"); // 입력 스트림

		int readByte;
		while ((readByte = inputStream.read()) != -1) { // Ctrl Z 누르면 입력을 종료한다
			fw.write(readByte);
		} // end while

		fw.close();

	} // end copy method

	@Ignore // 테스트할 때 실행되지않게 할려면 Ignore를 넣어주면 된다.
//	@Test // Test파일은 원래는 sre/test/java에 만들어야한다.
	@DisplayName("Reader 복사")
	public void copy2() throws IOException {
		FileWriter fw = new FileWriter("c:/Temp/copy3.txt"); // 만들어질 파일
		FileReader fr = new FileReader("c:/Temp/data.txt"); // 기존에 있는 파일

//		int readByte;
		int bytesRead = 0;
		// 한번에 5글자씩 읽어서 readByte에 넣는다는 의미
		char[] readByte = new char[5];

		//
		while ((bytesRead = fr.read(readByte)) != -1) { // Ctrl Z 누르면 입력을 종료한다
			fw.write(readByte, 0, bytesRead); // readByte배열의 0번 인덱스부터 bytesread개를 출력
		} // end while

		fw.close();

	} // end copy2 method
		// 오류? 가 있음 5바이트씩 읽고 마지막에 남은 쓰레기 문자가 남아있음
		// 바로 위에 오류 해결하기위해서 fw.write(readByte, 0, bytesRead); 요렇게 바꿈

	@Ignore
//	@Test // Ignore가 안되면 Test를 주석처리
	@DisplayName("버퍼를 통해서 라인입력")
	// 이렇게 하니까 지정된 파일을 찾을 수 없다고 오류 뜸
	public void 버퍼입력() throws IOException {
		BufferedReader fr = new BufferedReader(new FileReader("c:/Temp/emp.txt")); // 기존에 있는 파일

		String str = null;

		while ((str = fr.readLine()) != null) { // 한줄씩 읽을때는 readLine()을 사용하면 된다.
			System.out.println();
		} // end while

		fr.close(); // readLine하고나서 꼭 닫아주기

	} // end 버퍼입력() method

	@Test
	@DisplayName("스캐너를 통해서 라인입력")
	public void 스캐너입력() throws IOException {
		Scanner scanner = new Scanner(new File("c:/Temp/emp.txt"));
//		while(scanner.hasNext()){}
		String emp = scanner.nextLine();
		
		// 이걸 엑셀파일 출력? 할 때 사용한다고 하심 
		// Steven 이름 출력 split -> String[]
		String[] empArr = emp.split(","); // ,만 빼는데 빼고 나온 단어들을 String배열에 넣는다.
//		if(empArr != null) // 이걸 해줬으면 좋겠다라고 하시고 지금은 지우심
		System.out.println(empArr[1]); // Steven이름 출력
	}

} // end class
