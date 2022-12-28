package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logoutController
 */
@WebServlet("/member/logout")
public class logoutController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 *  로그인 세션 정보 삭제 : ex) session.invalidate();
		 *  redirect 0> get방식 home <- 컨트롤러 요청
		 * 
		 */
	}

}
