import java.util.*;

public class KMP {
    public static void main(String[] args) {
        /*
         * Let's break down each method step by step.
         * 
         * The computeLPSArray method computes the Longest Proper Prefix Suffix (LPS)
         * array for the pattern string, which is an array of integers that stores the
         * lengths of the longest proper prefix which is also a suffix for each prefix
         * of the pattern. For example, if the pattern is "ABABCABAB", the LPS array is
         * [0,0,1,2,0,1,2,3,4].
         * 
         * Here's how the method works:
         * 
         * Create an integer array lps of length pattern.length().
         * Initialize two variables i and j to 1 and 0 respectively, and set lps[0] to
         * 0.
         * While i is less than the length of the pattern:
         * a. If the character at index i of the pattern is the same as the character at
         * index j, increment j by 1, set lps[i] to j, and increment i by 1.
         * b. If the characters are not equal:
         * i. If j is not 0, set j to lps[j - 1].
         * ii. Otherwise, set lps[i] to 0 and increment i by 1.
         * Return the lps array.
         * The KMP method uses the LPS array computed by the computeLPSArray method to
         * find all occurrences of the pattern string in the text string. It works as
         * follows:
         * 
         * Compute the LPS array for the pattern string using the computeLPSArray
         * method.
         * Initialize two variables i and j to 0.
         * Create an empty list matches to store the indices of matches.
         * While i is less than the length of the text:
         * a. If the character at index j of the pattern is the same as the character at
         * index i of the text, increment ` j by 1 andiby 1. b. Ifjis equal to the
         * length of the pattern, a match has been found. Addi - jto thematcheslist,
         * which is the starting index of the match in the text, and updatejtolps[j -
         * 1], which is the length of the longest proper prefix which is also a suffix
         * of the current pattern. c. If the characters are not equal: i. If jis not 0,
         * updatejtolps[j - 1]. ii. Otherwise, increment iby 1. 5. Return thematches`
         * list containing the starting indices of all matches.
         * 
         * Overall, the KMP algorithm is an efficient algorithm for string pattern
         * matching with a time complexity of O(n + m), where n is the length of the
         * text and m is the length of the pattern. It works by precomputing the LPS
         * array to avoid unnecessary comparisons and backtracking during pattern
         * matching.
         */
    }

    public static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int i = 1, j = 0;
        lps[0] = 0;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static List<Integer> KMP(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        int i = 0, j = 0;
        List<Integer> matches = new ArrayList<>();
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == pattern.length()) {
                matches.add(i - j);
                j = lps[j - 1];
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return matches;
    }

}
