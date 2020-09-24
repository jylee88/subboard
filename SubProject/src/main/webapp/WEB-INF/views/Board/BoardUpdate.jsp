<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri= "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<%@include file = "../Include/Header.jsp" %>
</head>
<body>
	<form method = "POST">
		<div align = "center">
		<h2>글 수정하기</h2>
			<p>제목</p>
			<input type = "text" name = "b_title" placeholder = "${BoardUpdate.b_title }">
		
			<p>내용</p>
			<textarea name = "b_content" placeholder = "${BoardUpdate.b_content}"></textarea>
			
			<p>작성자</p>
			<input type = "text" value = "${BoardUpdate.b_id }" readonly = "readonly">
		</div>
		<div align = "center">
			<input type = "submit" value = "완료">
			<input type = "button" value = "취소" onclick = "location.href = '${contextPath}/Board/boardDetail?b_number=${BoardUpdate.b_number }'"> 
		</div>
	</form>
</body>
</html>