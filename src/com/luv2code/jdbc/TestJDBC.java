package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	
	public static void main(String[] args) {
		
		String jdbcURL= "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user="instructor";
		String pass="instructor";
		
	try {
			System.out.println("Connection with database"+jdbcURL);
			Connection connectionDatabase= DriverManager.getConnection(jdbcURL,user,pass);
			System.out.println("Connection successful");
	}
	catch(Exception ex) {
	ex.printStackTrace();
	}

}
}
