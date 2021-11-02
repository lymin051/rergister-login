package tw.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tw.web.model.Employee;

public class EmployeeDao {
	
	private static final String INSTER_USERS_SQL = "insert into employees(first_name, last_name, username, password, address, contact) VALUES(?, ?, ?, ?, ?, ?);";
	
	protected Connection getConnection() {
		Connection conntrction = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conntrction = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false","root","123456");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conntrction;
	}
	public void registerEmployee(Employee employee) throws Exception{
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSTER_USERS_SQL)) {
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2,employee.getLastName());
			preparedStatement.setString(3,employee.getUsername());
			preparedStatement.setString(4,employee.getPassword());
			preparedStatement.setString(5,employee.getAddress());
			preparedStatement.setString(6,employee.getContact());
			preparedStatement.executeUpdate();
			System.out.println(preparedStatement);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}