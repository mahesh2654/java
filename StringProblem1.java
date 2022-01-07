package stringproject;

public class Main2 {

	public static void main(String[] args) {
		String line = "abc2def5xyz8hell44pqr9ddd0abcd";
		String changedLine = changeText(line);
		System.out.println(changedLine);
	}

	static String changeText(String str) {
		StringBuilder sb = new StringBuilder(str);

		// string values representing each digit
		String names[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

		for (int i = 0; i < sb.length(); i++) {
			String s = sb.substring(i, i + 1);

			if (s.matches("[0-9]")) {                  
				int x = Integer.parseInt(s);
				// pickup string value based on x
				String code = names[x];
				sb.replace(i, i + 1, code);
			}
		}
		return sb.toString();

	}

}
