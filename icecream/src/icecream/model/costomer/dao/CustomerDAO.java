package icecream.model.costomer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import icecream.model.costomer.Customer;


public class CustomerDAO {
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "ICECREAM";
	private final String PASSWORD = "ICECREAM";
	
	/**
	 * 고객정보 전부 리스트에 담음
	 * @return List<Customer>
	 */
	public List<Customer> selectAll () {
		List<Customer> cList = null;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT MEMBER_CODE, MEMBER_NAME, MEMBERSHIP_NAME, POINT, ENTER_DATE, FINAL_DATE "
					+ "FROM CUSTOMER_TBL JOIN MEMBERSHIP_TBL ON MEMBER_LEVEL = MEMBERSHIP_LEVEL";
			ResultSet rset = stmt.executeQuery(sql);
			cList = new ArrayList<Customer>();
			while(rset.next()) {
				Customer customer = new Customer();
				customer.setMemberCode(rset.getInt("MEMBER_CODE"));
				customer.setMemberName(rset.getString("MEMBER_NAME"));
				customer.setMembershipName(rset.getString("MEMBERSHIP_NAME"));
				customer.setPoint(rset.getInt("POINT"));
				customer.setEnter_date(rset.getDate("ENTER_DATE"));
				customer.setFinal_date(rset.getDate("FINAL_DATE"));
				cList.add(customer);
			}
			conn.close();
			stmt.close();
			rset.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return cList;
	}

	/**
	 * 들어온 info에 해당하는 이름을 가진 고객들 List로 반환
	 * @param info
	 * @return List<Customer>
	 */
	public List<Customer> selectSearch(String info){
		List<Customer> cList = null;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "SELECT MEMBER_CODE, MEMBER_NAME, MEMBERSHIP_NAME, POINT, ENTER_DATE, FINAL_DATE "
					+ "FROM CUSTOMER_TBL JOIN MEMBERSHIP_TBL ON MEMBER_LEVEL = MEMBERSHIP_LEVEL "
					+ "WHERE MEMBER_NAME = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info);
			ResultSet rset = pstmt.executeQuery();
			cList = new ArrayList<Customer>();
			while(rset.next()) {
				Customer customer = new Customer();
				customer.setMemberCode(rset.getInt("MEMBER_CODE"));
				customer.setMemberName(rset.getString("MEMBER_NAME"));
				customer.setMembershipName(rset.getString("MEMBERSHIP_NAME"));
				customer.setPoint(rset.getInt("POINT"));
				customer.setEnter_date(rset.getDate("ENTER_DATE"));
				customer.setFinal_date(rset.getDate("FINAL_DATE"));
				cList.add(customer);
			}
			conn.close();
			pstmt.close();
			rset.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cList;
	}
	
	/**
	 * 들어온 고객코드와 일치하는 고객반환
	 * @param info
	 * @return Customer
	 */
	public Customer selectOne(int info) {
		Customer customer = null;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "SELECT MEMBER_CODE, MEMBER_NAME, MEMBERSHIP_NAME, POINT, ENTER_DATE, FINAL_DATE "
					+ "FROM CUSTOMER_TBL JOIN MEMBERSHIP_TBL ON MEMBER_LEVEL = MEMBERSHIP_LEVEL "
					+ "WHERE MEMBER_CODE = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, info);
			ResultSet rset = pstmt.executeQuery();
			customer = new Customer();
			if(rset.next()) {
				customer.setMemberCode(rset.getInt("MEMBER_CODE"));
				customer.setMemberName(rset.getString("MEMBER_NAME"));
				customer.setMembershipName(rset.getString("MEMBERSHIP_NAME"));
				customer.setPoint(rset.getInt("POINT"));
				customer.setEnter_date(rset.getDate("ENTER_DATE"));
				customer.setFinal_date(rset.getDate("FINAL_DATE"));
				System.out.println(1);
			}
			conn.close();
			pstmt.close();
			rset.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return customer;
	}

	/**
	 * 받은 멤버를 DB에 등록 성공시 0이 아닌 값 리턴
	 * @param customer
	 * @return int result
	 */
	public int register(Customer customer) {
		int result = 0;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "INSERT INTO CUSTOMER_TBL VALUES(?, ?, DEFAULT, DEFAULT, DEFAULT, DEFAULT)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customer.getMemberCode());
			pstmt.setString(2, customer.getMemberName());
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
	 * 입력받은 코드 해당 멤버 삭제 성공시 0이외 반환
	 * @param code
	 * @return int result
	 */
	public int delete(int code) {
		int result = 0;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "DELETE FROM CUSTOMER_TBL WHERE MEMBER_CODE = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
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
	 * 배열에 담긴 정보로 멤버 등급 변경 성공시 0이외 반환
	 * @param array
	 * @return int result
	 */
	public int updateMember(int[] array) {
		int result = 0;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "UPDATE CUSTOMER_TBL SET MEMBER_LEVEL = MEMBER_LEVEL + ? WHERE MEMBER_CODE = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, array[0]);
			pstmt.setInt(2, array[1]);
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
