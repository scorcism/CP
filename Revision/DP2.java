import java.util.*;

public class DP2 {
    public static void main(String[] args) {

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