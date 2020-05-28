package backend.businesslayer;

import entity.User;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NNDuy
 * @create_date: Mar 23, 2020
 * @version: 1.0
 * @modifer: NNDuy
 * @modifer_date: Mar 23, 2020
 */
public interface IUserService {

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Mar 23, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Mar 23, 2020
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean createUser(User user) throws Exception;
}
