package backend.datalayer;

import entity.User;

/**
 * This class is user Data Accessing Object .
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 20, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 20, 2020
 */
public class UserDao implements IUserDao {

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createUser(User user) {
		// create user
		// TODO call JDBC statement
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
