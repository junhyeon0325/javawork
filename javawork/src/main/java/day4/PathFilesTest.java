package day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/*
 * File --> Paths, Files
 */

public class PathFilesTest {
	public static void main(String[] args) throws IOException {

		Path path = Paths.get("c:/temp");

		// 파일목록
		Files.walk(path)
//		.forEach(System.out::println);
				.forEach(s -> System.out.println(s));

		// 파일 읽기
		Path file = Paths.get("c:/temp","data.txt");
		List<String> lines = Files.readAllLines(file);
		for(String l : lines) {
			System.out.println(l);
		}
		
		// 파일정보 (크기, 생성(변경)시간)
		System.out.println(Files.size(file));
		System.out.println(Files.getLastModifiedTime(file));
		
		// 파일명 변경
		// 나중에 개인적으로 찾아보기
		
		// 파일 저장
		Path newFile = Paths.get("c:/Temp","path.txt");
		Files.write(newFile, Arrays.asList("Hello","Java"));

		// 파일 삭제
		// 앞에랑 같음 삭제는
	}
}
