package icecream.model.event.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import icecream.model.event.Event;

public class EventDAO {
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "ICECREAM";
	private final String PASSWORD = "ICECREAM";
	
	/**
	 * 이벤트 객체 받고 db에 정보 입력 성공시 0이외의 값 리턴
	 * @param event
	 * @return int result
	 */
	public int registEvent(Event event) {
		int result = 0;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "INSERT INTO EVENT_TBL VALUES(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, event.getEventCode());
			pstmt.setString(2, event.getEventName());
			pstmt.setDate(3, event.getEventStartTerm());
			pstmt.setDate(4, event.getEventEndTerm());
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
	 * 이벤트 코드 입력받고 db에서 해당 코드에 해당하는 이벤트 삭제 성공시 0이외 리턴
	 * @param code
	 * @return int result
	 */
	public int deleteEvent(int code) {
		int result = 0;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "DELETE FROM EVENT_TBL WHERE EVENT_CODE = ?";
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
	 * db에서 모든 이벤트 정보 Event에 담고 List에 채워 넘겨줌
	 * @return List<Event>
	 */
	public List<Event> showAllEvent() {
		List <Event> eList = null;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM EVENT_TBL";
			ResultSet rset = stmt.executeQuery(sql);
			eList = new ArrayList<Event>();
			while(rset.next()) {
				Event event = new Event();
				event.setEventCode(rset.getInt("EVENT_CODE"));
				event.setEventName(rset.getString("EVENT_NAME"));
				event.setEventStartTerm(rset.getDate("EVENT_START_TERM"));
				event.setEventEndTerm(rset.getDate("EVENT_END_TERM"));
				eList.add(event);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return eList;
	}
	
}
