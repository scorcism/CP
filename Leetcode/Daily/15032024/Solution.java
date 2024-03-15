import java.util.Arrays;

class Solution {

    public static int[] productExceptSelf(int[] nums) {
        int ans[] = new int[nums.length];
        Arrays.fill(ans, 1);
        int prefix = 1;

        for (int i = 0; i < nums.length; i++) {
            ans[i] = prefix;
            prefix = prefix * nums[i];
        }
        System.out.println(Arrays.toString(ans));
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = postfix * ans[i];
            postfix = postfix * nums[i];
        }
        System.out.println(Arrays.toString(ans));

        return ans;
    }
}