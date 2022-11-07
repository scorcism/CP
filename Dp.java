import java.util.*;

public class Dp {

    public static int minCoins(int n, int[] nums){

        return 10;
    }



    // Tabulation
    public static int CS_solve2(int n, int[] dp){
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i<= n; i++){
            dp[i] = dp[i-1]  + dp[i-2];
        }

        return dp[n];
    }
    // Memoization
    public static int CS_solve1(int n, int[] dp){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        
        return dp[n] = CS_solve1(n-1,dp) + CS_solve1(n-2,dp);
    }

    public static int climbStairs(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        // return CS_solve1(n, dp);
        return CS_solve2(n, dp);
    }
    
    public static void main(String[] args) {
        int[] nums = {7,5,1};
        int n = 44;
        System.out.println(climbStairs(n));
    }
}