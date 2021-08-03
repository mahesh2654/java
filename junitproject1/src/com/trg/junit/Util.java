package com.trg.junit;

import com.trg.junit.exceptions.NegativeNumberException;

public class Util {

	public long getFactorial(int n) {

		if (n < 0) {
			throw new NegativeNumberException();
		}
		long fact = 1;
		for (int i = 1; i <= n; i++) {
			fact = fact * i;
		}

		return fact;
	}

	public static String getDayName(int day) {
		switch (day) {
		case 1:
			return "Sunday";
		case 2:
			return "Monday";
		case 3:
			return "TuesDay";
		case 4:
			return "Wednesday";
		case 5:
			return "Thursday";
		case 6:
			return "Friday";
		case 7:
			return "Saturday";
		default:
			return null;

		}
	}
}
