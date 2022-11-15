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

    
    public static void brute_LIS(int[] nums, int size){
        // This is to print all the subsequence
        
        int count  = 0;
        // Getting all the row of length nums
        
        for(int i = 0; i<(1<<size);i++){
            // to store value at each level measn row
            String value = "";
            // Iterating through the columns
            for(int j = 0; j<size; j++){
                // check if the bit is set or not
                // for that row at that columns positon
                if((i & (1<<j)) !=0){
                    value = value + nums[j];
                    count++;
                }
            }
            System.out.println(value);
        }
        System.out.println("Count: " + count + " array size " + size);
    }
    
    public static int memoization_LIS(int index, int[] nums, int n, int prev_ind, int[][] dp){
        // Base Case
        if(index == n){
            return 0; // no element in the array
        }
        if(dp[index][index+1] != 0){
            return dp[index][index+1];
        }
        // Not Take
        int len = 0 + memoization_LIS(index +1,nums, n, 
        prev_ind,dp);
        // Take
        if(prev_ind == -1 || nums[index] > nums[prev_ind] ){
            len = Math.max(len,1 + memoization_LIS(index +1,nums, n, index,dp));
        }
        return dp[index][index +1] =  len;
    }
    public static int recursion_LIS(int index, int[] nums, int n, int prev_ind){
        // Base Case
        if(index == n){
            return 0; // no element in the array
        }

        // Not Take
        int len = 0 + recursion_LIS(index +1,nums, n, 
        prev_ind);
        // Take
        if(prev_ind == -1 || nums[index] > nums[prev_ind] ){
            len = Math.max(len,1 + recursion_LIS(index +1,nums, n, index));
        }
        return len;
    }

    // Longest Increasing Subsequence
    static public void lengthOfLIS(int[] nums) {
        int size = nums.length;
        // brute_LIS(nums, size);

        // System.out.println(recursion_LIS(0, nums, size, -1));

        // for memozation
        int[][] dp = new int[nums.length][nums.length+1];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        System.out.println(memoization_LIS(0, nums, size, -1,dp));

        // return 10;
    }

    public static void main(String[] args) {
        // int[] nums = { 7, 5, 1 };
        // int n = 44;
        // System.out.println(climbStairs(n));
        int []  nums = {10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);

    }
}