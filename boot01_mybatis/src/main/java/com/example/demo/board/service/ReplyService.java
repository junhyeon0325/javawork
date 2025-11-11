package com.example.demo.board.service;

import java.util.List;


public interface ReplyService {
	// 댓글조회
	List<ReplyVO> getList(Long bno);

	// 등록
	int insert(ReplyVO reply);

	// 삭제
	int delete(Long rno);
}
