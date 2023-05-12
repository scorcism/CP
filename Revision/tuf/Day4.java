
import java.util.HashMap;

public class Day4 {

    // Commit template -> tuf-day4-QuestionName
    public static void main(String[] args) {

    }


    

    // Two Sum
    public int[] twoSum1(int[] nums, int target) {
        // O(N^2)
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1 + i; j < nums.length; j++) {
                if (i != j) {
                    if (nums[i] + nums[j] == target) {
                        return new int[] { i, j };
                    }
                }
            }
        }
        return new int[] { -1, -1 };
    }

    public int[] twoSum2(int[] nums, int target) {
        // O(N)
        // O(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                return new int[] { map.get(target - nums[i]), i };
            }
        }
        return new int[] { -1, -1 };
    }


}
