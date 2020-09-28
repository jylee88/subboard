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
		<input type = "button" value = "저장" onclick = "replyInsert()">
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
		let htmls = "";
		let b_number = ${BoardDetail.b_number};
		
		
		$.ajax({
			type : "GET",
			url : "${contextPath}/Board/replyView",
			data : {b_number},
			success : function(reply){
				
				if(reply.length <= 0){
					htmls += '<div align = "center" id = "replyview">';
					htmls += '등록된 댓글이 없습니다';
					htmls += '</div>';
				}
				else{
					$(reply).each(function(){
						htmls += '<div align = "center" id = "replyview">';
						htmls += '내용'
						htmls += '<textarea readonly = "readonly">'+ this.r_content +'</textarea>';
						htmls += '<br>작성자';
						htmls += '<input type = "text" readonly = "readonly" value = "'+ this.r_id +'">';
						htmls += '<br><br><br></div>';
					});					
				}
				
				
				$("#replyview").replaceWith(htmls);
			},
			error : function(){
				alert("error");
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
			success : function(){
				alert("댓글 작성 성공");
				replyView();
			},
			error : function(){
				alert("댓글 작성 에러");
			}			
		});
	}
</script>

















