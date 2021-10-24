
public class Problem8 {
	public static void main(String[] args) {

		System.out.println(checkNumber(8)); // true
		System.out.println(checkNumber(1024)); // true
		System.out.println(checkNumber(125)); // false
		System.out.println(checkNumber(0)); // false
		System.out.println(checkNumber(64)); // true
		System.out.println(checkNumber(82)); // false

	}

	static boolean checkNumber(int n) {

		if (n % 2 == 1) // false if n is odd number. no need to check further
			return false;

		// start p with 1 which is 2 power 0
		for (int p = 1; p <= n; p = p * 2) {
			if (n == p) {
				return true;
			}
		}

		// p which is power of 2 is greater than n. so return false
		return false;
	}
}
