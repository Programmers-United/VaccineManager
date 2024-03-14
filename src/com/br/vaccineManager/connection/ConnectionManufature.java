package com.br.vaccineManager.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManufature {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/NameOfBatabase", "User", "PassWord");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
