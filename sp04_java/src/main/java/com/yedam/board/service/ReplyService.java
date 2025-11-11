package com.yedam.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.board.service.ReplyVO;


public interface ReplyService {
	// 댓글조회
	List<ReplyVO> getList(Long bno);

	// 등록
	int insert(ReplyVO reply);

	// 삭제
	int delete(Long rno);
}
