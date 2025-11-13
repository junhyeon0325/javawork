package egovframework.tdo.service;

import java.util.List;
import egovframework.tdo.service.TodoDefaultVO;
import egovframework.tdo.service.TodoVO;

/**
 * @Class Name : TodoService.java
 * @Description : Todo Business class
 * @Modification Information
 *
 * @author 장준현
 * @since 2025-11-13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface TodoService {
	
	/**
	 * TODO을 등록한다.
	 * @param vo - 등록할 정보가 담긴 TodoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertTodo(TodoVO vo) throws Exception;
    
    /**
	 * TODO을 수정한다.
	 * @param vo - 수정할 정보가 담긴 TodoVO
	 * @return void형
	 * @exception Exception
	 */
    void updateTodo(TodoVO vo) throws Exception;
    
    /**
	 * TODO을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 TodoVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteTodo(TodoVO vo) throws Exception;
    
    /**
	 * TODO을 조회한다.
	 * @param vo - 조회할 정보가 담긴 TodoVO
	 * @return 조회한 TODO
	 * @exception Exception
	 */
    TodoVO selectTodo(TodoVO vo) throws Exception;
    
    /**
	 * TODO 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TODO 목록
	 * @exception Exception
	 */
    List selectTodoList(TodoDefaultVO searchVO) throws Exception;
    
    /**
	 * TODO 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TODO 총 갯수
	 * @exception
	 */
    int selectTodoListTotCnt(TodoDefaultVO searchVO);
    
}
