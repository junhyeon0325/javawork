<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>board/info.jsp</title>
</head>

<body>
	<h3>게시글 상세보기</h3>
	<div>${ board.bno }</div>
	<div>작성자 : ${ board.writer }</div>
	<div>내용 : ${ board.content }</div>
	<hr>
	<!-- 댓글 -->
	<div id="replyForm">
		<input id="replyer" name="replyer">
		<input id="reply" name="reply">
		<button type="button" class="btnInsert">댓글작성</button>
	</div>

	<div id="replyList"></div>

	<script src="https://code.jquery.com/jquery-3.7.1.js"
		integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
		crossorigin="anonymous"></script>

	<script>
		var bno = ${board.bno}; // jsp EL
	</script>
	<script src="/resources/reply.js"></script>
</body>
</html>