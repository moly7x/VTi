package javabasics;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

class data {
	static String[] firstName = { "Trieu", "Dinh", "Ly", "Tran", "Le", "Trinh", "Nguyen" };
	static String[] MiddleName = { "Thanh", "Ha", "Hoang", "Hai", "Hanh", "Nhung", "Van" };
	static String[] LastName = { "Duong", "Duc", "Chi", "Bao", "Trung", "Giang", "Huy" };

	static int random(int start, int end) {
		Random r = new Random();
		return (r.nextInt((end - start) + 1) + start);
	}

	static String lpad(int id, int num) {
		return String.format("%" + num + "s", id).replace(" ", "0");
	}

	static String ranbirth() {
		Calendar date = new GregorianCalendar();
		date.set(Calendar.YEAR, 1991);
		date.set(Calendar.MONTH, random(Calendar.FEBRUARY, Calendar.DECEMBER));
		date.set(Calendar.DAY_OF_MONTH, random(1, date.getActualMaximum(Calendar.DAY_OF_MONTH)));
		return (lpad(date.get(Calendar.DAY_OF_MONTH), 2) + "/" + 
				lpad((date.get(Calendar.MONTH) + 1), 2) + "/"
				+ date.get(Calendar.YEAR));

	}

	String name, id, birth;
	int ra, sd, cp, cut, fmt;
	float avg;
	data(int start, int end) {
		name = firstName[random(0, 6)] + " " + MiddleName[random(0, 6)] + " " + LastName[random(0, 6)];
		id = "SV" + lpad(random(0, 9999999), 7);
		birth = ranbirth();
		// -------------------------------
		ra = random(start, end);
		sd = random(start, end);
		cp = random(start, end);
		cut = random(start, end);
		fmt = random(start, end);
		avg = (ra + sd + cp + cut + fmt) / 5.0f;
		
	}
	data (){
	}
}

public class Assignment_2_3 {
	
	public static void main(String[] args) {
		data st[] = new data[10];
		// -----------------------
		System.out.printf("%-20s%-12s%-12s %-5s%-5s%-5s%-5s%-5s %s\n", "Full Name", "ID", "Date", "RA", "SD", "CP", "CUT", "FMT", "Avg");
		System.out.printf(String.format("%75s\n", "-").replace(" ", "-"));
		// -----------------------
		st[0] = new data(8, 10);
		for (int i = 1; i <= 3; ++i ) {
			st[i] = new data(5, 7);
		}
		for (int i = 4; i <= 6; ++i ) {
			st[i] = new data(3, 4);
		}
		for (int i = 7; i <= 8; ++i ) {
			st[i] = new data(1, 2);
		}
		st[9] = new data(0,0);
		
		for (int i = 0; i <= 9; ++i) {
			for (int j = 0; j <= (i - 1); ++j) {
				if (st[i].avg > st[j].avg) {
					data temp = new data();
					temp = st[i];
					st[i] = st[j];
					st[j] = temp;
				}
			}
		}
		// -----------------------
		for (int i = 0; i <= 9; ++i ) {
			System.out.printf("%-20s%-12s%-12s %-5d%-5d%-5d%-5d%-5d %.2f\n", st[i].name, st[i].id, st[i].birth, st[i].ra, st[i].sd, st[i].cp, st[i].cut, st[i].fmt, st[i].avg);
		}
	}

}