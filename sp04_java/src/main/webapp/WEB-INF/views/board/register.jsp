<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>
<c:if test="${empty board.bno}">게시글등록</c:if>
<c:if test="${not empty board.bno }">게시글수정</c:if>
게시글 ${ empty board.bno ? "등록" : "수정" }
</h3>
	<form method="post" name="frm" action="${empty board.bno ? "/board/register" : "/board/update"}">
		<input type="hidden" name="bno" value="${board.bno}">
		<label for="title">제목</label>
		<input name="title" value="${ board.title }">
		<label for="writer">작성자</label>
		<input name="writer" value="${ board.writer }">
		<label for="content">내용</label>
		<textarea name="content">${ board.content }</textarea>
		<button>등록</button>
		<c:if test="${not empty board.bno }">
		  <button type="button" onclick="boardDelete()">삭제</button>
		</c:if>
	</form>
	<script>
		function boardDelete(){
			if(confirm('삭제할까요')){
				document.frm.action = "/board/delete";
				document.frm.submit();
			}
		}
	</script>
</body>
</html>