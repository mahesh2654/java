package com.test.dyna;

public class TranslatorEngine {

	public static String tranlate(String text) {

		switch (text) {
		case "Hello":
			return "Bonjour";

		case "Yes":
			return "Oui";

		case "No":
			return "Non";

		case "Goodbye":
			return "Au revoir";

		case "Good night":
			return "Bonne nuit";

		case "Thank you":
			return "Merci";
		default:
			return "Not found";
		}
	}

}
