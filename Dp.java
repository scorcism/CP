import java.util.*;

public class Dp {

    // Tabulation
    public static int CS_solve2(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Memoization
    public static int CS_solve1(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = CS_solve1(n - 1, dp) + CS_solve1(n - 2, dp);
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        // return CS_solve1(n, dp);
        return CS_solve2(n, dp);
    }

    static public int f(int index, int[] coins, int amount) {

        if (index == 0) {
            if ((amount % coins[index]) == 0) {
                return (amount / coins[index]);
            } else {
                return -1;
            }
        }
        // if(amount == 0){
        // return 1;
        // }
        // if(amount < 0){
        // return 0;
        // }

        // if(index <= 0){
        // return 0;
        // }
        int nottake = 0 + f(index - 1, coins, amount);
        int take = Integer.MAX_VALUE;
        if (coins[index - 1] <= amount) {
            take = 1 + f(index, coins, amount - coins[index - 1]);
        }

        return Math.min(take, nottake);

    }

    static public int coinChange(int[] coins, int amount) {
        return f(coins.length, coins, amount);
    }

    // Longest Increasing Subsequence
    static public int lengthOfLIS(int[] nums) {
        


        return 10;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 5, 1 };
        int n = 44;
        System.out.println(climbStairs(n));
    }
}