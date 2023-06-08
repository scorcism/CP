import java.util.*;

public class LeetCode {

    public static void main(String[] args) {

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
