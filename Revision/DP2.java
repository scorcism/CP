import java.util.*;

public class DP2 {
    public static void main(String[] args) {
        System.out.println(ninjaTraining(3, new int[][] { { 1, 50, 10 }, { 20, 100, 2
        } }));
    }

    public static int ninjaTraining(int n, int points[][]) {
        // return nt1(points.length - 1, points, 3);
        int[][] dp = new int[n][4];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        // return nt2(points.length - 1, points, 3, dp);
        return nt3(n, points);
    }

    static int nt1(int n, int[][] points, int last) {
        if (n == 0) {
            int maxi = 0;
            for (int i = 0; i < points.length; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, points[0][i]);
                }
            }
            return maxi;
        }

        int maxi = 0;
        for (int i = 0; i < points.length; i++) {
            if (i != last) {
                int point = points[n][i] + nt1(n - 1, points, i);
                maxi = Math.max(point, maxi);
            }
        }
        return maxi;
    }

    static int nt2(int n, int[][] points, int last, int[][] dp) {
        if (n == 0) {
            int maxi = 0;
            for (int i = 0; i < points.length; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, points[0][i]);
                }
            }
            return maxi;
        }

        if (dp[n][last] != -1) {
            return dp[n][last];
        }

        int maxi = 0;
        for (int i = 0; i < points.length; i++) {
            if (i != last) {
                int point = points[n][i] + nt2(n - 1, points, i, dp);
                maxi = Math.max(point, maxi);
            }
        }
        return dp[n][last] = maxi;
    }


    public void getMin(int[] stones) {

    }

    private static int getMinHelper1(int[] nums, int n) {
        if (n == 0) {
            return 0;
        }
        int left = getMinHelper1(nums, n - 1) + Math.abs(nums[n] - nums[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = getMinHelper1(nums, n - 2) + Math.abs(nums[n] - nums[n - 2]);
        }
        return Math.min(left, right);
    }

    private static int getMinHelper2(int[] nums, int n) {
        int[] mem = new int[nums.length + 1];
        Arrays.fill(mem, -1);

        return getMinHelper2Helper(nums, n, mem);
    }

    private static int getMinHelper2Helper(int[] nums, int n, int[] mem) {
        /*
         * TC -> O(n)
         * SC -> O(n) + O(n)
         */
        if (n == 0) {
            return 0;
        }
        if (mem[n] != -1) {
            return mem[n];
        }
        int left = getMinHelper1(nums, n - 1) + Math.abs(nums[i] - nums[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = getMinHelper1(nums, n - 2) + Math.abs(nums[i] - nums[n - 2]);
        }

        return mem[n] = Math.min(left, right);
    }

    private static int getMinHelper3(int[] nums, int n) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int fs = dp[i - 1] + Math.abs(nums[i] - nums[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = dp[i - 2] + Math.abs(nums[i] - nums[i - 2]);
            }
            dp[i] = Math.min(fs, ss);
        }
        return dp[n - 1];
    }

    private static int getMinHelper4(int[] nums, int n) {
        int prev = 0;
        int pprev = 0;
        for (int i = 1; i < n; i++) {
            int fs = prev + Math.abs(nums[i] - nums[i - 1]);
            int ss = Integer.MAX_VALUE;
            if (i > 1) {
                ss = pprev = Math.abs(nums[i] - nums[i - 2]);
            }
            int curr = Math.min(fs, ss);
            pprev = prev;
            prev = curr;
        }
        return prev;
    }
}