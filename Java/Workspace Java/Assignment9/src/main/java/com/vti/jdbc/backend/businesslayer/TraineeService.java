//
package com.vti.jdbc.backend.businesslayer;

import java.util.List;

import com.vti.jdbc.backend.datalayer.ITraineeDAO;
import com.vti.jdbc.backend.datalayer.TraineeDAO;
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
public class TraineeService implements ITraineeService {
	private ITraineeDAO dao;

	public TraineeService() {
		dao = new TraineeDAO();
	}

	/*
	 * @see
	 * com.vti.jdbc.backend.businesslayer.ITraineeService#insertTrainee(com.vti.jdbc
	 * .entity.Trainee)
	 */
	@Override
	public boolean insertTrainee(Trainee trainee) {
		boolean bl = dao.getTraineeByUserName(trainee.getUserName());
		if(!bl) {
			return dao.insertTrainee(trainee);
		}else {
			System.out.println("UserName existed!");
			return false;
		}
		
	}

	/*
	 * @see com.vti.jdbc.backend.businesslayer.ITraineeService#getAllTrainee()
	 */
	@Override
	public List<Trainee> getAllTrainee() {
		return dao.getAllTrainee();
	}

	/*
	 * @see
	 * com.vti.jdbc.backend.businesslayer.ITraineeService#updateTrainee(com.vti.jdbc
	 * .entity.Trainee)
	 */
	@Override
	public boolean updateTrainee(Trainee trainee) {
		boolean bl = dao.getTraineeByUserName(trainee.getUserName());
		if (bl) {
			return dao.updateTrainee(trainee);
		}else {
			System.out.println("UserName is not existed!");
			return false;
		}
		
	}

	/*
	 * @see com.vti.jdbc.backend.businesslayer.ITraineeService#deleteTrainee(int)
	 */
	@Override
	public boolean deleteTrainee(int id) {
		return dao.deleteTrainee(id);
	}

	/* 
	* @see com.vti.jdbc.backend.businesslayer.ITraineeService#login(java.lang.String, java.lang.String)
	*/
	@Override
	public boolean login(String userName, String passWord) {
		return dao.login(userName, passWord);
	}

}
