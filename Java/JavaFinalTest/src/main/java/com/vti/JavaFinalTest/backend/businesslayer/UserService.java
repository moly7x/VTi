//
package com.vti.JavaFinalTest.backend.businesslayer;

import com.vti.JavaFinalTest.backend.datalayer.UserDAO;
import com.vti.JavaFinalTest.frontend.Errors;

/**
 * This class logical user. 
 * 
 * @author: Tân
 * @create_date: 30/03/2020
 */
public class UserService {
	public static String login(String email, String password) throws Errors {
		return UserDAO.login(email, password);
	}
}
