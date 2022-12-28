package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Member;


@WebServlet("/member/login")
public class LoginController extends HttpServlet {
	
	// 로그인 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 *  view ->/WEB-INF/view/member/login.jsp 
		 */
		// 로그인 전에만 접근가능
		HttpSession session = request.getSession();

		// 로그인 여부확인, 로그인 되어있을 경우 회원페이지로 이동
		Member loginMember = (Member)session.getAttribute("loginMember");

		if(loginMember != null) {
			String target = request.getContextPath()+"/HomeController";
			response.sendRedirect(target);
			return;
		}
		// 회원가입 폼 View
		request.getRequestDispatcher("/WEB-INF/view/loginForm.jsp").forward(request, response);
	}
	
	// 로그인 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 	로그인 세션 정보 : session.setAttribute("loginMember", Member타입)
		 *  redirect -> get방식 home <- 컨트롤러 요청
		 */
		
	}

}
