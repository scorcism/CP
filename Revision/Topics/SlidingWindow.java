import java.util.*;

public class SlidingWindow {

    public static void main(String[] args) {
        FixedWindow fw = new FixedWindow();

    }
}

class FixedWindow {


    
    // 1876. Substrings of Size Three with Distinct Characters
    public int countGoodSubstrings(String s) {
        int k = 3;
        int count_occurance = 0;

        int i = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (map.size() == k) {
                    count_occurance++;
                }
                char ith = s.charAt(i);
                if (map.containsKey(ith)) {
                    map.put(ith, map.get(ith) - 1);
                    if (map.get(ith) < 1) {
                        map.remove(ith);
                    }
                }
                i++;
                j++;
            }
        }

        return count_occurance;
    }
}

class EasyProblems {

    public int minimumRecolors(String blocks, int k) {

        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int wcount = 0;

        while (j < blocks.length()) {
            if (blocks.charAt(j) == 'W') {
                wcount++;
            }

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                min = Math.min(min, wcount);
                if (blocks.charAt(i) == 'W') {
                    wcount--;
                }
                i++;
                j++;
            }
        }
        return wcount;
    }

    static boolean isDivisible(int num, int n) {
        return (num % n == 0) ? true : false;
    }

    // 1763. Longest Nice Substring
    public String longestNiceSubstring(String s) {
        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                String currString = s.substring(i, j);
                if (currString.length() > longest.length() && isNice(currString)) {
                    longest = currString;
                }

            }
        }

        return longest;
    }

    static boolean isNice(String s) {
        Set<Character> u = new HashSet<>();
        char[] str = s.toCharArray();
        for (char c : str) {
            u.add(c);
        }
        for (char c : u) {
            if (!u.contains(Character.toLowerCase(c)) || !u.contains(Character.toUpperCase(c))) {
                return false;
            }
        }
        return true;
    }

    // 1876. Substrings of Size Three with Distinct Characters
    public int countGoodSubstrings(String s) {

        int low = 0;
        int high = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int count = 0;
        int k = 3;

        while (high < s.length()) {
            map.put(s.charAt(high), map.getOrDefault(s.charAt(high), 0) + 1);
            if (high - low + 1 < k) {
                high++;

            } else if (high - low + 1 == k) {
                if (map.size() == 3) {
                    count++;
                }

                if (map.containsKey(s.charAt(low))) {
                    map.put(s.charAt(low), map.get(s.charAt(low)) - 1);
                    if (map.get(s.charAt(low)) < 1) {
                        map.remove(s.charAt(low));
                    }
                }
                low++;
                high++;
            }
        }
        return count;
    }

}