package icecream.model.product.icecake.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import icecream.model.product.icecake.Icecake;

public class IcecakeDAO {
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "ICECREAM";
	private final String PASSWORD = "ICECREAM";
	/**
	 * 아이스크림 케이크 등록 성공시 0이외 값 반환
	 * @param icecake
	 * @return int result
	 */
	public int registCake(Icecake icecake) {
		int result = 0;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "INSERT INTO SAL_PRODUCT_TBL VALUES(? + 10, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,icecake.getProductCode());
			pstmt.setString(2,icecake.getProductName());
			pstmt.setInt(3,icecake.getProductPrice());
			result = pstmt.executeUpdate();
			conn.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 입력받은 이름의 케이크 삭제 성공시 0이외 반환
	 * @param name
	 * @return int result
	 */
	public int deleteCake(String name) {
		int result = 0;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "DELETE FROM SAL_PRODUCT_TBL WHERE PRODUCT_NAME = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, name);
			result = pstmt.executeUpdate();
			conn.close();
			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 전체 케이크 목록 List에 담아서 반환
	 * @return List<Icecake>
	 */
	public List<Icecake> allSelect(){
		List<Icecake> iList = null;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM SAL_PRODUCT_TBL WHERE PRODUCT_CODE >= 10";
			ResultSet rset = stmt.executeQuery(sql);
			iList = new ArrayList<Icecake>();
			while(rset.next()) {
				Icecake icecake = new Icecake();
				icecake.setProductCode(rset.getInt("PRODUCT_CODE"));
				icecake.setProductName(rset.getString("PRODUCT_NAME"));
				icecake.setProductPrice(rset.getInt("PRODUCT_PRICE"));
				iList.add(icecake);
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
	
	/**
	 * 코드 입력받고 해당하는 코드 이름 가격 icecake에 담아 리턴
	 * @param code
	 * @return Icecake icecake
	 */
	public Icecake oneSelect(int code) {
		Icecake icecake = null;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "SELECT * FROM SAL_PRODUCT_TBL WHERE PRODUCT_CODE = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			ResultSet rset = pstmt.executeQuery();
			icecake = new Icecake();
			if(rset.next()) {
				icecake.setProductCode(rset.getInt("PRODUCT_CODE"));
				icecake.setProductName(rset.getString("PRODUCT_NAME"));
				icecake.setProductPrice(rset.getInt("PRODUCT_PRICE"));
			}
			pstmt.close();
			conn.close();
			rset.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return icecake;
	}
}
