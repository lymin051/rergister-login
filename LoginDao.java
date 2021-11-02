package tw.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginDao{
	public boolean login(String username , String password) {
		if(username == null || password == null) {
			return false;
		}
		//連接數據庫判斷是否登入成功
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//1.獲取連接
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false","root","123456");
			//2.定義SQL
			String sql = "select * from employees where username= '"+username+"' and password= '"+password+"'";
			//3.獲取執行SQL的對象
			stmt = conn.createStatement();
			//4.執行查詢
			rs = stmt.executeQuery(sql);
			//5.判斷
			return rs.next();//如果有下一行,則返回true
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			//6.釋放資源
			//stmt.close();
			//conn.close();
			//避免空指針異常
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
		}
		return false;
	}
}
