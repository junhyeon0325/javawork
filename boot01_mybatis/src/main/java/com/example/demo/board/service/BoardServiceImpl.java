package com.example.demo.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.board.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service // 서비스로 빈등록
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private final BoardMapper boardMapper;

	@Override
	public int insert(BoardVO board) {
		return boardMapper.insert(board);
	}

	@Override
	public int update(BoardVO board) {
		return boardMapper.update(board);
	}

	@Override
	public int delete(Map<String, Object> map) {
		return boardMapper.delete(map);
	}

	@Override
	public BoardVO getBoard(Long bno) {
		return boardMapper.getBoard(bno);
	}

	@Override
	public List<BoardVO> getList() {
		return boardMapper.getList();
	}

	@Override
	public List<BoardVO> getListByWriter(BoardVO board) {
		return boardMapper.getListByWriter(board);
	}

	@Override
	public int count() {
		return 0;
	}

}
