//
package com.vti.JavaFinal.backend.datalayer;

import java.io.IOException;
import java.sql.SQLException;

/**
 * This class is . 
 * 
 * @author: Tân
 * @create_date: 25/03/2020
 */
public interface IManagerDAO {

	/**
	 * This method is . 
	 * 
	 * @author: Tân
	 * @create_date: 25/03/2020
	 * @param firstname
	 * @param lastname
	 * @param phone
	 * @param email
	 * @param expInYear
	 * @param pass
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	boolean register(String firstname, String lastname, String phone, String email, int expInYear, String pass)
			throws SQLException, IOException;
	
	boolean login(String email, String pass) throws SQLException, IOException;
}
