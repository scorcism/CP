import java.util.*;

public class LeetCode {

    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }

        int i = 0;
        int m = s.length();
        int n = t.length();

        for (int j = 0; j < t.length(); j++) {
            if (i < m && s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }

        return i == m;
    }

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                /*
                 * Suppose string is
                 * s = abcdedczba
                 * z is not require so we use two
                 * pointer i = 0 j = s.length()-1
                 * the character mis-matched at
                 * c - 2;
                 * z - 7
                 * so we will check from 2 to 7 and from 2 to 6
                 */
                return isPallindrome(s, i + 1, j) || isPallindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPallindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isLongPressedName(String a, String b) {

        int i = 0;
        int m = a.length();
        int n = b.length();

        for (int j = 0; j < n; j++) {
            if (i < m && a.charAt(i) == b.charAt(j)) {
                ++i;
            } else if (j == 0 || b.charAt(j) != b.charAt(j - 1)) {
                return false;
            }
        }
        return i == m;

    }

    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int n : arr) {
            if (set.contains(n * 2)) {
                return true;
            } else if (n % 2 == 0) { // if the number is even means, we can divide this number by 2 to get a number
                if (set.contains(n / 2)) {
                    return true;
                }
            }
            set.add(n);
        }
        return false;
    }

    public boolean isIsomorphic(String s, String t) {

        int[] smap = new int[256];
        int[] tmap = new int[256];
        Arrays.fill(smap, -1);
        Arrays.fill(tmap, -1);
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (smap[c1] == -1 && tmap[c2] == -1) {
                smap[c1] = c2;
                tmap[c2] = c1;
            } else if (smap[c1] != c2 && tmap[c2] != c1) {
                return false;
            }
        }
        return true;
    }

    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countNegatives2(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            // do bs in each row
            int low = 0;
            int high = row.length - 1;

            while (low <= high) {
                int mid = low + ((high - low) >> 1);
                // get the first index of <0 ele o the rest of that will be easy to get as the
                // 1st index to n will alwasy have -v1
                if (row[mid] < 0) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            count += (grid[0].length - low);

        }

        return count;
    }
}
