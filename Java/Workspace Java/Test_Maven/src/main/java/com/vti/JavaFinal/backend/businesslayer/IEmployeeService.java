//
package com.vti.JavaFinal.backend.businesslayer;

import java.io.IOException;
import java.sql.SQLException;

/**
 * This class is .
 * 
 * @author: Tân
 * @create_date: 25/03/2020
 */
public interface IEmployeeService {
	public boolean register(String firstname, String lastname, String phone, String email, int projectName,
			String proSkill, String pass) throws SQLException, IOException;
	
	public boolean login(String email, String pass) throws SQLException, IOException;
}
