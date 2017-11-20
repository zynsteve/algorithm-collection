package dp;

public class BasicBackbag {
    public static int getMaxValue(int[] weight, int[] value, int w, int n) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) { // loop over items
            for (int j = 1; j <= w; j++) {  // weight of the backbag
                if (weight[i] > j) { // if item i is smaller than capacity j，do not take the item
                    dp[i][j] = dp[i - 1][j];
                } else { // if item i is larger than capacity j ，Max{take i， not take i}
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        int n = 5, w = 10;                    // number of items，capacity of backbag
        int[] value = {0, 6, 3, 5, 4, 6};     // value
        int[] weight = {0, 2, 2, 6, 5, 4};    // weight
        System.out.println(getMaxValue(weight, value, w, n));
    }
}
