package LC;

import java.util.*;

public class Hashing {
    public static void main(String[] args) {

    }
}

class Easy {

    // 2099. Find Subsequence of Length K With the Largest Sum
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> v = new ArrayList<>();
        for(int x: nums){
            pq.add(x);
            v.add(x);
        }

        int[] ans = new int[k];

        for(int i = 0; i< nums.length-k; i++){
            v.remove(pq.remove());
        }

        for(int i = 0; i< k; i++){
            ans[i] = v.get(i);
        }
        return ans;
    }

    // 290. Word Pattern

    public boolean wordPattern5(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        // string and index
        // for pattern
        HashMap<Character, Integer> map = new HashMap<>();

        // for words
        HashMap<String, Integer> map2 = new HashMap<>();

        for (Integer i = 0; i < words.length; i++) {
            // if(!map.containsKey(pattern.charAt(i))){
            // map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), i));
            // }
            // if(!map2.containsKey(words[i])){
            // map2.put(words[i], map.getOrDefault(words[i], i));
            // }
            // if(map.containsKey(pattern.charAt(i)) && map2.containsKey(words[i])){
            // if(map.get(pattern.charAt(i)) != map2.get(words[i])){
            // return false;
            // }
            // }
            if (map.put(pattern.charAt(i), i) != map2.put(words[i], i)) {
                return false;
            }
        }
        return true;
    }

    public boolean wordPattern4(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        // string and index
        // for pattern
        HashMap<Character, Integer> map = new HashMap<>();

        // for words
        HashMap<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            // if(!map.containsKey(pattern.charAt(i))){
            // map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), i));
            // }
            // if(!map2.containsKey(words[i])){
            // map2.put(words[i], map.getOrDefault(words[i], i));
            // }
            // if(map.containsKey(pattern.charAt(i)) && map2.containsKey(words[i])){
            // if(map.get(pattern.charAt(i)) != map2.get(words[i])){
            // return false;
            // }
            // }
            if (map.put(pattern.charAt(i), i) != map2.put(words[i], i)) {
                return false;
            }
        }
        return true;
    }

    public boolean wordPattern3(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        // string and index
        // for pattern
        HashMap<Character, Integer> map = new HashMap<>();

        // for words
        HashMap<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), i));
            }
            if (!map2.containsKey(words[i])) {
                map2.put(words[i], map.getOrDefault(words[i], i));
            }
            if (map.containsKey(pattern.charAt(i)) && map2.containsKey(words[i])) {
                if (map.get(pattern.charAt(i)) != map2.get(words[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean wordPattern2(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        Map index = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i)) {
                return false;
            }
        }
        return true;
    }

    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                map.put(pattern.charAt(i), str[i]);
            } else if (map.get(pattern.charAt(i)) != str[i]) {
                return false;
            }
        }

        return true;

    }

    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        int start = 0;
        while (start < word.length()) {
            if (Character.isDigit(word.charAt(start))) {

                int end = start;
                while (end < word.length() && Character.isDigit(word.charAt(end))) {
                    end++;
                }

                while (start < end && word.charAt(start) == '0') {
                    start++;
                }

                set.add(word.substring(start, end));
                start = end;
            } else {
                start++;
            }
        }

        return set.size();
    }

    public boolean buddyStrings2(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        // If A == B, we need swap two same characters. Check is duplicated char in A.

        if (s.equals(goal)) {
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                set.add(c);
            }
            return set.size() < s.length();
        }
        // In other cases, we find index for A[i] != B[i]. There should be only 2 diffs
        // and it's our one swap.
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diff.add(i);
            }
        }
        return diff.size() == 2 && s.charAt(diff.get(0)) == goal.charAt(diff.get(1))
                && s.charAt(diff.get(1)) == goal.charAt(diff.get(0));
    }

    // Buddy Strings
    public boolean buddyStrings(String s, String goal) {
        // failed case 23
        return isSwap(s, goal);
    }

    static boolean isSwap(String s, String goal) {
        char[] s_char = s.toCharArray();
        char[] g_char = goal.toCharArray();

        for (int i = 0; i < s_char.length; i++) {
            for (int j = 1; j < s_char.length; j++) {
                swap(s_char, i, j);
                if (check_(s_char, g_char)) {
                    return true;
                }
            }
        }
        return false;
    }

    static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static boolean check_(char[] one, char[] two) {
        for (int i = 0; i < one.length; i++) {
            if (one[i] != two[i]) {
                return false;
            }
        }
        return true;
    }

    // 2423. Remove Letter To Equalize Frequency
    public boolean equalFrequency(String word) {
        // TC -> O(L+26*26)
        // Sc -> O(26) -> O(1)
        int[] char_freq = new int[26];

        for (char a : word.toCharArray()) {
            char_freq[a - 'a']++;
        }

        for (int i = 0; i < char_freq.length; i++) {
            // decrease the count of curr one and check if by decreasing the array is same
            // or not
            char_freq[i]--;
            if (checkSame(char_freq)) {
                return true;
            }
            // if by descreaing the count arrray is not same again increase it and gotfor
            // next one
            char_freq[i]++;
        }
        return false;

    }

    static boolean checkSame(int[] arr) {
        int lastcount = 0;
        for (int c : arr) {
            if (c == 0) {
                continue;
            }
            if (lastcount != 0 && c != lastcount) {
                return false;
            }
            lastcount = c;
        }
        return true;
    }
}