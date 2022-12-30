package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import vo.Board;
import vo.Member;

@WebServlet("/board/modifyBoard")
public class ModifyBoardController extends HttpServlet {
	private BoardService boardService;
	
	// Form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 유효성 검사
		HttpSession session = request.getSession();
		
		// 로그인 여부확인, 로그인 되어있을 경우 회원페이지로 이동
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if(loginMember == null) { // 로그아웃상태
			String target = request.getContextPath()+"/home";
			response.sendRedirect(target);
			return;
		}
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		this.boardService = new BoardService();
		Board board = boardService.selectBoardOneService(boardNo);
		
		
		// 보드 작성자만 수정할 수 있게
		String boardMemberId = board.getMemberId();
		String loginMemberId = loginMember.getMemberId();
		
		
		System.out.println("boardMemberId: " + boardMemberId);
		System.out.println("loginMemberId: " + loginMemberId);
		
		if(boardMemberId.equals(loginMemberId)) {
			request.setAttribute("board", board);
			
			// view
			// 보드작성자와 수정자가 동일할때 -> modifyBoardForm
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/board/modifyBoardForm.jsp");
			rd.forward(request, response);
			
		} else { // 동일하지 않을때 -> boardOne
			String msg = URLEncoder.encode("작성자만 수정할 수 있습니다", "utf-8");
			response.sendRedirect(request.getContextPath()+"/board/boardOne?boardNo="+boardNo+"&msg="+msg);
			return;
		}
		
		request.setAttribute("board", board);
		request.setAttribute("nowPage", "board");
		request.getRequestDispatcher("/WEB-INF/view/board/modifyBoardForm.jsp").forward(request, response);
	}

	// Action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginMember");
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		String memberId = member.getMemberId();
		
		Board board = new Board();
		board.setBoardNo(boardNo);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setMemberId(memberId);
		
		this.boardService = new BoardService();
		
		if(boardService.updateBoardService(board) != 1) {
			System.out.println("수정 실패");
			response.sendRedirect(request.getContextPath()+"/board/modifyBoard");
			return;
		}
		
		System.out.println("수정 성공");
		
		
		
		
		
		response.sendRedirect(request.getContextPath()+"/board/boardOne?boardNo="+boardNo);
	}
		

}
