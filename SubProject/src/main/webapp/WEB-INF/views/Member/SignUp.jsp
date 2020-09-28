<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri= "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.signUp{
		border : 1px solid;
		margin : 5px;
	}
</style>
</head>
<body>
	<form method="POST">
	<div align = "center">
		<h1>사인업 도미닉</h1>
		<table class="signUp">
			<tr>
				<td>아이디 : </td>
				<td><input type="text" name = "mb_id"></td>
			</tr>
			<tr>
				<td>비  번 : </td>
				<td><input type="text" name = "mb_pw"></td>
			</tr>
			<tr>
				<td>이  름 : </td>
				<td><input type="text" name = "mb_name"></td>
			</tr>
		</table>
		<input type="submit" value="제출">
	</div>
	</form>
</body>
</html>
