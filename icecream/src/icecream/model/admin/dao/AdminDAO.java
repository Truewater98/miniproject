package icecream.model.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import icecream.model.admin.Admin;

public class AdminDAO {
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "ICECREAM";
	private final String PASSWORD = "ICECREAM";
	
	/**
	 * admin 객체에서 id password로 db에 접근해 맞으면 0이 아닌값 리턴
	 * @param admin
	 * @return int result
	 */
	public int login(Admin admin) {
		int result = 0;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "SELECT COUNT(*) AS INFO FROM ADMIN_TBL WHERE ADMIN_ID = ? AND ADMIN_PASSWORD = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, admin.getId());
			pstmt.setString(2, admin.getPassword());
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("INFO");
			}
			conn.close();
			pstmt.close();
			rset.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
