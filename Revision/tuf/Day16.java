import java.util.Arrays;

public class Day16 {

    // String - II
    // commit template -> tuf-day16-questionName
    public static void main(String[] args) {

    }


    
    // 1312. Minimum Insertion Steps to Make a String Palindrome
    public int minInsertions(String s) {
        // string length - lcs(longest common subsequence)
        
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        int n = LCS(s, sb.toString());
        return s.length() - n;
    }

    private int LCS(String s, String s2) {
        int[][] dp = new int[s.length()][s2.length()];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return lcsm(s, s2, s.length() - 1, s2.length() - 1, dp);
    }

    private int lcsm(String s, String s2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + lcsm(s, s2, i - 1, j - 1, dp);
        }
        return dp[i][j] = Math.max(lcsm(s, s2, i - 1, j, dp), lcsm(s, s2, i, j - 1, dp));
    }

    // 28. Find the Index of the First Occurrence in a String
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        int i = 0;
        int j = needle.length();
        while (j <= haystack.length()) {
            if (haystack.substring(i, j).equals(needle)) {
                return i;
            }
            i++;
            j++;
        }
        return -1;
    }
}
