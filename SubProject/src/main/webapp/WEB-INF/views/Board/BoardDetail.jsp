<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri= "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 글</title>
<%@include file = "../Include/Header.jsp" %>
</head>
<body>
	<div align = "center">
		<p>제목</p>
		<input type = "text" value = "${BoardDetail.b_title }" readonly = "readonly">
	
		<p>내용</p>
		<textarea name = "b_content" readonly = "readonly">${BoardDetail.b_content }</textarea>
		
		<p>작성자</p>
		<input type = "text" value = "${BoardDetail.b_id }" readonly = "readonly">
	</div>
	<div align = "center">
		<input type = "button" value = "목록" onclick = "location.href = '${contextPath}/Board/BoardList?b_code=${BoardDetail.b_code }'">
		<input type = "button" value = "삭제" 
			onclick = "location.href = '${contextPath}/Board/boardDelete?b_number=${BoardDetail.b_number}&b_code=${BoardDetail.b_code }'">
		<input type = "button" value = "수정" 
			onclick = "location.href = '${contextPath}/Board/boardUpdate?b_number=${BoardDetail.b_number }'" >
	</div>
	<br>
	<hr>
	<div align = "center">
		<textarea placeholder = "댓글을 입력하세요" id="recontent" ></textarea>
		<input type = "button" value = "저장" onclick = "reply()">
		<br><br><br>
	</div>
	<div align = "center" id = "replyview">
		
	</div>
</body>
</html>


<script>
	$(document).ready(function(){
		replyView();
	});
	
	//댓글 보기
	function replyView(){
		var htmls = "";
		var b_number = ${BoardDetail.b_number};
		
		$.ajax({
			type : "POST",
			url : "${contextPath}/Board/replyView",
			data : {b_number},
			dataType : 'json',
			success : function(reply){
				htmls += '<div align = "center" id = "replyview">';
				htmls += '<h2>댓글이 없습니다.</h2>'
				htmls += '</div>';
				
				alert(htmls);
				$("#replyview").replaceWith(htmls);
			},
			error : function(){
				
			}
		});
	}
	
	//댓글 작성
	function replyInsert(){
		var recontent = $("#recontent").val();
		var data = {
			r_content : recontent,
			r_id : "admin",
			b_number : "${BoardDetail.b_number }"
		};
		
		$.ajax({
			type : 'POST',
			url : '${contextPath}/Board/replyInsert',
			data : data,
			dataType : 'json',
			success : function(){
				
			},
			error : function(){
				
			}			
		});
	}
</script>

















