public class Contest {
    public static void main(String[] args) {
    }
}

class SolutionWeeklyContest352 {

    // Weekly Contest 352
    public int longestAlternatingSubarray2(int[] nums, int threshold) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            if (nums[i] % 2 != 0) {
                max = 0;
            }
            if (nums[i] <= threshold) {
                if (i < nums.length && nums[i] % 2 != nums[i + 1] % 2) {
                    max++;
                }
            }
            if (max > maxLen) {
                maxLen = max;
            }
        }
        return maxLen;
    }

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxLen = 1;
        for (int l = 0; l < nums.length; l++) {

            if (nums[l] % 2 == 0) {

                for (int r = l; r < nums.length; r++) {
                    int max = 1;
                    for (int i = l; i <= r; i++) {

                        if (nums[i] <= threshold) {

                            if (i < nums.length - 1 && nums[i] % 2 != nums[i + 1] % 2) {
                                // System.out.println("In l: "+ nums[l] +" r: " + nums[i]);
                                max++;
                            }

                        }
                    }
                    maxLen = Math.max(maxLen, max);
                }
            }
        }
        return maxLen;
    }
}