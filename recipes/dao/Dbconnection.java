package recipes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import recipes.exception.DbExceptions;

public class Dbconnection {

	private static final String SCHEMA = "recipes";
	private static final String USER = "recipes";
	private static final String PASSWORD = "recipes";
	private static final String HOST = "localhost";
	private static final int PORT = 3306;
	
	public static Connection getConnection() {
		String url = String.format("jdbc:mysql://%s:%d/%S?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA, USER, PASSWORD);
		
		System.out.println("connecting with url=" + url);
		
		try {
			Connection conn = DriverManager.getConnection(url);
			System.out.println("successfully obtained connection");
			return conn;
		} catch (SQLException e) {
			throw new DbExceptions(e);
		}
	}
}
