package com.example.demo.board.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.service.ReplyService;
import com.example.demo.board.service.ReplyVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final 필드값 초기화
@RestController // json형태로 바껴서 넘어간다
public class ReplyController {

	private final ReplyService replyService;

	// 등록
	@PostMapping("/reply") // localhost/reply
	public Map<String, Object> insert(@RequestBody ReplyVO vo) {
		int cnt = replyService.insert(vo);
		Map<String, Object> map = new HashMap<String, Object>(); // { "result": "success","data": 1 }
		map.put("result", "success");
		map.put("data", vo);
		return map; // {result : "success", data : ""} << map
	}

	// 삭제
	@DeleteMapping("/reply/{rno}") // loalhost/reply/10
	public int delete(@PathVariable("rno") Long rno) {
		return replyService.delete(rno);
	}

	// 전체조회
	@GetMapping("/board/{bno}/reply") // localhost/board/10/reply
	public List<ReplyVO> select(@PathVariable("bno") Long bno) {
		return replyService.getList(bno);
	}

}
