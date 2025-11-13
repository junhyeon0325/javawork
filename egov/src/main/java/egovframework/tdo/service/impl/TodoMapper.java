package egovframework.tdo.service.impl;

import java.util.List;

import egovframework.tdo.service.TodoVO;
import egovframework.tdo.service.TodoDefaultVO;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : TodoMapper.java
 * @Description : Todo Mapper Class
 * @Modification Information
 *
 * @author 장준현
 * @since 2025-11-13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("todoMapper")
public interface TodoMapper {

	/**
	 * TODO을 등록한다.
	 * @param vo - 등록할 정보가 담긴 TodoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertTodo(TodoVO vo) throws Exception;

    /**
	 * TODO을 수정한다.
	 * @param vo - 수정할 정보가 담긴 TodoVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateTodo(TodoVO vo) throws Exception;

    /**
	 * TODO을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 TodoVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteTodo(TodoVO vo) throws Exception;

    /**
	 * TODO을 조회한다.
	 * @param vo - 조회할 정보가 담긴 TodoVO
	 * @return 조회한 TODO
	 * @exception Exception
	 */
    public TodoVO selectTodo(TodoVO vo) throws Exception;

    /**
	 * TODO 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return TODO 목록
	 * @exception Exception
	 */
    public List<?> selectTodoList(TodoDefaultVO searchVO) throws Exception;

    /**
	 * TODO 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return TODO 총 갯수
	 * @exception
	 */
    public int selectTodoListTotCnt(TodoDefaultVO searchVO);

}
