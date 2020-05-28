//
package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.DatabaseUtils;

/**
 * This class is .
 * 
 * @author: Tân
 * @create_date: 21/05/2020
 */
public class DAO {
	public static void login(String user, String pass) throws SQLException, IOException {
		Connection connect = null;
		PreparedStatement query = null;
		ResultSet result = null;

		try {
			connect = DatabaseUtils.connect();
			System.out.println("Connected");
			query = connect.prepareStatement("Select `user`, pass from `user` where user = ? and pass = ?");
			query.setString(1, user);
			query.setString(2, pass);
			result = query.executeQuery();
//			String sql = "Select * from `user` where user = '" + user + "' and pass = '" + pass + "'";
//			System.out.println(sql);
//			query = connect.createStatement();
//			result = query.executeQuery(sql);
			result.last();
			if (result.getRow() != 0) {
				System.out.println("Thành công");
			} else {
				System.out.println("Thất bại");
			}
		} catch (SQLException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {

		}
	}
}
