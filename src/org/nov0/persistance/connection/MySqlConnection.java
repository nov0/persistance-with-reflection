package org.nov0.persistance.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton class for connecting to database.
 * 
 * @author Novislav Sekulic
 *
 */

public class MySqlConnection {

	private static MySqlConnection instance;
	private static Connection connection;

	private String username;
	private String password;
	private String database;

	private MySqlConnection() {

	}

	public static MySqlConnection getInstance(String databaseUrl, String username, String password) {

		if (instance == null) {
			instance = new MySqlConnection();
			instance.setUsername(username);
			instance.setPassword(password);
			instance.setDadabaseUrl(databaseUrl);
		}

		return instance;

	}

	public Connection getConnetcion() {
		if (connection == null) {

			try {
				connection = DriverManager.getConnection(database, username, password);
			} catch (SQLException e) {
				System.err.println("Cannot connect to database!\nCheck your credentials, and try again.");
				e.printStackTrace();
			}
		}

		return connection;
	}

	public static void closeConnection() {

		if (connection != null) {
			try {
				connection.close();
				connection = null;
				instance = null;
			} catch (SQLException e) {
				System.err.println("Cannot close connection.");
				e.printStackTrace();
			}
		}
	}

	public static String getConnectionStatus() {
		return connection == null ? "Connection closed" : "Connection open";
	}

	private void setUsername(String username) {
		this.username = username;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	private void setDadabaseUrl(String databaseUrl) {
		this.database = databaseUrl;
	}

}
