//
package com.vti.JavaFinalTest.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.vti.JavaFinalTest.frontend.Errors;

/**
 * This class is manager project.
 * 
 * @author: Tân
 * @create_date: 29/03/2020
 */
public class ProjectUtils {

	/**
	 * 
	 * This method is get number of projects.
	 * 
	 * @author: Tân
	 * @create_date: 29/03/2020
	 * @return number of projects
	 * @throws Errors
	 */
	public static int number_Project() throws Errors {
		// Read from project_info.properties
		FileReader reader;
		try {
			reader = new FileReader("src/main/resources/project_info.properties");
			Properties properties = new Properties();
			properties.load(reader);

			// Get information project info, convert to integer
			return Integer.parseInt(properties.getProperty("num_of_project"));
		} catch (IOException e) {
			throw new Errors(1002);
		}
	}

	/**
	 * 
	 * This method get array of project name.
	 * 
	 * @author: Tân
	 * @create_date: 29/03/2020
	 * @return array of String[]
	 * @throws Errors
	 */
	public static String[] getListProject() throws Errors {
		// Read from project_info.properties
		FileReader reader;
		try {
			// get number of project
			int num = number_Project();
			String[] project = new String[num];

			// open project info
			reader = new FileReader("src/main/resources/project_info.properties");
			Properties properties = new Properties();
			properties.load(reader);

			// Read each project name
			String name = "project_";

			for (int index = 0; index < num; ++index) {
				project[index] = index + "- " + properties.getProperty(name + index);
			}

			return project;
		} catch (IOException e) {
			throw new Errors(1002);
		}
	}

	public static String getName(int index) throws Errors {
		// Read from project_info.properties
		FileReader reader;
		try {
			// open project info
			reader = new FileReader("src/main/resources/project_info.properties");
			Properties properties = new Properties();
			properties.load(reader);

			return properties.getProperty("project_" + index);
		} catch (IOException e) {
			throw new Errors(1002);
		}
	}
}
