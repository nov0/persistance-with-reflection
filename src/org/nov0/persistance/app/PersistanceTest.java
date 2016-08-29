package org.nov0.persistance.app;

import org.nov0.persistance.connection.MySqlConnection;
import org.nov0.persistance.create.CreatingTableModelDAO;

/**
 * Class for testing purposes. Containing main method for execution application.
 * 
 * 
 * @author novo
 *
 */
public class PersistanceTest {

	public static void main(String[] args) {

		init("create");
		destroy();

	}

	public static void init(String option) {

		if (option.equals("create")) {
			CreatingTableModelDAO.creteTablesFromPackageClasses("org.nov0.persistance.model");
		} else if (option.equals("update")) {
			System.out.println("Yet to be implemented!");
		}
	}

	public static void destroy() {
		MySqlConnection.closeConnection();
	}

}
