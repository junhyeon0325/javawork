package com.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring/datasource-context.xml")
public class BoardMapperTest {

	@Autowired
	BoardMapper boardMapper;
	
	@Disabled
	@Test
	void 전체조회() { // junit test할때 given, when, then요렇게 3개 패턴으로 하는거다
		// given

		// when
		List<BoardVO> list = boardMapper.getList();

		// then
		assertEquals(list.get(0).getWriter(), "user01");
		
		System.out.println(list);
		
		for(BoardVO board : list ) {
			System.out.println(board.getBno() + ":" + board.getTitle());
			for(ReplyVO reply : board.getReply()) {
				System.out.println(reply.getReply());
			}
		}
	}
	
	
	@Test
	void 등록() {
		// given
		BoardVO board = new BoardVO();
		board.setTitle("스프링");
		board.setContent("등록테스트");
		board.setWriter("user03");
		// when
		int result = boardMapper.insert(board);
		long bno = board.getBno();
		System.out.println(bno);
		// then
		// 등록된 번호로 단건조회
		assertEquals(result, 1);
	}
	
	@Disabled
	@Test
	void 수정() {
		// given
		BoardVO board = new BoardVO();
		board.setTitle("스프링2");
		board.setContent("test");
		board.setBno(4L);
		// when
		int result = boardMapper.update(board);
		// then
		assertEquals(result, 1);
	}
	
	@Disabled
	@Test
	void 삭제() {
		
		// given
		Long bno = 4l; // long형태라서 숫자 뒤에 l을 붙이면 long형태로 바뀜 
		
		// when
		int result = boardMapper.delete(bno);
		
		// then
		assertEquals(result, 1);
		
	}
	
	@Disabled
	@Test
	void 검색() {
		BoardVO board = BoardVO.builder().title("test")
		.writer("user01")
		.build();
		List<BoardVO> list = boardMapper.getListByWriter(board);
	}
}
