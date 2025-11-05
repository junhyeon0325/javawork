<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/board/register">
		<label for="title">제목</label>
		<input name="title">
		<label for="writer">작성자</label>
		<input name="writer">
		<label for="content">내용</label>
		<textarea name="content" rows="" cols=""></textarea>
		<button>등록</button>
	</form>
</body>
</html>