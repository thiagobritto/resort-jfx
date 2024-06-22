package br.com.sys.main.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private final static String URL = "jdbc:postgresql://localhost:5432/JFX_RESORT";
	private final static String USER = "postgres";
	private final static String PASS = "123";
	
	private static Connection con;

	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");

			if (con == null || con.isClosed())
				con = DriverManager.getConnection(URL, USER, PASS);

			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void closeConnection() {
		if (con != null) {
			try {

				if (!con.isClosed())
					con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
