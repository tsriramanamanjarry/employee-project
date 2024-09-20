package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	public static Connection connectDb() {
		Connection con=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enterdatabasename","username","password");
		}
	    catch(ClassNotFoundException c) {
			System.out.println(c);
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return con;

}
}
