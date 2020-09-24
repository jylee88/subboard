<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri= "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성</title>
<%@include file = "../Include/Header.jsp" %>
</head>
<body>	
	<h2 align = "center">글 작성</h2>
	<form method = "POST">
		<div align = "center">
			<label>제목</label>
			<input type = "text" name = "b_title" placeholder = "제목 입력">
		</div>
		<div align = "center">
			<label>내용</label>
			<textarea type = "text" name = "b_content">내용 입력</textarea>
		</div>
		<div align = "center">
			<input type="submit" value = "완료"> 
			<input type="button" value = "취소" onclick = "location.href='${contextPath}/Board/BoardList?b_code=${b_code}'"> 
		</div>
	</form>
</body>
</html>
