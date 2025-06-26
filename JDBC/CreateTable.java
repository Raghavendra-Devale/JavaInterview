package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable {
	public static void main(String[] args) {
		
		String sql ="jdbc:mysql://localhost:3306/jdbc_db";
		String username = "root";
		String pwd = "root123";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(sql,username,pwd);
			System.out.println("connected ");
			
			Statement st = con.createStatement();
			
			String createSQLTable =  "create table if not exists users("
			+"id INT,"
			+"name  varchar(100),"
			+"email varchar(100)"+")";
			
			st.executeUpdate(createSQLTable);
			st.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	
	}
}
