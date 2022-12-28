<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "service.*" %>
<%@ page import = "vo.*" %>
<%
	// 컨트롤러에서 공유한 모델 데이터 셋팅
	Board board = (Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardOne.jsp</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>no</th>
				<th>title</th>
				<th>content</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=board.getNo()%></td>
				<td><%=board.getTitle()%></td>
				<td><%=board.getContent()%></td>
			</tr>
		</tbody>
	</table>
	<div>
		<a href="<%=request.getContextPath()%>/mvc/ModifyBoardFormController?no=<%=board.getNo()%>">수정</a>
		<a href="<%=request.getContextPath()%>/mvc/RemoveBoardActionController?no=<%=board.getNo()%>">삭제</a>
	</div>
</body>
</html>
