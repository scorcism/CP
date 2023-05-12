
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day4 {

    // Commit template -> tuf-day4-QuestionName
    public static void main(String[] args) {

    }

    // 3 Sum
    public List<List<Integer>> threeSum1(int[] nums) {
        // Brute Force
        // N^3
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                    }
                    if (temp.size() != 0)
                        ans.add(temp);
                }
            }

        }
        // ans.add(new ArrayList<>(set));
        return ans;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        // better
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third_ele = -1 * (nums[i] + nums[j]);
                if (set.contains(third_ele)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[third_ele]);
                    Collections.sort(temp);
                    set.addAll(temp);
                }
            }
            // ans.addAll(new ArrayList<Integer>(set));
        }
        return ans;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        // using 1 fix and 2 pointer
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    // found the answer
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
            }

        }
        ans.addAll(set);
        return ans;
    }

    public List<List<Integer>> threeSum4(int[] nums) {
        // using 1 fix and 2 pointer
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1;
            int high = n - 1;
            int sum = 0 - nums[i];
            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    set.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                    while (low < high && nums[low] == nums[low - 1]) {
                        low++;
                    }
                    while (low < high && nums[high] == nums[high + 1]) {
                        high--;
                    }
                } else if (nums[low] + nums[high] < sum) {
                    low++;
                } else {
                    high++;
                }

            }
        }
        ans.addAll(set);
        return ans;
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
