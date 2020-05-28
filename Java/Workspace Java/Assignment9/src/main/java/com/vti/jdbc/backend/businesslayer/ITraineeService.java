//
package com.vti.jdbc.backend.businesslayer;

import java.util.List;

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
public interface ITraineeService {
	boolean login(String userName, String passWord);

	List<Trainee> getAllTrainee();

	boolean insertTrainee(Trainee trainee);

	boolean updateTrainee(Trainee trainee);

	boolean deleteTrainee(int id);
}
