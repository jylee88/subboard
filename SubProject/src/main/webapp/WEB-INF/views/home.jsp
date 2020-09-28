<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<html>
<head>
	<title>Home</title>
</head>
<body>
	<div>
		<input type = "text" name = "mb_id" id = "mb_id" placeholder = "아이디">
	</div>	
	<div>
		<input type = "text" name = "mb_pw" id = "mb_pw" placeholder = "비밀번호">
	</div>	
	
	<div>
		<input type = "button" value = "로그인">
		<input type = "button" onclick = "location.href = '${contextPath}/Member/SignUp'" value = "회원가입">
	</div>
	<div>
		<a href = "${contextPath }/Board/BoardList?b_code=Free">자유 게시판</a>
		
	</div>
</body>
</html>
