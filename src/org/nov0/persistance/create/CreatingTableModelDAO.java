package org.nov0.persistance.create;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.nov0.persistance.connection.MySqlConnection;

public class CreatingTableModelDAO {

	public static void createTableFromModel(Class<?> model) {

		String createTableQuery = ScannModel.getModelQuery(model);
		
		try (Connection conn = MySqlConnection.getInstance("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "root").getConnetcion();
				PreparedStatement prepStmnt = conn.prepareStatement(createTableQuery)) {
			prepStmnt.executeUpdate();
			System.out.println("Table created");
		} catch (SQLException ex) {
			System.err.println("Error creating table. Maybe table \"" + model.getSimpleName().toLowerCase() + "\" already exist in database.");
			ex.getStackTrace();
		} finally {
			MySqlConnection.closeConnection();
		}

	}

	public static void creteTablesFromPackageClasses(String packageName) {

		List<String> classList = FindClasses.getClasses(packageName);

		if (classList.isEmpty()) {
			System.err.println("No classes in package: " + packageName);

		} else {
			for (String className : classList) {

				try {
					createTableFromModel(Class.forName(packageName + "." + className));
				} catch (ClassNotFoundException e) {
					System.err.println("Classes not found in package");
				}
			}
		}

	}

}
