import java.util.*;

public class Day11 {

    // Day 11: Binary Search
    // commit template -> tuf-day11-question name
    public static void main(String[] args) {

        // getNthRoot(3, 27);
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
