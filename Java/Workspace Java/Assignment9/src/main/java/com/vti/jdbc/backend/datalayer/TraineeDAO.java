//
package com.vti.jdbc.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.jdbc.DBConnect;
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
public class TraineeDAO implements ITraineeDAO {

	/*
	 * @see com.vti.jdbc.backend.datalayer.ITraineeDAO#login(java.lang.String,
	 * java.lang.String)
	 */
	public boolean login(String userName, String passWord) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnect.openConnection();
		int dem = 0;
		try {
			pstmt = con.prepareStatement("select 1 from Trainee where userName=? and passWord=?");
			pstmt.setString(1, userName);
			pstmt.setString(2, passWord);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dem++;
			}
			if (dem == 1) {
				return true;
			}else {
				return false;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnect.closeAll(con, pstmt, rs);
		}
		return false;
	}

	/*
	 * @see
	 * com.vti.jdbc.backend.datalayer.ITraineeDAO#insertTrainee(com.vti.jdbc.entity.
	 * Trainee)
	 */
	public boolean insertTrainee(Trainee trainee) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnect.openConnection();
		try {
			pstmt = con.prepareStatement(
					"insert into Trainee (userName,passWord,firstName,lastName,email) values (?,?,?,?,?)");
			pstmt.setString(1, trainee.getUserName());
			pstmt.setString(2, trainee.getPassWord());
			pstmt.setString(3, trainee.getFirstName());
			pstmt.setString(4, trainee.getLastName());
			pstmt.setString(5, trainee.getEmail());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeAll(con, pstmt, rs);
		}
		return false;
	}

	/*
	 * @see
	 * com.vti.jdbc.backend.datalayer.ITraineeDAO#updateTrainee(com.vti.jdbc.entity.
	 * Trainee)
	 */
	public boolean updateTrainee(Trainee trainee) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnect.openConnection();
		try {
			pstmt = con.prepareStatement(
					"update Trainee set firstName=?,lastName=?,email=?,passWord=? where userName=?");
			pstmt.setString(1, trainee.getFirstName());
			pstmt.setString(2, trainee.getLastName());
			pstmt.setString(3, trainee.getEmail());
			pstmt.setString(5, trainee.getUserName());
			pstmt.setString(4, trainee.getPassWord());
			
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeAll(con, pstmt, rs);
		}
		return false;
	}

	/*
	 * @see com.vti.jdbc.backend.datalayer.ITraineeDAO#deleteTrainee(int)
	 */
	public boolean deleteTrainee(int id) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnect.openConnection();
		try {
			pstmt = con.prepareStatement("delete from Trainee where id=" + id);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeAll(con, pstmt, rs);
		}
		return false;

	}

	/*
	 * @see com.vti.jdbc.backend.datalayer.ITraineeDAO#getAllTrainee()
	 */
	public List<Trainee> getAllTrainee() {
		List<Trainee> list = new ArrayList<>();
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnect.openConnection();
		try {
			pstmt = con.prepareStatement("select * from Trainee");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Trainee t = new Trainee();
				t.setId(rs.getInt("id"));
				t.setUserName(rs.getString("userName"));
				t.setFirstName(rs.getString("firstName"));
				t.setLastName(rs.getString("lastName"));
				t.setEmail(rs.getString("email"));
				list.add(t);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeAll(con, pstmt, rs);
		}
		return null;
	}

	/* 
	* @see com.vti.jdbc.backend.datalayer.ITraineeDAO#getTraineeByUserName(java.lang.String)
	*/
	@Override
	public boolean getTraineeByUserName(String userName) {
		Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnect.openConnection();
		int dem = 0;
		try {
			pstmt = con.prepareStatement("select 1 from Trainee where userName=?");
			pstmt.setString(1, userName);		
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dem++;
			}
			if (dem == 1) {
				return true;
			}else {
				return false;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
			pstmt.close();
			rs.close();
			DBConnect.closeAll(con, pstmt, rs);
		}
		return false;
	}

}
