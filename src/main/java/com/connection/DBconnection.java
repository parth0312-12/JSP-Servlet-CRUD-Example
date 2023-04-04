package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

	private static Connection con=null;
	public static Connection getcon() 
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","parthmehta");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
