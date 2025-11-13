package egovframework.tdo.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.tdo.service.TodoService;
import egovframework.tdo.service.TodoDefaultVO;
import egovframework.tdo.service.TodoVO;

/**
 * @Class Name : TodoController.java
 * @Description : Todo Controller class
 * @Modification Information
 *
 * @author 장준현
 * @since 2025-11-13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=TodoVO.class)
public class TodoController {

    @Resource(name = "todoService")
    private TodoService todoService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * TODO 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 TodoDefaultVO
	 * @return "/todo/TodoList"
	 * @exception Exception
	 */
    @RequestMapping(value="/todo/TodoList.do")
    public String selectTodoList(@ModelAttribute("searchVO") TodoDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> todoList = todoService.selectTodoList(searchVO);
        model.addAttribute("resultList", todoList);
        
        int totCnt = todoService.selectTodoListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/todo/TodoList";
    } 
    
    @RequestMapping("/todo/addTodoView.do")
    public String addTodoView(
            @ModelAttribute("searchVO") TodoDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("todoVO", new TodoVO());
        return "/todo/TodoRegister";
    }
    
    @RequestMapping("/todo/addTodo.do")
    public String addTodo(
            TodoVO todoVO,
            @ModelAttribute("searchVO") TodoDefaultVO searchVO, SessionStatus status)
            throws Exception {
        todoService.insertTodo(todoVO);
        status.setComplete();
        return "forward:/todo/TodoList.do";
    }
    
    @RequestMapping("/todo/updateTodoView.do")
    public String updateTodoView(
            @RequestParam("no") java.math.BigDecimal no ,
            @ModelAttribute("searchVO") TodoDefaultVO searchVO, Model model)
            throws Exception {
        TodoVO todoVO = new TodoVO();
        todoVO.setNo(no);
        // 변수명은 CoC 에 따라 todoVO
        model.addAttribute(selectTodo(todoVO, searchVO));
        return "/todo/TodoRegister";
    }

    @RequestMapping("/todo/selectTodo.do")
    public @ModelAttribute("todoVO")
    TodoVO selectTodo(
            TodoVO todoVO,
            @ModelAttribute("searchVO") TodoDefaultVO searchVO) throws Exception {
        return todoService.selectTodo(todoVO);
    }

    @RequestMapping("/todo/updateTodo.do")
    public String updateTodo(
            TodoVO todoVO,
            @ModelAttribute("searchVO") TodoDefaultVO searchVO, SessionStatus status)
            throws Exception {
        todoService.updateTodo(todoVO);
        status.setComplete();
        return "forward:/todo/TodoList.do";
    }
    
    @RequestMapping("/todo/deleteTodo.do")
    public String deleteTodo(
            TodoVO todoVO,
            @ModelAttribute("searchVO") TodoDefaultVO searchVO, SessionStatus status)
            throws Exception {
        todoService.deleteTodo(todoVO);
        status.setComplete();
        return "forward:/todo/TodoList.do";
    }

}
