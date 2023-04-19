package saturday2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class userDAO {
	
	
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String url ="jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##saturday";
	private String password = "sat";
	
	private String  className = OracleDriver.class.getName();
	
	public userDAO() {
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public userDTO selectOne(String id, String pw) {
		userDTO dto = new userDTO();
		String sql = "select * from chatuser where id = ? and pw = ?";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setUserId(id); 
				dto.setUserPw(pw);
				dto.setNickName(rs.getString("nickName"));
			} else {
				dto =null;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
		
	}
	
}
