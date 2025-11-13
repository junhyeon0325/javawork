package egovframework.tdo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.tdo.service.TodoService;
import egovframework.tdo.service.TodoDefaultVO;
import egovframework.tdo.service.TodoVO;
import egovframework.tdo.service.impl.TodoDAO;
import egovframework.tdo.service.impl.TodoMapper;
/**
 * @Class Name : TodoServiceImpl.java
 * @Description : Todo Business Implement class
 * @Modification Information
 *
 * @author 장준현
 * @since 2025-11-13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("todoService")
public class TodoServiceImpl extends EgovAbstractServiceImpl implements
        TodoService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(TodoServiceImpl.class);

//    @Resource(name="todoMapper")
//    private TodoMapper todoDAO;
    
    @Resource(name="todoDAO")
    private TodoDAO todoDAO;
    
    /** ID Generation */
    //@Resource(name="{egovTodoIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * TODO을 등록한다.
	 * @param vo - 등록할 정보가 담긴 TodoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertTodo(TodoVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	todoDAO.insertTodo(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * TODO을 수정한다.
	 * @param vo - 수정할 정보가 담긴 TodoVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateTodo(TodoVO vo) throws Exception {
        todoDAO.updateTodo(vo);
    }

    /**
	 * TODO을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 TodoVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteTodo(TodoVO vo) throws Exception {
        todoDAO.deleteTodo(vo);
    }

    /**
	 * TODO을 조회한다.
	 * @param vo - 조회할 정보가 담긴 TodoVO
	 * @return 조회한 TODO
	 * @exception Exception
	 */
    public TodoVO selectTodo(TodoVO vo) throws Exception {
        TodoVO resultVO = todoDAO.selectTodo(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * TODO 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TODO 목록
	 * @exception Exception
	 */
    public List<?> selectTodoList(TodoDefaultVO searchVO) throws Exception {
        return todoDAO.selectTodoList(searchVO);
    }

    /**
	 * TODO 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TODO 총 갯수
	 * @exception
	 */
    public int selectTodoListTotCnt(TodoDefaultVO searchVO) {
		return todoDAO.selectTodoListTotCnt(searchVO);
	}
    
}
