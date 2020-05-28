//
package com.vti.JavaFinalTest.backend.businesslayer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vti.JavaFinalTest.backend.datalayer.UserDAO;
import com.vti.JavaFinalTest.frontend.Errors;
import com.vti.JavaFinalTest.utils.ProjectUtils;

/**
 * This class checking for user.
 * 
 * @author: Tân
 * @create_date: 29/03/2020
 */
public class Valid {
	/**
	 * 
	 * This method checking email. If it has some error, it will throw.
	 * 
	 * @author: Tân
	 * @create_date: 29/03/2020
	 * @param email
	 * @throws Errors
	 */
	public static void checkEmail(String email) throws Errors {
		String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
		if (!Pattern.matches(regex, email)) {
			throw new Errors(1003);
		}

		// Check duplication email
		if (!UserDAO.isDubEmail(email)) {
			throw new Errors(1004);
		}
	}

	/**
	 * 
	 * This method checking phone number .
	 * 
	 * @author: Tân
	 * @create_date: 29/03/2020
	 * @param phone
	 * @throws Errors
	 */
	public static void checkPhone(String phone) throws Errors {
		String regex = "([0-9]{10})";
		String[] headphone = new String[] { "086", "096", "097", "098", "032", "033", "034", "035", "036", "037", "038",
				"039", "091", "094", "088", "083", "084", "085", "081", "082", "089", "090", "093", "070", "079", "077",
				"076", "078", "092", "056", "058", "099", "059" };

		// Check length number
		if (phone.length() != 10) {
			throw new Errors(1005);
		}

		// Check only number
		if (!Pattern.matches(regex, phone)) {
			throw new Errors(1005);
		}

		// Check head phone number
		boolean check = false;
		for (int index = 0; index < headphone.length; ++index) {
			if (phone.contains(headphone[index])) {
				check = true;
			}
		}
		if (!check) {
			throw new Errors(1005);
		}

		// Check duplication number
		if (!UserDAO.isDubPhone(phone)) {
			throw new Errors(1006);
		}
	}

	/**
	 * 
	 * This method check ExpInYear .
	 * 
	 * @author: Tân
	 * @create_date: 29/03/2020
	 * @param ExpInYear
	 * @throws Errors if ExpInYear <0 or ExpInYear>20
	 */
	public static void checkExpInYear(int ExpInYear) throws Errors {
		if (ExpInYear < 0 || ExpInYear > 20) {
			throw new Errors(1007);
		}
	}

	/**
	 * 
	 * This method check ProjectID .
	 * 
	 * @author: Tân
	 * @create_date: 30/03/2020
	 * @param projectName
	 * @throws Errors
	 */
	public static void checkProjectName(int projectName) throws Errors {
		int num_of_Project = ProjectUtils.number_Project();
		if (projectName < 0 || projectName > (num_of_Project - 1)) {
			throw new Errors(1008);
		}
	}

	public static void checkStrengthPassword(String password) throws Errors {
		Pattern pattern = null;
		Matcher matcher = null;

		// check length password 6->12
		if (password.length() < 6 || password.length() > 12) {
			throw new Errors(1009);
		}

		// Check have at least 1 number
		String number = "([0-9])";
		pattern = Pattern.compile(number);
		matcher = pattern.matcher(password);
		if (!matcher.find()) {
			throw new Errors(1009);
		}

		// Check have at least 1 special character
		String sp_character = "([\\x21-\\x2F\\x3A-\\x40\\x5B-\\x60\\x7B-\\x7E])";
		pattern = Pattern.compile(sp_character);
		matcher = pattern.matcher(password);
		if (!matcher.find()) {
			throw new Errors(1009);
		}

		// Check have at least 1 downcase character
		String down_character = "([a-z])";
		pattern = Pattern.compile(down_character);
		matcher = pattern.matcher(password);
		if (!matcher.find()) {
			throw new Errors(1009);
		}

		// Check have at least 1 upcase character
		String up_character = "([A-Z])";
		pattern = Pattern.compile(up_character);
		matcher = pattern.matcher(password);
		if (!matcher.find()) {
			throw new Errors(1009);
		}
	}
}
