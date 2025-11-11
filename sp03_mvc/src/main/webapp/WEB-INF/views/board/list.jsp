<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>게시글 목록</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f8f9fa;
    }
    .board-card {
      margin-bottom: 1.5rem;
      border-radius: 10px;
      box-shadow: 0 2px 6px rgba(0,0,0,0.08);
    }
    .board-card .card-header {
      background-color: #0d6efd;
      color: white;
      font-weight: 600;
    }
    .reply-card {
      background-color: #f1f3f5;
      border-left: 4px solid #0d6efd;
      margin-top: 0.75rem;
      border-radius: 6px;
      padding: 0.5rem 1rem;
    }
    .reply-card small {
      color: #6c757d;
    }
  </style>
</head>
<body>
  ${header["user-agent"] }
  <hr>
  쿠키 : ${cookie.JSESSIONID.value }
  <hr>
  <div class="container-lg py-5">
    <my:header></my:header>
    <my:search></my:search>
    <h2 class="mb-4 fw-bold text-center text-primary">📋 게시글 목록</h2>
	<div>총게시글수 ${fn:length(list)}	</div>
    <c:forEach items="${list}" var="board" varStatus="status">
      <c:if test="${status.first}">목록시작</c:if>
      <div>${status.count }</div>
      <hr>
      <div class="card board-card">
        <div class="card-header d-flex justify-content-between align-items-center">
          <span>📌 <a href="/board/update?bno=${board.bno}">${board.title}</a></span>
          <span class="badge bg-light text-dark">No.${board.bno}</span>
        </div>
        <div class="card-body">
          <p class="mb-2 text-muted">
            ✍ 작성자: <strong>${board.writer}</strong>
          </p>
          <p class="card-text">${board.content}</p>
        </div>

        <c:if test="${not empty board.reply}">
          <div class="card-footer">
            <h6 class="fw-semibold text-secondary mb-2">💬 댓글 목록</h6>
            <c:forEach items="${board.reply}" var="reply">
              <div class="reply-card">
                <p class="mb-1">${reply.reply}</p>
                <small>작성자: ${reply.replyer}</small>
              </div>
            </c:forEach>
          </div>
        </c:if>
      </div>
    </c:forEach>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
