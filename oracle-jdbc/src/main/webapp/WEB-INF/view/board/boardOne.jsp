<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
	<%
		if(request.getParameter("msg") != null)
		{			
	%>	
			alert("<%=request.getParameter("msg")%>");
	<%	
		}
	%>
</script>
<title>게시글</title>
</head>
<body>
	<jsp:include page="/inc/menuForMember.jsp"></jsp:include>	
	
	<br><br>
	<div class="container">
		<div style="text-align : center;">
			<h1>게시글</h1>
		</div>
	
		<table class="table" >
			<tr>
				<th >NO</th>
				<td >${board.boardNo}</td>
			</tr>
			
			<tr>
				<th >TITLE</th>
				<td >${board.boardTitle}</td>
			</tr>
			
			<tr>
				<th>CONTENT</th>
				<td >${board.boardContent}</td>
			</tr>
			
			<tr>
				<th >ID</th>
				<td>${board.memberId}</td>
			</tr>
			
			<tr>
				<th>UPDATEDATE</th>
				<td>${board.updatedate}</td>
			</tr>
			
			<tr>
				<th >CREATEDATE</th>
				<td>${board.createdate}</td>
			</tr>
		</table>
		
		<div>
			<a type="button"href="${pageContext.request.contextPath}/board/modifyBoard?boardNo=${board.boardNo}">수정</a>
			&nbsp;
			<a type="button"href="${pageContext.request.contextPath}/board/removeBoard?boardNo=${board.boardNo}">삭제</a>			
		</div>
	</div>
</body>
</html>