package dp;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibonacci1(n));
        System.out.println(fibonacci2(n));
    }
	
	/*
	 *  Recursive. T(n) = T(n - 1) + T(n - 2) + O(1) => T(n) > Fn.
	 *  Time complexity: O(1.618 ^ n)
	 *  Space complexity: O(n)
	 */
	public static long fibonacci1(int n) {
		if (n == 0 || n == 1) return n;
		else return fibonacci1(n - 1) + fibonacci1(n - 2);
	}
	
	/*
	 *  DP.
	 *  Time complexity: O(n)
	 *  Space complexity: O(n)
	 */ 
	public static long fibonacci2(int n) {
		long[] dp = new long[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
