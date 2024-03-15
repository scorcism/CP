class Solution {
    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[] { 1, 1, 0, 0, 0, 1, 0, 1 }, 2));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int localC = 0;
            int end = 0;
            while (start <= end) {
                localC += nums[end];
                while (localC == goal) {
                    count++;
                    localC += nums[end];
                }
                if (localC > goal) {
                    start++;
                }
                end++;
            }
        }
        return count;
    }

}