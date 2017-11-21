package recursion;

import java.util.Scanner;

/*
 * Recursion: Euclidean algorithm.
 * Time complexity: O(logn)
 */
public class GreatestCommonDivisor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		System.out.print(getGCD(a, b));
	}
	
	public static long getGCD(long a, long b) {
	    if (b == 0) return a;
	    a = a % b;
	    return getGCD(b, a);
	}
}
