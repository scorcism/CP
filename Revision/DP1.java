import java.util.*;

public class DP1 {
    public static void main(String[] args) {

        System.out.println(fibo(8));
        System.out.println(getFiboTabu(8));
        System.out.println(getFiboOpt(8));
    }

    private static long fibo(int n) {
        long[] memo = new long[n + 1];
        Arrays.fill(memo, -1);

        return getFiboMemo(n, memo);
    }

    private static long getFiboMemo(int n, long[] memo) {
        /*
         * TC -> O(n)
         * SC -> O(n)[memo table] + O(n)[stack space]
         */
        if (n <= 1) {
            return n;
        }
        if (memo[n] != -1) {
            return memo[n];
        }

        return memo[n] = getFiboMemo(n - 1, memo) + getFiboMemo(n - 2, memo);
    }

    private static long getFiboTabu(int n) {
        /*
         * TC -> O(n)
         * SC -> O(n)
         */
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    private static int getFiboOpt(int n) {
        /*
         * TC -> O(n)
         * SC -> O(1)
         */
        int pprev = 0;
        int prev = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev + pprev;
            pprev = prev;
            prev = curr;
        }
        return prev;
    }

}