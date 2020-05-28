//
package com.vti.JavaFinal.backend.presentationlayer;

import java.io.IOException;
import java.sql.SQLException;

/**
 * This class is . 
 * 
 * @author: Tân
 * @create_date: 25/03/2020
 */
public interface IManagerController {
	/**
	 * 
	 * This method is regiseter. 
	 * 
	 * @author: Tân
	 * @throws SQLException 
	 * @throws IOException 
	 * @create_date: 25/03/2020
	 */
	void register() throws SQLException, IOException;
	public boolean login(String email, String pass) throws SQLException, IOException;
}
