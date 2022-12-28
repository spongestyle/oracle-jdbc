package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBUtil;
import vo.Board;

public class BoardDao {
	// 검색 추가
	public ArrayList<Board> selectBoardListByPage(Connection conn, int beginRow, int endRow) throws Exception {
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "SELECT board_no boardNo, board_title boardTitle, createdate"
				+ " FROM (SELECT rownum rnum, board_no, board_title, createdate"
				+ "			FROM (SELECT board_no, board_title, createdate"
				+ "					FROM board ORDER BY board_no DESC))"
				+ " WHERE rnum BETWEEN ? AND ?"; // WHERE rnum >=? AND rnum <=?;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, beginRow);
		stmt.setInt(2, endRow);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Board b = new Board();
			b.setBoardNo(rs.getInt("boardNo"));
			b.setBoardTitle(rs.getString("boardTitle"));
			b.setCreatedate(rs.getString("createdate"));
			list.add(b);
		}
		return list;
	}
	
	//insertBoard.jsp
	public int insertBoard(Connection conn,  Board board) throws Exception {
		DBUtil db = new DBUtil();
		String sql = "insert into board "
				+ "		(board_no, board_title, board_content, member_id, updatedate, createdate)"
				+ "		values (board_seq.nextval, ? , ?, ?, sysdate, sysdate)";
		/*
		 	insert into board (
    			board_no, board_title, board_content, member_id, updatedate, createdate
			) values (
    			board_seq.nextval, ? , ?, ?, sysdate, sysdate
			)
		 */
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "boardTitle");
		stmt.setString(2, "boardContent");
		stmt.setString(3, "memberId");
		
		int row = stmt.executeUpdate();
		stmt.close();
		
		return row;
	}
	
	// boardOne.jsp
	public Board selectBoardOne (Connection conn, int no) throws SQLException {
		Board board = null;
		String sql = "SELECT board_no boardNo, board_title boardTitle, board_content boardCOntent, member_id memberId, updatedate, createdate"
				+  " FROM board where board_no = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, boardNo);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			board = new Board();
			board.setBoardNo("boardNO");
			board.setBoardTitle("boardTitle");
			board.setBoardTitle("boardTitle");
			board.set
		}
		stmt.close();
		rs.close();
		
		return board;
	}
}
