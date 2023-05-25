import java.util.*;

class Day15 {

    // String Part - 1
    // commit template -> tuff-day15-questionName
    public static void main(String[] args) {

    }

    // 5. Longest Palindromic Substring
    public String longestPalindrome(String s) {
        int len = s.length();

        int resLen = 0;
        String ans = "";
        int res_l = 0;
        int res_r = 0;
        for (int i = 0; i < len; i++) {
            int left = i;
            int right = i;

            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resLen) {
                    resLen = right - left + 1;
                    // ans = s.substring(left, right+1);
                    res_l = left;
                    res_r = right + 1;
                }
                left--;
                right++;
            }
            left = i;
            right = i + 1;

            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resLen) {
                    resLen = right - left + 1;
                    // ans = s.substring(left, right+1);
                    res_l = left;
                    res_r = right + 1;
                }
                left--;
                right++;
            }
        }
        return s.substring(res_l, res_r);
    }

    // Reverse Words in a String
    public String reverseWords1(String s) {
        Stack<String> stack = new Stack<>();

        for (String st : s.trim().split(" ")) {
            if (!st.isEmpty()) {
                stack.add(st);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }

        return sb.toString().trim();

    }

    public String reverseWords2(String s) {
        int i = s.length() - 1;
        String sb = "";
        while (i >= 0) {

            while (i >= 0 && s.charAt(i) == ' ')
                i--;

            int j = i;

            while (i >= 0 && s.charAt(i) != ' ')
                i--;

            if (i < 0) {
                break;
            }

            if (sb.isEmpty()) {
                sb = sb.concat(s.substring(i + 1, j + 1));
            } else {
                sb = sb.concat(" " + s.substring(i + 1, j + 1));
            }
        }
        return sb;
    }
}