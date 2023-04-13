package chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class DAO {
	
	private String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user = "c##staurday";
	private String password = "sat";
	private String className =OracleDriver.class.getName();
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public DAO() {
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			System.out.println("생성자 예외 : " + e);
		}
	}
	
	public int check(String id, String pw) {
		int result = 0;
		String sql = "select * from chatuser where userid = ? and userpw = ?";
		
		try {
			conn = DriverManager.getConnection(url,user,password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				
//				DTO dto = new DTO();
//				dto.setUserId(id);
//				dto.setUserPw(pw);
				
				result =1;
			} else {
				result =2;
			}
			
			
			
		} catch (SQLException e) {
			System.out.println("check 예외 : "+ e);
			result =0;
		}
		
		return result;
	}
}
