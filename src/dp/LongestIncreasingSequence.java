package dp;

import java.util.Arrays;

/*
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * the longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 * 
 * For Dynamic Programming (lengthOfLIS1),
 * Time complexity : O(n^2). Two loops of n are there.
 * Space complexity : O(n). dp array of size n is used.
 * 
 * For Dynamic Programming with Binary Search (lengthOfLIS2),
 * Time complexity : O(nlog(n)). Binary search takes log(n) time and it is called n times.
 * Space complexity : O(n). dp array of size n is used.
 * 
 */
public class LongestIncreasingSequence {
    public static int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
    
    public static int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
    
	public static void main(String[] args) {
		int[] a = {10, 9, 2, 5, 3, 7, 101};
		System.out.println(lengthOfLIS1(a));
		System.out.println(lengthOfLIS2(a));
	}
}
