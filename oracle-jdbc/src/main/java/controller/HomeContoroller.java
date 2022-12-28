package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeContoroller
 */
@WebServlet("/home")
public class HomeContoroller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 
		 * forword - > /WEB-INF / view /home.jsp
		 * menu 구성 (로그인 전/후따라 분기)
		 * 
		 * 로그인 전
		 * 1) 회원가입
		 * 2) 로그인
		 * 
		 * 로그인 후
		 * 1)로그아웃
		 * 2)회원정보
		 * 3)게시판리스트
		*/
		
		
		
		
	}
}
