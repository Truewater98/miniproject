package icecream.model.product.icecream.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import icecream.model.product.icecream.Icecream;

public class IcecreamDAO {
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "ICECREAM";
	private final String PASSWORD = "ICECREAM";
	
	/**
	 * 입력받은 flavor를 db에 등록 코드는 마지막번호 자동 성공시 0이 아닌값 리턴
	 * @param flavor
	 * @return int result
	 */
	public int regist(String flavor) {
		int result = 0;
		int code = 0;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT COUNT(*) AS CODE FROM ICECREAM_TBL";
			ResultSet rset = stmt.executeQuery(sql);
			if(rset.next()) {
				code = rset.getInt("CODE");
			}
			sql =  "INSERT INTO ICECREAM_TBL VALUES(?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code + 1);
			pstmt.setString(2, flavor);
			result = pstmt.executeUpdate();
			conn.close();
			pstmt.close();
			stmt.close();
			rset.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 입력받은 flavor를 db에서 삭제 성공시 0아닌 값 리턴
	 * @param flavor
	 * @return
	 */
	public int delete(String flavor) {
		int result = 0;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "SELECT * FROM ICECREAM_TBL WHERE ICECREAM_NAME = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,flavor);
			ResultSet rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("ICECREAM_CODE");
			}
			sql = "DELETE FROM ICECREAM_TBL WHERE ICECREAM_NAME = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,flavor);
			result = pstmt.executeUpdate();
			Statement stmt = conn.createStatement();
			sql = "UPDATE ICECREAM_TBL SET ICECREAM_CODE = ICECREAM_CODE - 1 WHERE ICECREAM_CODE > " + result;
			stmt.executeUpdate(sql);
			conn.close();
			pstmt.close();
			stmt.close();
			rset.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Icecream> showAll(){
		List<Icecream> iList = null;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM ICECREAM_TBL";
			ResultSet rset = stmt.executeQuery(sql);
			iList = new ArrayList<Icecream>();
			while(rset.next()) {
				Icecream icecream = new Icecream();
				icecream.setIcecreamCode(rset.getInt("ICECREAM_CODE"));
				icecream.setIcecreamName(rset.getString("ICECREAM_NAME"));
				iList.add(icecream);
			}
			conn.close();
			stmt.close();
			rset.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return iList;
	}
}
