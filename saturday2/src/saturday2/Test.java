package saturday2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import oracle.jdbc.driver.OracleDriver;

public class Test {

	public static void main(String[] args) {
		Connection conn;
		PreparedStatement pstmt; // Statement의 subclass
		ResultSet rs;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##itbank";
		String password = "it";
		String className = OracleDriver.class.getName();

		try {
			Class.forName(className);
			
			String sql = "select banner from v$version";
			conn = DriverManager.getConnection(url, user, password);
			pstmt =conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("banner"));
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
}
