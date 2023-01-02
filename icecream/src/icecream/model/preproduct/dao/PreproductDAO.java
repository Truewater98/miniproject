package icecream.model.preproduct.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import icecream.model.preproduct.Preproduct;

public class PreproductDAO {
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "ICECREAM";
	private final String PASSWORD = "ICECREAM";
	
	/**
	 * 객체 받아 db에 등록 성공시 0이외 값 리턴
	 * @param preproduct
	 * @return int result
	 */
	public int registPre(Preproduct preproduct) {
		int result = 0;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "INSERT INTO PRE_PRODUCT_TBL VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, preproduct.getProuductCode());
			pstmt.setString(2,preproduct.getProductName());
			pstmt.setInt(3, preproduct.getAmount());
			pstmt.setString(4, preproduct.getEventYn());
			if(preproduct.getEventYn().equals("Y")) {
				pstmt.setInt(5, preproduct.getEventCode());
			}
			else {
				pstmt.setString(5, null);
			}
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
	 * 받은 이름에 해당하는 상품 삭제 성공시 0리턴
	 * @param name
	 * @return
	 */
	public int deletePre(String name) {
		int result = 0;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "DELETE FROM PRE_PRODUCT_TBL WHERE PRODUCT_NAME = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
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
	 * 모든 상품을 List에 담아 반환
	 * @return List<Preproduct>
	 */
	public List<Preproduct> showAllPre() {
		List<Preproduct> pList = null;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT PRODUCT_CODE, PRODUCT_NAME, AMOUNT, EVENT_NAME FROM PRE_PRODUCT_TBL LEFT JOIN EVENT_TBL USING (EVENT_CODE)"; 
			ResultSet rset = stmt.executeQuery(sql);
			pList = new ArrayList<Preproduct>();
			while(rset.next()) {
				Preproduct preproduct = new Preproduct();
				preproduct.setProuductCode(rset.getInt("PRODUCT_CODE"));
				preproduct.setProductName(rset.getString("PRODUCT_NAME"));
				preproduct.setAmount(rset.getInt("AMOUNT"));
				preproduct.setEventYn(rset.getString("EVENT_NAME"));
				pList.add(preproduct);
			}
			conn.close();
			stmt.close();
			rset.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pList;
	}
	
	public int updateAmount(Preproduct preproduct) {
		int result = 0;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "UPDATE PRE_PRODUCT_TBL SET AMOUNT = AMOUNT + ? WHERE PRODUCT_CODE = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, preproduct.getAmount());
			pstmt.setInt(2, preproduct.getProuductCode());
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
	
	public int minusAmount(int index, Preproduct[] prepros) {
		int result = 0;
		if(index > 0) {
			try {
				Class.forName(DRIVER);
				Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				String sql = "UPDATE PRE_PRODUCT_TBL SET AMOUNT = AMOUNT - ? WHERE PRODUCT_CODE = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				for(int i = 0; i < index; i++) {
					pstmt.setInt(1, prepros[i].getAmount());
					pstmt.setInt(2, prepros[i].getProuductCode());		
					result = pstmt.executeUpdate();
					if(result == 0) {
						break;
					}
				}
				conn.close();
				pstmt.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return result;
	}
}
