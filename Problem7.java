
public class Problem7 {
	public static void main(String[] args) {

		System.out.println(checkNumber(23546));
		System.out.println(checkNumber(2689));
		System.out.println(checkNumber(124578));
		System.out.println(checkNumber(233457));
		System.out.println(checkNumber(24687));
		System.out.println(checkNumber(62345));

	}

	static boolean checkNumber(int n) {

		int digit = n % 10;
		n = n / 10;

		while (n > 0) {

			if (n % 10 > digit)
				return false;
			digit = n % 10;
			n = n / 10;
		}

		return true;
	}
}

// 23467