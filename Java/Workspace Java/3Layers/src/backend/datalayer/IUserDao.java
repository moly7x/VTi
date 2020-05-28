package backend.datalayer;

import entity.User;

public interface IUserDao {

	boolean login(String username, String password);

	boolean createUser(User user);

	boolean updateUser(User user);

	boolean deleteUser(int id);
}
