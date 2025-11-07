<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/info.jsp</title>
</head>
<body>
	<h3>게시글 상세보기</h3>
	<div>${ board.bno }</div>
	<div>작성자 : ${ board.writer }</div>
	<div>내용 : ${ board.content }</div>
	<div id="reply"></div>
	<script>
	let bno = ${board.bno};
	fetch(`http://localhost:81/board/\${bno}/reply`)
	  .then((response) => response.json())
	  .then((datas) => {
		  let reply = document.querySelector("#reply");
		  for(data of datas){
			  let newTag = `<div>\${data.reply} \${data.replyer}</div>`
			  reply.insertAdjacentHTML("beforeend",newTag);
		  }
	  });	
	</script>
</body>
</html>