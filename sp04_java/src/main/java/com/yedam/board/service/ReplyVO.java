package com.yedam.board.service;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ReplyVO {
	private Long rno;
	private Long bno;
	private String reply;
//	@JsonProperty(value = "writer") // 이렇게 가능하다는걸 보여줌
	private String replyer;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date replydate;
	@JsonIgnore
	private Date updatedate;
}
