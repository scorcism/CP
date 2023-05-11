
import java.util.*;

public class Day3 {

    // commit syntax -> tuf-day3-Questionname
    public static void main(String[] args) {

    }

    

    public List<Integer> majorityElementII1(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        // Brute Force
        // ans can have only 2 elements
        for (int i = 0; i < nums.length; i++) {
            // check if the current is not already added or taken
            if (ans.size() == 0 || ans.get(0) != nums[i]) {
                int count = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == nums[i]) {
                        count++;
                    }
                }
                if (count > nums.length / 3) {
                    ans.add(nums[i]);
                }
            }
            if (ans.size() == 2) {
                break;
            }
        }

        return ans;
    }

    public List<Integer> majorityElementII2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        // Hashing
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.get(n) == (nums.length / 3) + 1) {
                ans.add(n);
            }
            if (ans.size() == 2)
                break;
        }

        return ans;
    }

    public List<Integer> majorityElementII3(int[] nums) {
        // same like moore
        // but as ele should be greater then n/3 measn each ele count should be > 3
        // means 4 so we can only has 2 such solutions in any case
        List<Integer> ans = new ArrayList<>();

        int count1 = 0;
        int count2 = 0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

        for (int c : nums) {
            if (count1 == 0 && element2 != c) {
                element1 = c;
                count1 = 1;
            } else if (count2 == 0 && element1 != c) {
                element2 = c;
                count2 = 1;
            } else if (c == element1) {
                count1++;
            } else if (c == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        // at thsi point we got the answer
        // now we need to verify these, if these are the two or not
        count1 = 0;
        count2 = 0;

        for (int c : nums) {
            if (c == element1) {
                count1++;
            } else if (c == element2) {
                count2++;
            }
        }
        int min = nums.length / 3;
        if (count1 > min) {
            ans.add(element1);
        }
        if (count2 > min) {
            ans.add(element2);
        }
        return ans;
    }

    public int majorityElement2(int[] nums) {
        // Hashing
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int c : nums) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (hash.get(nums[i]) > hash.size() / 2) {
                return nums[i];
            }
        }
        return -1;
    }

    public int majorityElement3(int[] nums) {
        // Moore's Algo
        int element = 0;
        int count = 0;
        for (int c : nums) {
            if (count == 0) {
                element = c;
                count = 1;
            } else if (c == element) {
                count++;
            } else
                count--;

        }

        return element;
    }

    public double myPow(double x, int n) {
        // using binary exponentiation a^b
        // not working for - exponenti
        double ans = 1.0;
        long tmpn = n;
        if (n < 0) {
            tmpn = (-1) * tmpn;
        }

        while (tmpn > 0) {
            if ((tmpn & 1) == 1) {
                ans = x * ans;
            }
            x = x * x;
            tmpn >>= 1;
        }
        if (n < 0) {
            ans = 1 / ans;
        }
        return ans;
    }

    public boolean searchMatrix3(int[][] matrix, int target) {
        // squeezing the matrix
        int n = matrix.length;
        int m = matrix[0].length;

        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public boolean searchMatrix4(int[][] matrix, int target) {
        //
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = (n * m) - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // get the element at mid
            int eleAtMid = matrix[mid / m][mid % m];
            if (eleAtMid == target) {
                return true;
            } else if (eleAtMid < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

}
