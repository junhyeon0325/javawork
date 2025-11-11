package com.yedam.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.yedam.board.service.ReplyService;
import com.yedam.board.service.ReplyVO;
import com.yedam.config.DataSourceConfig;
import com.yedam.config.MybatisConfig;
import com.yedam.config.RootConfig;

@SpringJUnitConfig(classes = { DataSourceConfig.class, MybatisConfig.class, RootConfig.class })
public class ReplyServiceTest {

	@Autowired
	ReplyService replyService;

	@Disabled
	@Test
	public void 댓글등록() {
		// given
		ReplyVO reply = new ReplyVO();
		reply.setBno(9l);
		reply.setReply("댓글등록테스트");
		reply.setReplyer("홍길돌");
		// when
		int result = replyService.insert(reply);
		// then
		assertEquals(result, 1);
	}
	
	@Disabled
	@Test
	public void 댓글삭제() {
		// given
		Long rno = 1l;
		// when
		int result = replyService.delete(rno);
		// then
		assertEquals(result, 1);
	}
	
	@Test
	public void 댓글조회() {
		Long bno = 9l;
		List<ReplyVO> list = replyService.getList(bno);
		System.out.println(list);
	}
}
