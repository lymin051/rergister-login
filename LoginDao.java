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
		//�s���ƾڮw�P�_�O�_�n�J���\
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//1.����s��
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false","root","123456");
			//2.�w�qSQL
			String sql = "select * from employees where username= '"+username+"' and password= '"+password+"'";
			//3.�������SQL����H
			stmt = conn.createStatement();
			//4.����d��
			rs = stmt.executeQuery(sql);
			//5.�P�_
			return rs.next();//�p�G���U�@��,�h��^true
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			//6.����귽
			//stmt.close();
			//conn.close();
			//�קK�ū��w���`
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
