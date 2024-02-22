package util;

import java.sql.*;

public class DatabaseBean {
	public static Connection getConnection() {
		Connection mysql=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		String url = "jdbc:mysql://localhost:3306/sjms";

		try {
			mysql =  DriverManager.getConnection(url,"root","011115");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return mysql;
	}

	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null) {

				rs.close();

			}
			if (pstmt != null) {

				pstmt.close();

			}
			if (conn != null) {

				conn.close();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}