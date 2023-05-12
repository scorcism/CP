
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
        // int[] arr = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        // System.out.println(longestConsecutive1(arr));

    }

    public int (String s) {
        // int length = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            map.put(s.charAt(right), right);
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }

    // Number of Subarrays with xor K
    static int subarraysWithSumK(ArrayList<Integer> arr, int k) {
        int xr = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(xr, 1);
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            xr = xr ^ arr.get(i);

            // k
            int x = xr ^ k;
            count += map.getOrDefault(x, 0);
            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }
        return count;
    }

    // Largest subarray with 0 sum
    static int maxLen1(int arr[], int n) {
        // target = 0
        // O(n^3)
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k < j; k++) {
                    sum += arr[k];
                }
                if (sum == 0) {
                    max = Math.max(j - i + 1, max);
                }
            }
        }
        return max;
    }

    static int maxLen2(int arr[], int n) {
        // target = 0
        // O(n^2)
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
            }
            if (sum == 0) {
                max = Math.max(j - i + 1, max);
            }
        }
        return max;
    }

    static int maxLen3(int arr[], int n) {
        // target = 0
        // O(n* long n)
        // O(n)
        int t = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0; // maintain global sum
        int largest = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == t) {
                largest = Math.max(largest, i + 1);
            }
            int remaining = sum - t;
            if (map.containsKey(remaining)) {
                int len = i - map.get(remaining);
                largest = Math.max(largest, len);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return largest;
    }

    static int maxLen4(int arr[], int n) {
        int largest = 0;
        int left = 0;
        int right = 0;
        long sum = arr[0];
        int target = 0;
        while (right < n) {

            while (left <= right && sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                largest = Math.max(largest, right - left + 1);
            }

            right++; // coz we need to add next right
            if (right < n - 1) {
                sum += arr[right];
            }
        }

        return largest;
    }

    public static int longestConsecutive1(int[] nums) {
        int longest = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int count = 1;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == x + 1) {
                    // System.out.println("x: " + x);
                    x = x + 1;
                    count++;
                    if (j > 0) {
                        j = 0;
                    }
                }
            }
            // System.out.println(count + " count");
            longest = Math.max(count, longest);
        }
        if (longest == Integer.MIN_VALUE) {
            return 0;
        }

        return longest;
    }

    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }

        int largest = 1;
        Arrays.sort(nums);

        int currentCount = 0;
        int previousEle = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 == previousEle) {
                previousEle = nums[i];
                currentCount++;
            } else if (nums[i] != previousEle) {
                currentCount = 1;
                previousEle = nums[i];
            }
            largest = Math.max(largest, currentCount);
        }

        return largest;
    }

    public int longestConsecutive3(int[] nums) {

        if (nums.length == 0 || nums == null) {
            return 0;
        }

        int largest = 0;

        HashSet<Integer> set = new HashSet<>();
        for (int c : nums) {
            set.add(c);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int count = 0;
                int x = nums[i];
                while (set.contains(x + 1)) {
                    count += 1;
                    x += 1;
                }
                largest = Math.max(largest, count);
            }
        }

        return largest;
    }

    public List<List<Integer>> fourSum1(int[] nums, int target) {
        // Brute
        // using 4 loops
        // easy
        List<List<Integer>> ans = new ArrayList<>();
        return ans;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        // Better
        // Using Hashing
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                HashSet<Integer> s = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    long fourthOne = target - sum;
                    if (s.contains((int) fourthOne)) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[k], (int) fourthOne));
                    }

                    s.add(nums[k]);
                }
            }
        }
        ans.addAll(set);
        return ans;
    }

    public List<List<Integer>> fourSum3(int[] nums, int target) {
        // Better
        // Using Hashing
        int n = nums.length;
        Arrays.sort(nums);// to get sorted answers
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                // making two pointer
                int low = j + 1;
                int high = n - 1;
                long sumNeeded = target - (nums[i] + nums[j]);
                while (low < high) {
                    if (nums[low] + nums[high] == sumNeeded) {
                        // we got the sum
                        ans.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        low++;
                        high--;
                        while (low < high && nums[low] == nums[low - 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high + 1]) {
                            high--;
                        }
                    } else if (nums[low] + nums[high] < sumNeeded) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return ans;
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
