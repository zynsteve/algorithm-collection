package math;

import java.util.Scanner;

/*
 * Find the maximum product of 3 numbers in a unsorted array. Time：O(n)，Space: O(1).
 */
public class MaxProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextLong();
        }
        System.out.println(getLargestProduct(array, n));
    }
      
    public static long getLargestProduct(long[] nums, int len) {
        long max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
		long min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (long n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}
