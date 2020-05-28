//
package com.vti.JavaFinal.backend.businesslayer;

import java.io.IOException;
import java.sql.SQLException;

import com.vti.JavaFinal.backend.datalayer.IManagerDAO;
import com.vti.JavaFinal.backend.datalayer.ManagerDAO;

/**
 * This class is .
 * 
 * @author: Tân
 * @create_date: 25/03/2020
 */
public class ManagerService implements IManagerService {
	static IManagerDAO managerDao;

	/**
	 * Constructor for class ManagerService.
	 * 
	 * @author: Tân
	 * @create_date: 25/03/2020
	 */
	public ManagerService() {
		managerDao = new ManagerDAO();
	}

	/*
	 * @see com.vti.JavaFinal.backend.businesslayer.IManagerService#register()
	 */
	@Override
	public boolean register(String firstname, String lastname, String phone, String email, int expInYear, String pass)
			throws SQLException, IOException {
		try {
			return managerDao.register(firstname, lastname, phone, email, expInYear, pass);
		} catch (SQLException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
	}

	@Override
	public boolean login(String email, String pass) throws SQLException, IOException {
		if (!managerDao.login(email, pass)) {
			return false;
		} else
			return true;
	}
}
