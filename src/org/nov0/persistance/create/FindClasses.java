package org.nov0.persistance.create;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * This is only for finding names of classes that are in the specified package. Uses
 * URL for finding relative project path. And File to scan for files in package.
 * 
 * @author Novislav Sekulic
 *
 */
public class FindClasses {

	public static List<String> getClasses(String packageName) {

		List<String> listOfClasses = new ArrayList<>();

		URL packageUrl = Thread.currentThread().getContextClassLoader().getResource(packageName.replace(".", "/"));

		if (packageUrl == null) {
			System.err.println("Package not found! ");
		} else {

			File currentPackage = new File(packageUrl.getFile());

			for (File file : currentPackage.listFiles()) {
				listOfClasses.add(file.getName().replace(".class", ""));
			}

		}

		return listOfClasses;
	}

}
