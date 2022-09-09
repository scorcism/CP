import java.util.*;

public class ArraysQuestions {
    public static void main(String[] args) {
        // int[] array = {1,2,3,4,5,6};
        // int[] array2 = {7,1,5,3,6,4};
        // int[] array3 = {1,2,3};
        // int[] array4 = {1,2,3,4};
        // int[] array5 = {-2,1,-3,4,-1,2,1,-5,4};
        // int[] array6 = {-1};
        // System.out.println(Arrays.toString(twoSum(array, 9)));
        // System.out.println(maxProfitM1(array2));
        // System.out.println(maxProfitM2(array2));
        // containsDuplicate(array3);
        // System.out.println(Arrays.toString(productExceptSelf(array4)));\
        // System.out.println(maxSubArray(array6));
    }

    // Two sum
    public static int[] twoSum(int[] arr, int target) {
        // Here we will be using a hash map
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (hm.containsKey(diff)) {
                return new int[] { hm.get(diff), i };
            } else {
                hm.put(arr[i], i);
            }
        }
        return new int[] { 0, 0 };
    }

    // Q:121
    // Best time to buy stock
    // Brute force
    // Method 1
    // BUGGY
    public static int maxProfitM1(int[] prices) {
        int maxProfit = 0;
        int localMaxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1 + i; j < prices.length; j++) {

                if (prices[j] > localMaxProfit) {
                    localMaxProfit = prices[j];
                }
            }

            if (maxProfit < localMaxProfit) {
                maxProfit = localMaxProfit;
            }

        }
        return maxProfit;
    }

    // Method 2
    public static int maxProfitM2(int[] prices) {
        // Assuming 1st element in the lowest
        int buy = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            // setting the buy value to the smallest element
            if (buy > prices[i]) {
                buy = prices[i];

                // Buy is the smallest value and prices[i] we are assuming that it is greater
                // then by form the above condition.
            } else if (prices[i] - buy > maxProfit) {
                maxProfit = prices[i] - buy;
            }
        }
        return maxProfit;
    }

    // Optimized
    public static int maxProfitM3(int[] prices) {
        int buyS = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            // Getting the min buy value
            buyS = Math.min(buyS, prices[i]);
            // Getting the local profit
            int profit = prices[i] - buyS;
            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit;
    }

    // Q: 217
    // Using hashset to check
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    // 238. Product of Array Except Self
    public static int[] productExceptSelf(int[] nums) {
        int[] b = new int[nums.length];

        int mul = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    mul = mul * nums[j];
                }
            }

            b[i] = mul;
            mul = 1;
        }
        return b;
    }

    // Optimized way
    public static int[] productExceptSelfM2(int[] nums) {

        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix = prefix * nums[i];
        }

        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * postfix;
            postfix = postfix * nums[i];
        }

        return result;
    }

    // 53. Maximum Subarray
    public static int maxSubArray(int[] nums) {

        int minSum = 0;
        // The min value is there to check for if the first element is -1
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            minSum = minSum + nums[i];

            if (maxSum < minSum) {
                maxSum = minSum;
            }
            if (minSum < 0) {
                minSum = 0;
            }

        }
        return maxSum;
    }

    // DP Question
    // 152. Maximum Product Subarray
    // Given an integer array nums, find a contiguous non-empty subarray within the
    // array
    // that has the largest product, and return the product.
    public static int maxProduct(int[] nums) {
        int currMax = 1;
        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            currMax = currMax * nums[i];

            if (currMax < 0) {
                currMax = 1;
            }
            if (currMax >= max) {
                max = currMax;
            }
        }
        return max;
    }

    // 33. Search in Rotated Sorted Array
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                return mid;
            }

            // Left sorted Portion
            if (nums[left] <= nums[mid]) {
                if (target > nums[mid]) {
                    left = mid + 1;
                } else if (target <= nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // In right sorted Portion
            else {
                if (target < nums[mid]) {
                    right = mid - 1;
                } else if (target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }

    // 153. Find Minimum in Rotated Sorted Array
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int res = nums[0];
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[left] < nums[right]) {
                res = Math.min(res, nums[left]);
                break;
            }

            res = Math.min(res, nums[mid]);

            if (nums[mid] >= nums[left]) {
                // search is right
                left = mid + 1;
            } else {
                // search in left
                right = mid - 1;
            }
        }

        return res;

    }

    // 153. Find Minimum in Rotated Sorted Array
    // Tech 2
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int midpoint = left + (right - left) / 2;

            if (nums[midpoint] > nums[midpoint - 1]) {
                return nums[midpoint];
            } else if (nums[left] <= nums[midpoint] && nums[midpoint] > nums[right]) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }

        return nums[left];
    }

    // 167. Two Sum II - Input Array Is Sorted
    // Using 2 Pointer method
    public static int[] twoSum2(int[] numbers, int target) {
        // a pointer is used to check the starting element
        // b pointer is used to check the end elment
        //
        int a_pointer = 0;
        int b_pointer = numbers.length - 1;

        while (a_pointer <= b_pointer) {
            int sum = numbers[a_pointer] + numbers[b_pointer];
            if (sum > target) {
                b_pointer = b_pointer - 1;
            } else if (sum < target) {
                a_pointer = a_pointer + 1;
            } else {
                return new int[] { a_pointer + 1, b_pointer + 1 };
            }
        }
        return new int[] { a_pointer + 1, b_pointer };
    }

    // 15. 3Sum
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i >= 0 && nums[i] != nums[i - 1]) {

                // Now here we will use two sum two
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int threeSum = nums[i] + nums[left] + nums[right];
                    if (threeSum > 0) {
                        // Move the rigth one
                        right--;
                    } else if (threeSum < 0) {
                        // Move the left pointer
                        left++;
                    } else {
                        // found both the elements
                        list.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        // If next elements are also same
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                    }
                }
            }
        }
        return list;
    }

    // 15. 3Sum
    // Method 2
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i >= 0 && nums[i] != nums[i + 1]) {

                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {

                    if (nums[i] + nums[left] + nums[right] < 0) {
                        left ++;
                    } else if (nums[i] + nums[left] + nums[right] > 0) {
                        right--;
                    } else {
                        list.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1]) 
                            right--;
                        
                        right--;left++;
                    }

                }
            }

        }
        return list;
    }
    // 11. Container With Most Water
    // Using 2 pointers method
    public static int maxArea(int[] height) {
        int result = 0;
        int l = 0;
        int r = height.length -1 ;
        
        while(l < r){
            int area = ( r - l ) * Math.min(height[l],height[r]);
            result = Math.max(result,area);

            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return result;
    }
}