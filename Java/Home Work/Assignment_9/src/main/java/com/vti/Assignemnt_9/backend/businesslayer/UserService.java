//
package com.vti.Assignemnt_9.backend.businesslayer;

import com.vti.Assignemnt_9.Entity.User;
import com.vti.Assignemnt_9.backend.datalayer.UserDAO;
import com.vti.Assignemnt_9.frontend.Errors;

/**
 * This class is logical user.
 * 
 * @author: Tân
 * @create_date: 31/03/2020
 */
public class UserService {
	/**
	 * 
	 * This method is login user. 
	 * 
	 * @author: Tân
	 * @create_date: 01/04/2020
	 * @param user
	 * @return 0 if create new account, 1 if update account
	 * @throws Errors
	 */
	public static int loginUser(User user) throws Errors {
		int check1 = UserDAO.isExistEmail(user.getEmail());
		int check2 = UserDAO.isExistAccount(user.getAccount());

		if (check1 + check2 == 0) {
			UserDAO.registerUser(user);
			return 0;
		}
		if (check1 != check2 && check1 != 0 && check2 != 0) {
			throw new Errors(1004);
		}
		UserDAO.updateUser(user);
		return 1;
	}
}
