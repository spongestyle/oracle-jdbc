package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.Board;


@WebServlet("/board/addBoard")
public class AddBoardController extends HttpServlet {
	private BoardService boardService;
	
	// 글쓰기 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 로그인 유효성 검사

	request.getRequestDispatcher("/WEB-INF/view/board/addBoardForm.jsp").forward(request, response);
	}	
		
		
	
	
	// 글쓰기 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		String boardTitle = null;
		String boardContent = null;
		String memberId = null;
		
		if(request.getParameter("boardTitle")==null || request.getParameter("boardTitle").equals("")) {
			response.sendRedirect(request.getContextPath()+"/WEB-INF/view/board/addBoardForm.jsp");
		}else {
			boardTitle = request.getParameter("boardTitle");
		}
		if(request.getParameter("boardContent")==null || request.getParameter("boardContent").equals("")) {
			response.sendRedirect(request.getContextPath()+"/WEB-INF/view/board/addBoardForm.jsp");
		}else {
			boardContent = request.getParameter("boardContent");
		}
		if(request.getParameter("memberId")==null || request.getParameter("memberId").equals("")) {
			response.sendRedirect(request.getContextPath()+"/WEB-INF/view/board/addBoardForm.jsp");
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
			request.getRequestDispatcher("/BoardListController").forward(request, response);
		} else {
			System.out.println("입력실패");
			request.getRequestDispatcher("/AddBoardFormController").forward(request, response);
		}
		// response.sendRedirect(request.getContextPath()+"/BoardListController");
		
		
	}

}
