package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.Board;


@WebServlet("/BoardOne")
public class BoardOneController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. C
		int no = 0;

		if(request.getParameter("no") != null){
			no = Integer.parseInt(request.getParameter("no"));
		}
		// System.out.println(no);
		
	    Board board = new Board();
		BoardService boardService = new BoardService();
		board = boardService.getBoardOne(no);
	    
		request.setAttribute("board", board);
		
		// 3. V
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/mvcBoardOne.jsp");
		
		rd.forward(request, response);
		/*
		 *  view 메뉴구성
		 *  1) 글수정 (로그인멤버 == 글쓴이가 동일할때)
		 *  2) 글삭제 (로그인멤버 == 글쓴이가 동일할때)
		 */
		
		
	}

}
