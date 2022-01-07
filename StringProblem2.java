package stringproject;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		// convert str to StringBuilder
		StringBuilder sb = new StringBuilder(str);

		// check every character and change if it is vowel
		String digit = "";
		for (int i = 0; i < str.length(); i++) {
			String s = sb.substring(i, i + 1);
			if (s.matches("[aeiou]")) {      

				switch (s.toUpperCase()) {   
				case "A":
					digit = "1";
					break;
				case "E":
					digit = "2";
					break;
				case "I":
					digit = "3";
					break;
				case "O":
					digit = "4";
					break;
				case "U":
					digit = "5";
				}
				sb.replace(i, i + 1, digit);
			}
		}
		str = sb.toString();
		System.out.println(str);

	}

}
