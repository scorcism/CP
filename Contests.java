import java.util.*;

public class Contests {

    public static void main(String[] args) {
        // int[] n = {0,1,7,4,4,5};
        // System.out.println(countFairPairs(n, 3, 6));

        // int[] n1= {7,52,2,4};
        // int[] n2 = {5,14,13,8,12};
        // System.out.println(findTheArrayConcVal(n3));
        // System.out.println(findTheArrayConcVal(n2));
        // int[][] nums1 = { { 1, 2 }, { 2, 3 }, { 4, 5 } };
        // int[][] nums2 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };

        // System.out.println();

        // String[] words = {"hey","aeo","mu","ooo","artro"};
        // System.out.println(vowelStrings(words, 1, 4));
    }

    /*
     * Input: nums = [2,-1,0,1,-3,3,-3]
     * Output: 6
     * Explanation: We can rearrange the array into nums = [2,3,1,-1,-3,0,-3].
     * prefix = [2,5,6,5,2,2,-1], so the score is 6.
     * It can be shown that 6 is the maximum score we can obtain.
    */
    public int maxScore(int[] nums) {

        
    }

    /*
     * Input: words = ["hey","aeo","mu","ooo","artro"], left = 1, right = 4
     * Output: 3
     * Explanation:
     * - "aeo" is a vowel string because it starts with 'a' and ends with 'o'.
     * - "mu" is not a vowel string because it does not start with a vowel.
     * - "ooo" is a vowel string because it starts with 'o' and ends with 'o'.
     * - "artro" is a vowel string because it starts with 'a' and ends with 'o'.
     * The number of vowel strings in the mentioned range is 3.
     */

    public static int vowelStrings(String[] words, int left, int right) {
        int count = 0;

        for (int i = left; i <= right; i++) {
            if (isWordVovel(words[i])) {
                count++;
            }
        }

        return count;
    }

    private static boolean isWordVovel(String string) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int n = string.length();
        if (set.contains(string.charAt(0)) && set.contains(string.charAt(n - 1))) {
            return true;
        }
        return false;
    }

    private static boolean isWordVovel2(String string) {
        System.out.println("word " + string);
        char[] vovels = { 'a', 'e', 'i', 'o', 'u' };
        int n = string.length();
        System.out.println("string 0 " + string.charAt(0) + " string(n-1) " + string.charAt(n - 1));
        for (int i = 0; i < vovels.length; i++) {
            if (string.charAt(0) == vovels[i]) {
                System.out
                        .println("Inside 1st if string 0 " + string.charAt(0) + " string(n-1) " + string.charAt(n - 1));
                for (int j = n - 1; j >= 0; j--) {
                    if (string.charAt(n - 1) == vovels[j]) {
                        System.out.println(
                                "inside 2nd If  string 0" + string.charAt(0) + " string(n-1) " + string.charAt(n - 1));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static long findTheArrayConcVal(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        long ans = 0;

        while (start < end) {
            int first = nums[start++];
            int last = nums[end--];

            String first_s = Integer.toString(first);
            String last_s = Integer.toString(last);

            String concat_string = first_s + last_s;

            int newNum = Integer.parseInt(concat_string);
            System.out.println("New Num:" + newNum);
            ans = ans + newNum;
        }
        // System.out.println(start + " " +end);

        if (start == end) {
            ans = ans + nums[start];
        }
        return ans;
    }

    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i < j) {
                    int index_sum = nums[i] + nums[j];
                    if (index_sum >= lower && index_sum <= upper) {
                        // System.out.println(i + " "+j);
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

}
