<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav>
	<div>
		<a href="${pageContext.request.contextPath}/home">Board System</a>
		
    	<div >
	    	<c:if test="${nowPage eq 'home'}">
	    		<ul >
	       			<li >
	          			<a href="${pageContext.request.contextPath}/home">Home</a>
	       			</li>
	        		<li >
	          			<a href="${pageContext.request.contextPath}/member/addMember">회원가입</a>
	       		 	</li>
	       		 	<li>
	       		  		<a id="loginMenu" href="${pageContext.request.contextPath}/member/login">로그인</a>
	       		 	</li>
	      		</ul>
	    	</c:if>   
		    <c:if test="${nowPage eq 'addMember'}">
		   		<ul>
		      		<li>
		         		<a href="${pageContext.request.contextPath}/home">Home</a>
		      		</li>
			       	<li>
			         	<a id="addMemberMenu" href="${pageContext.request.contextPath}/member/addMember">회원가입</a>
			      	</li>
		      		 <li >
		      		  	<a id="loginMenu" href="${pageContext.request.contextPath}/member/login">로그인</a>
		      		 </li>
		   		</ul>
		   	</c:if> 
		    <c:if test="${nowPage eq 'login'}">
				<ul>
					<li >
						<a href="${pageContext.request.contextPath}/home">Home</a>
					</li>
					<li >
						<a  id="addMemberMenu" href="${pageContext.request.contextPath}/member/addMember">회원가입</a>
					</li>
					<li>
						<a  id="loginMenu" href="${pageContext.request.contextPath}/member/login">로그인</a>
					</li>
				</ul>
		    </c:if>
    	</div>
    </div>
</nav>