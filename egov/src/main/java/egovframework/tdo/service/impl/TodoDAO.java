package egovframework.tdo.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.tdo.service.TodoDefaultVO;
import egovframework.tdo.service.TodoVO;

/**
 * @Class Name : TodoDAO.java
 * @Description : Todo DAO Class
 * @Modification Information
 *
 * @author 장준현
 * @since 2025-11-13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("todoDAO")
public class TodoDAO extends EgovComAbstractDAO {

	/**
	 * TODO을 등록한다.
	 * @param vo - 등록할 정보가 담긴 TodoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertTodo(TodoVO vo) throws Exception {
        insert("todoDAO.insertTodo", vo);
    }

    /**
	 * TODO을 수정한다.
	 * @param vo - 수정할 정보가 담긴 TodoVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateTodo(TodoVO vo) throws Exception {
        update("todoDAO.updateTodo", vo);
    }

    /**
	 * TODO을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 TodoVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteTodo(TodoVO vo) throws Exception {
        delete("todoDAO.deleteTodo", vo);
    }

    /**
	 * TODO을 조회한다.
	 * @param vo - 조회할 정보가 담긴 TodoVO
	 * @return 조회한 TODO
	 * @exception Exception
	 */
    public TodoVO selectTodo(TodoVO vo) throws Exception {
        return (TodoVO) selectOne("todoDAO.selectTodo", vo);
    }

    /**
	 * TODO 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 List<TodoDefaultVO>
	 * @return TODO 목록
	 * @exception Exception
	 */
    public List<TodoDefaultVO> selectTodoList(TodoDefaultVO searchVO) throws Exception {
        return selectList("todoDAO.selectTodoList", searchVO);
    }

    /**
	 * TODO 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return TODO 총 갯수
	 * @exception
	 */
    public int selectTodoListTotCnt(TodoDefaultVO searchVO) {
        return (Integer)selectOne("todoDAO.selectTodoListTotCnt", searchVO);
    }

}
