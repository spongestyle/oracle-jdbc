<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>Home</title>
</head>
<body >

	<c:if test="${loginMember == null}">
		<jsp:include page="/inc/menu.jsp"></jsp:include>
	</c:if>
		
	<c:if test="${loginMember != null}">
		<jsp:include page="/inc/menuForMember.jsp"></jsp:include>	
	</c:if>
	
	<br><br>
	<div >
		<div >
	  		<div>
	  			<h1>오라클을 이용한 게시판 구축</h1>
	  		</div>
	  		<div >
	  			<a >로그인하기</a>
	  		</div>
	  		<div >
	  			<a >회원가입하기</a>
	  		</div>
		</div>
	</div>
</body>
</html>