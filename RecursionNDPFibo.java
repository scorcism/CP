import java.util.*;

class RecursionNDPFibo {
    
    // DP - Tabulation
    public static int fibo2(int n, int[] dp){
        
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[0];
        
    }

    // DP - Memoization
    public static int fibo(int n, int[] dp){
        if(n<=1){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = (fibo(n-1, dp) + fibo(n-2, dp));

    }
    
    public static int recursion(int n){
        if(n<=1){
            return n;
        }
        return recursion(n-1) + recursion(n-2);
    }
    
    public static void main(String[] args) {
        int n = 135;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fibo(n,dp));
    }    
}
