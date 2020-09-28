<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<%@include file="../Include/Header.jsp"%>
</head>
<body>
<style>
	.tr{
		border-bottom: 2px solid black;
	}
	.li{
   		 list-style: none;
   		 display: inline-block;
	}
	.page {
	    MARGIN-RIGHT: 5PX;
	    TEXT-DECORATION: NONE;
	}
</style>
<div align = "center">
	<h2>자유 게시판</h2>
	<table style = "border-bottom: 2px solid; border-top: 2px solid;text-align: center; width: 50%;">
		<tr class = "tr">
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>조회수</td>
		</tr>
		<c:forEach var = "BoardList" items = "${BoardList }">
		<tr>
			<td style="width : 15%;">${BoardList.b_number }</td>
			<td style="width : 45%;"><a href = "${contextPath}/Board/boardDetail?b_number=${BoardList.b_number}">${BoardList.b_title }</a></td>
			<td style="width : 15%;">${BoardList.b_id }</td>
			<td style="width : 15%;">${BoardList.b_cnt }</td>
		</tr>
		</c:forEach>		
	</table>
	<div>
		<ul>
			<c:if test ="${pagemaker.prev}">
				<li class = "li">
					<a href = "${contextPath}/Board/BoardList?page=${pagemaker.startPage - 1}&b_code=${b_code}&searchType=${pagemaker.criteria.searchType}&keyword=${pagemaker.criteria.keyword}" class="page">이전</a>
				</li>
			</c:if>
			
			<c:if test = "${pagemaker.pageNum > 1}">
				<c:forEach var = "index" begin = "${pagemaker.startPage}" end = "${pagemaker.endPage}">
					<li class = "li">
						<a href = "${contextPath}/Board/BoardList?page=${index}&b_code=${b_code}&searchType=${pagemaker.criteria.searchType}&keyword=${pagemaker.criteria.keyword}" class="page">${index}</a>
					</li>
				</c:forEach>
			</c:if>	
					
			<c:if test = "${pagemaker.next}">
				<li class = "li">
				<a href = "${contextPath}/Board/BoardList?page=${pagemaker.endPage + 1}&b_code=${b_code}&searchType=${pagemaker.criteria.searchType}&keyword=${pagemaker.criteria.keyword}" class="page">
				다음</a>
				</li>
			</c:if>
		</ul>
	</div>
	<input type = "button" value = "글쓰기" onclick = "location.href = '${contextPath}/Board/boardRegister?b_code=${b_code}'">
	<input type = "button" value = "메인" onclick = "location.href = '${contextPath}'">
	<div align = "center">
		<select id = "searchType">
			<option selected = "selected">--선택--</option>
			<option value = "searchTitle">제목</option>
			<option value = "searchContent">내용</option>
		</select>
		<input type = "text" id = "search">
		<input type = "button" value = "검색" id = "searchBtn" >
	</div>
</div>	
</body>

<script>
	$(document).ready(function(){
		
	});
	
	$(document).on('click',"#searchBtn",function(){
		
		var searchType = $("#searchType").val();
		var keyword = $("#search").val();
		
		var url = '${contextPath}/Board/BoardList?b_code=${b_code}'
				+'&searchType='+searchType
				+'&keyword='+keyword;
				
		self.location = url;		
		
	});

	
</script>



</html>














