package Samsung;

import java.util.Scanner;

public class StockbuySell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println();
		}

	}

	public static int localMin(int[] price, int k) {
		int profit = 0;
		int localmin = price[0];
		for (int i = 1; i < price.length; i++) {
			if (price[i - 1] >= price[i]) {
				localmin = price[i];
			}
			else {
				profit += price[i] - localmin;
				localmin = price[i];
			}
		}
		return profit;
	}

	/**
	 * This is faster method which does optimization on slower method Time
	 * complexity here is O(K * number of days)
	 *
	 * Formula is T[i][j] = max(T[i][j-1], prices[j] + maxDiff) maxDiff =
	 * max(maxDiff, T[i-1][j] - prices[j])
	 */

	public static int stockBuySellfaster(int[] price, int k) {
		if (k == 0 || price.length == 0) {
			return 0;
		}
		if (k >= price.length) {
			return localMin(price, k);
		}
		int strg[][] = new int[k + 1][price.length];
		for (int i = 1; i < strg.length; i++) {
			int maxdiff = -price[0];
			for (int j = 1; j < strg[0].length; j++) {
				maxdiff = Math.max(maxdiff, strg[i - 1][j - 1] - price[j - 1]);
				strg[i][j] = Math.max(strg[i][j - 1], maxdiff + price[j]);

			}
		}
		return strg[k][price.length - 1];

	}

}
