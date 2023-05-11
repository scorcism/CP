
import java.util.*;

public class Day3 {

    // commit syntax -> tuf-day3-Questionname
    public static void main(String[] args) {

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
