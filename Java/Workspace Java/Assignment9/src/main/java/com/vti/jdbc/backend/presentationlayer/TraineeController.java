//
package com.vti.jdbc.backend.presentationlayer;

import java.util.List;

import com.vti.jdbc.backend.businesslayer.ITraineeService;
import com.vti.jdbc.backend.businesslayer.TraineeService;
import com.vti.jdbc.entity.Trainee;

/**
 * This class is .
 * 
 * @Description: .
 * @author: hung34atp
 * @create_date: Mar 23, 2020
 * @version: 1.0
 * @modifer: hung34atp
 * @modifer_date: Mar 23, 2020
 */
public class TraineeController {
	private ITraineeService service;

	/**
	 * Constructor for class TraineeController.
	 * 
	 * @Description: .
	 * @author: hung34atp
	 * @create_date: Mar 24, 2020
	 * @version: 1.0
	 * @modifer: hung34atp
	 * @modifer_date: Mar 24, 2020
	 */
	public TraineeController() {
		service = new TraineeService();
	}

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: hung34atp
	 * @create_date: Mar 24, 2020
	 * @version: 1.0
	 * @modifer: hung34atp
	 * @modifer_date: Mar 24, 2020
	 * @return
	 */
	public List<Trainee> getAllTrainee() {
		return service.getAllTrainee();
	}

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: hung34atp
	 * @create_date: Mar 24, 2020
	 * @version: 1.0
	 * @modifer: hung34atp
	 * @modifer_date: Mar 24, 2020
	 * @param trainee
	 * @return
	 */
	public boolean insertTrainee(Trainee trainee) {
		return service.insertTrainee(trainee);
	}

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: hung34atp
	 * @create_date: Mar 24, 2020
	 * @version: 1.0
	 * @modifer: hung34atp
	 * @modifer_date: Mar 24, 2020
	 * @param trainee
	 * @return
	 */
	public boolean updateTrainee(Trainee trainee) {
		return service.updateTrainee(trainee);
	}

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: hung34atp
	 * @create_date: Mar 24, 2020
	 * @version: 1.0
	 * @modifer: hung34atp
	 * @modifer_date: Mar 24, 2020
	 * @param id
	 * @return
	 */
	public boolean deleteTrainee(int id) {
		return service.deleteTrainee(id);
	}
	
	/**
	 * This method is . 
	 * 
	 * @Description: .
	 * @author: hung34atp
	 * @create_date: Mar 24, 2020
	 * @version: 1.0
	 * @modifer: hung34atp
	 * @modifer_date: Mar 24, 2020
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public boolean login(String userName, String passWord) {
		return service.login(userName, passWord);
	}
}
