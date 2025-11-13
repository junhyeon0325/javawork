package egovframework.tdo.service;

/**
 * @Class Name : TodoVO.java
 * @Description : Todo VO class
 * @Modification Information
 *
 * @author 장준현
 * @since 2025-11-13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class TodoVO extends TodoDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** NO */
    private java.math.BigDecimal no;
    
    /** TITLE */
    private java.lang.String title;
    
    /** COMPLETE */
    private java.lang.String complete;
    
    public java.math.BigDecimal getNo() {
        return this.no;
    }
    
    public void setNo(java.math.BigDecimal no) {
        this.no = no;
    }
    
    public java.lang.String getTitle() {
        return this.title;
    }
    
    public void setTitle(java.lang.String title) {
        this.title = title;
    }
    
    public java.lang.String getComplete() {
        return this.complete;
    }
    
    public void setComplete(java.lang.String complete) {
        this.complete = complete;
    }
    
}
