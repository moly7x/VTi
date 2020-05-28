package backend.presentationlayer;

import backend.businesslayer.IUserService;
import backend.businesslayer.UserService;
import entity.User;

/**
 * This class is controller of user which is receipted request information.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 20, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 20, 2020
 */
public class UserController {

	private IUserService service;

	/**
	 * Constructor for class UserController.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 20, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 20, 2020
	 */
	public UserController() {
		service = new UserService();
	}

	/**
	 * This method is created user.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 20, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 20, 2020
	 * @param user
	 * @throws Exception
	 */
	public boolean createUser(User user) throws Exception {
		// validate
		if (null == user.getTen()) {
			throw new Exception("User's name must not be null");
		}

		if (user.getTuoi() <= 0) {
			throw new Exception("User's age must greater than 0");
		}

		// successful validation
		boolean result = service.createUser(user);
		return result;
	}
}
