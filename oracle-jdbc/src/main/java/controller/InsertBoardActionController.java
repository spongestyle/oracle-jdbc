package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.Board;

/**
 * Servlet implementation class insertBoardController
 */
@WebServlet("/insertBoardController")
public class InsertBoardActionController extends HttpServlet {
	private BoardService boardService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		String boardTitle = null;
		String boardContent = null;
		String memberId = null;
		
		if(request.getParameter("boardTitle")==null || request.getParameter("boardTitle").equals("")) {
			response.sendRedirect(request.getContextPath()+"/WEB-INF/view/insertBoardForm.jsp");
		}else {
			boardTitle = request.getParameter("boardTitle");
		}
		if(request.getParameter("boardContent")==null || request.getParameter("boardContent").equals("")) {
			response.sendRedirect(request.getContextPath()+"/WEB-INF/view/insertBoardForm.jsp");
		}else {
			boardContent = request.getParameter("boardContent");
		}
		if(request.getParameter("memberId")==null || request.getParameter("memberId").equals("")) {
			response.sendRedirect(request.getContextPath()+"/WEB-INF/view/insertBoardForm.jsp");
		}else {
			memberId = request.getParameter("memberId");
		}
		System.out.println(boardTitle);
		System.out.println(boardContent);
		System.out.println(memberId);
		
		Board board = new Board();
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setMemberId(memberId);
		
		// 2 model
		
		BoardService boardService = new BoardService();
		int row = boardService.getInsertBoard(board);
		if(row ==1) {
			System.out.println("입력성공");
		} else {
			System.out.println("입력실패");
		}
		response.sendRedirect(request.getContextPath()+"/BoardListController");
		
	}

}
