package day4;

import java.io.File;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 * 폴더 = 파일 시스템 API (폴더생성, 삭제, 이름변경, 정보...)
 */
public class FileTest {
	
//	@Test
	@DisplayName("폴더목록조회")
	public void test1() {
		File file = new File("c:/Temp"); // file에는 c:/Temp에 있는 파일들을 넣는다.
		String[] files = file.list(); // 
		for ( String f : files) {
			System.out.println(f);
		}
	} // end test1()
	
//	@Test
	@DisplayName("파일삭제")
	public void test2() {
		File file = new File("c:/Temp", "copy3.txt");
		file.delete();
	} // end test2()
	
	@Test
	@DisplayName("파일삭제")
	// 나중에 이렇게 해서 파일 확장자에 따라서 다르게 처리 할 수 있다
	public void test3() {
		File file = new File("c:/Temp", "copy3.txt");

		// 파일크기 출력
		System.out.println("파일크기: " + file.length());
		System.out.println("파일이름: " + file.getName());
		
		// 확장자출력 -> txt
		// .의 위치 : indexOf
		int idx = file.getName().indexOf("."); // file의 이름을 getName()해서 이름을 불러오고 indexOf해서 .의 위치값을 int타입으로 나온 값을 idx에 넣음
		String ext = file.getName().substring(idx + 1); // 
		System.out.println(ext);
	} // end test3
}
