
public class Problem6 {
	public static void main(String[] args) {

		int result = calculateDifference(8);
		System.out.println(result);
	}

	static int calculateDifference(int n) {

		int sumSqures = 0; // to store sum of squares
		int sum = 0;       // to store sum of all numbers

		for (int i = 1; i <= n; i++) {
			sumSqures += i * i;
			sum = sum + i;

		}
		sum = sum * sum; // square of sum
		int difference = sumSqures - sum;
		return difference;
	}
}
