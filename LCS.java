import java.util.Arrays;


public class LCS {
    
}

/* 
 * Tabulation -> Bottom-up
 * TC -> O(m*n)
 * SC -> O(m*n) + O(m+n)
 * Rules:
 * 1) Copy the base case 
 * a) Base case issue coz we cannot store dp[-1] so we do shifting of index
 * b) Every i and j will be treated as i-1 and j-1
 * c) we will use f(m,n) insted of m-1 and n-1
 * d) Base case will be if i==0 || j==0 return 0
 * e) In Tabulation
 * f) dp[0][j] = 0
 * g) dp[i][0] = 0
 * h) i = j = 0-m && 0-n
 * 2) Write down the changing paramater in opposite direction
 * a) i = 1 -> m
 * b) j = 1 -> n
 * 3) Copy the recurrace
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int dp[][] = new int[n+1][m+1];

        for(int j = 0; j<= m; j++){
            dp[0][j] = 0;
        }

        for(int i = 0; i<= n; i++){
            dp[i][0] = 0;
        }

        for(int i = 1; i<= n; i++){
            for(int j = 1; j<= m; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] =Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}


/* 
 * Base shift
 * Tabulation -> Bottom-up
 * TC -> O(m*n)
 * SC -> O(m*n) + O(m+n)
 */

 class SolutionBaseShift {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] d: dp){
            Arrays.fill(d,-1);
        }
        return lcsbaseshift(text1,text2, m, n, dp);
    }
    private int lcsbaseshift(String str1,String str2, int ind1, int ind2, int[][] dp){
        if(ind1 == 0 || ind2 ==0){
            return 0;
        }
        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }
        if(str1.charAt(ind1-1) == str2.charAt(ind2-1) ){
            return dp[ind1][ind2] = 1+ lcsbaseshift(str1,str2, ind1-1, ind2-1, dp);
        }

        return  dp[ind1][ind2] = Math.max(lcsbaseshift(str1,str2, ind1-1, ind2, dp),lcsbaseshift(str1,str2, ind1, ind2-1, dp));
    }
}


/* 
 * Memoization -> Top-Down
 * TC -> O(m*n)
 * SC -> O(m*n) + O(m+n)
 * Rules:
 * 1) 
 */
class SolutionDPMemoization {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m][n];
        for(int[] d: dp){
            Arrays.fill(d,-1);
        }

        return lcsmemo(text1,text2,m-1,n-1,dp);
    }

    private int lcsmemo(String s1, String s2, int ind1, int ind2, int[][] dp){
        if(ind1 < 0 || ind2 < 0){
            return 0;
        }
        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }

        if(s1.charAt(ind1) == s2.charAt(ind2)){
            return dp[ind1][ind2] = 1+ lcsmemo(s1,s2,ind1-1,ind2-1,dp);
        }
        return dp[ind1][ind2] = Math.max(lcsmemo(s1,s2,ind1-1,ind2,dp),lcsmemo(s1,s2,ind1,ind2-1,dp));
    }
}

// Recursion
class SolutionRecursion {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        return lcsmemo(text1,text2,m-1,n-1);
    }

    private int lcsmemo(String s1, String s2, int ind1, int ind2){
        if(ind1 < 0 || ind2 < 0){
            return 0;
        }
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            return 1+ lcsmemo(s1,s2,ind1-1,ind2-1);
        }
        return Math.max(lcsmemo(s1,s2,ind1-1,ind2),lcsmemo(s1,s2,ind1,ind2-1));
    }
}
