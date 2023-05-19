import java.util.*;

public class Day11 {

    // Day 11: Binary Search
    // commit template -> tuf-day11-question name
    public static void main(String[] args) {

        // getNthRoot(3, 27);
    }

    // Matrix Median
    public int findMedian(int[][] arr) {
        int low = 1;
        int high = (int) 1e9;
        int n = arr.length;
        int m = arr[0].length;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            // getting all the values from the matrix which are less then mid
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += countSmallerThanOrEqualToMid(arr[i], m);
            }
            if (count <= (n * m) / 2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int countSmallerThanOrEqualToMid(int[] row, int m) {
        int l = 0;
        int h = row.length - 1;
        while (l <= h) {
            int mid = (l + h) >> 1;
            if (row[mid] <= mid) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }

    // The N-th root of an integer
    private static double multiply(double number, int n) {
        double ans = 1.0;
        for (int i = 1; i <= n; i++) {
            ans = ans * number;
        }
        return ans;
    }

    private static void getNthRoot(int n, int m) {
        double low = 1;
        double high = m;
        double eps = 1e-3;

        while ((high - low) > eps) {
            double mid = (low + high) / 2.0;
            if (multiply(mid, n) < m) {
                low = mid;
            } else {
                high = mid;
            }
        }

        System.out.println(n + "th root of " + m + " is " + (low));

    }

}
