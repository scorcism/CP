import java.util.Arrays;

public class Day16 {

    // String - II
    // commit template -> tuf-day16-questionName
    public static void main(String[] args) {

    }

    // 38. Count and Say
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String s = "11";
        for (int i = 3; i <= n; i++) {
            String t = "";
            s = s + "$";
            int c = 1;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(j - 1)) {
                    t = t + Integer.toString(c);
                    t = t + s.charAt(j - 1);
                    c = 1;
                } else {
                    c++;
                }
            }
            s = t;
        }
        return s;
    }

    // 242. Valid Anagram
    public boolean isAnagram(String s, String t) {
        if (t.length() > s.length() || s.length() > t.length()) {
            return false;
        }
        char[] char_array = new char[26];

        for (int i = 0; i < s.length(); i++) {
            char_array[s.charAt(i) - 'a']++;
            char_array[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < char_array.length; i++) {
            if (char_array[i] > 0) {
                return false;
            }
        }
        return true;
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
