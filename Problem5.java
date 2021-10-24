
public class Problem5 {

	public static void main(String[] args) {

		int sum = calculateSum(16);
		System.out.println(sum);

	}

	static int calculateSum(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 || i % 5 == 0)
				sum = sum + i;
		}
		return sum;
	}

}
