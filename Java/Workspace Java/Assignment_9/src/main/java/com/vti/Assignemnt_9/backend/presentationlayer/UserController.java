//
package com.vti.Assignemnt_9.backend.presentationlayer;

import com.vti.Assignemnt_9.Entity.User;

import com.vti.Assignemnt_9.backend.businesslayer.UserService;
import com.vti.Assignemnt_9.frontend.Errors;
import com.vti.Assignemnt_9.frontend.Print;

public class UserController {
	public static void main(String[] args) {
		User user = new User(Print.getAccount(), Print.getFirstName(), Print.getLastName(), Print.getEmail());
		try {
			if (UserService.loginUser(user) == 0) {
				Print.printMessage("Create account Successful");
			} else {
				Print.printMessage("Update account Successful");
			}
			Print.printMessage("Your infomation!");
			Print.printUser(user);
		} catch (Errors e) {
			Print.printErrors(e);
		}
	}

}
