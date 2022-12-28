package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","gdj58","java1234");
		conn.setAutoCommit(false);
		return conn;
	}
	// close 모듈화 (rs가 있든 없든 입력하게끔 만듬)
	public void close(ResultSet rs, PreparedStatement stmt, Connection conn) throws Exception {
		if (rs != null) { 
			rs.close();
		} 
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}	
}
