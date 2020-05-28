package backend.businesslayer;

import backend.datalayer.IUserDao;
import backend.datalayer.UserDao;
import entity.User;

/**
 * This class is service of user which is handled request information.
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 20, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 20, 2020
 */
public class UserService implements IUserService{

	private IUserDao dao;

	/**
	 * Constructor for class UserService.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 20, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 20, 2020
	 */
	public UserService() {
		dao = new UserDao();
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
		// TODO check trung ten
		if (user.getTen().equals("Nguyen Van A")) {
			throw new Exception("User's name is already exists!");
		}

		// successful logic validation
		boolean result = dao.createUser(user);
		return result;
	}
}
