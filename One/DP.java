public class DP {

    public static void main(String[] args) {

        // int n = 18;
        // int[] coins = { 7, 5, 1 };
        // int[] dp = new int[n + 1];
        // dp[0] = 0;
        // System.out.println(minCoins(n, coins, dp));

        System.out.println();


    }

    static int rodCut(int[] prices , int n ){
        int[] dp = new int[n+1];

        for(int i = 1; i< n ; i++){
            // eg for 4 
            // i = 4;
            // j will run from 0 to 4
            for(int j = 0; j<i; j++){
                dp[i] = Math.max(prices[j], dp[i-j-1]);
            }
        }
        return dp[n];
    }

    static int editDistance(String s1, String s2){
        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m+1][n+1];

        for(int i = 0; i<= m; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j<= n ; j++){
            dp[0][j] = j;
        }

        for(int i = 1; i<= m ; i++){
            for(int j = 1; j<= n ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    //  if both the characters are matching then write the digonal one 
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    // if not matching get the minimum from the top digonal left and add 1 to it and write it
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    static int minCoins(int n, int[] coins, int[] dp) {
        if (n == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if (n - coins[i] >= 0) {

                int subAns = 0;

                if (dp[n - coins[i]] != -1) {
                    subAns = dp[n - coins[i]];
                } else {
                    subAns = minCoins(n - coins[i], coins, dp);
                }

                if (subAns + 1 < ans && subAns != Integer.MAX_VALUE) {
                    ans = subAns + 1;
                }
            }
        }
        return dp[n] = ans;
    }

}
