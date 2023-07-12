import java.util.*;

public class SlidingWindow {

    public static void main(String[] args) {
        VariableWindow vw = new VariableWindow();

    }
}

class VariableWindow {

    // 424. Longest Repeating Character Replacement - TODO
    public int characterReplacement(String s, int k) {
        int i = 0;
        int j = 0;
        int maxLen = 0;

        while (j < s.length()) {
            
        }

        return maxLen;
    }

    public int longestOnes2(int[] nums, int k) {
        int i = 0;
        int j = 0;

        for (j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                k--;
            }
            if (k < 0 && nums[i++] == 0) {
                k++;
            }
        }

        return j - i;
    }

    public int longestOnes(int[] nums, int k) {
        // Condition -> in window size j - i+1 count_zero should be == k
        int maxLen = 0;
        int count_zero = 0;
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            if (nums[j] == 0) {
                count_zero++;
            }
            if (count_zero < k) {
                j++;
            } else if (count_zero == k) {
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            } else if (count_zero > k) {
                while (count_zero > k) {
                    if (nums[i] == 0) {
                        count_zero--;
                    }
                    i++;
                }
                j++;
            }
        }

        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();

        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                maxLen = Math.max(maxLen, set.size());
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLen;
    }

}

class Tutorials {

    // Pick Toys -> 904. Fruit Into Baskets
    public int totalFruit(int[] f) {

        int maxLen = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;

        while (j < f.length) {
            map.put(f[j], map.getOrDefault(f[j], 0) + 1);

            while (map.size() > 2) {
                map.put(f[i], map.get(f[i]) - 1);
                if (map.get(f[i]) == 0) {
                    map.remove(f[i]);
                }
                i++;
            }
            if (map.size() <= 2) {
                maxLen = Math.max(maxLen, j - i + 1);
            }

            j++;

        }
        return maxLen;

    }

    public int lengthOfLongestSubstring(String s) {
        // Longest Substring Without Repeating Characters
        /*
         * Condition is given,
         * window size is asked
         * 
         */
        int maxLen = Integer.MIN_VALUE;

        int i = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {

            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            if (map.size() == j - i + 1) {
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            } else if (map.size() > j - i + 1) {
                while (map.size() < j - i + 1) {

                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);

                    if (map.get(s.charAt(i)) < 1) {
                        map.remove(s.charAt(i));
                    }

                    i++;
                }

                j++;
            }
        }
        return maxLen;
    }

    // Longest Substring With K Unique Characters
    /*
     * Condition is given (will be unique eles)
     * Window size is asked
     * k is given
     */
    int longestSubstringK(String s, int k) {
        int i = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;

        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            } else if (map.size() > k) {
                while (map.size() > k) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) < 1) {
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        return maxLen;
    }
}

class FixedWindow {

    // 2090. K Radius Subarray Averages

    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;

        int[] avg = new int[n];

        Arrays.fill(avg, -1);

        if (n < 2 * k + 1) {
            return avg;
        }

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (int i = k; i < (n - k); i++) {
            int leftIndex = i - k;
            int rightIndex = i + k;

            int sum = prefix[rightIndex + 1] - prefix[leftIndex];

            avg[i] = sum / (2 * k + 1);

        }

        return avg;
    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        long sum = 0;

        int i = 0;
        int j = 0;

        while (j < arr.length) {
            sum += arr[j];
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {

                int avg = (int) sum / k;
                if (avg >= threshold) {
                    count++;
                }

                sum -= arr[i];
                i++;
                j++;
            }
        }

        return count;
    }

    // 438. Find All Anagrams in a String
    public List<Integer> findAnagrams3(String s, String p) {

        int[] char_count = new int[26];

        for (char c : p.toCharArray()) {
            char_count[c - 'a']++;
        }
        int count = p.length();

        List<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (j < s.length()) {

            if (char_count[s.charAt(j++) - 'a']-- >= 1) {
                count--;
            }
            if (count == 0) {
                ans.add(i);
            }
            if (j - i == p.length() &&
                    char_count[s.charAt(i++) - 'a']++ >= 0) {
                count++;
            }
        }

        return ans;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int k = p.length();

        int i = 0;
        int j = 0;
        HashMap<Character, Integer> tmp = new HashMap<>();

        while (j < s.length()) {
            char jth = s.charAt(j);

            tmp.put(jth, tmp.getOrDefault(jth, 0) + 1);

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                char ith = s.charAt(i);

                if (map.equals(tmp)) {
                    ans.add(i);
                }

                if (tmp.containsKey(ith)) {
                    tmp.put(ith, tmp.get(ith) - 1);

                    if (tmp.get(ith) < 1) {
                        tmp.remove(ith);
                    }
                }

                i++;
                j++;
            }
        }

        return ans;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int k = p.length();

        for (int i = 0; i < s.length() - k + 1; i++) {
            String subs = s.substring(i, i + k);
            if (isMatch(map, subs)) {
                ans.add(i);
            }
        }

        return ans;
    }

    private static boolean isMatch(Map<Character, Integer> map, String s1) {
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        return map.equals(map2);
    }

    // 1423. Maximum Points You Can Obtain from Cards
    public int maxScore2(int[] cardPoints, int k) {
        int ksum = 0;
        for (int i = 0; i < k; i++) {
            ksum += cardPoints[i];

        }
        int best = ksum;

        for (int i = k - 1, j = cardPoints.length - 1; i >= 0; i--, j--) {
            ksum += cardPoints[j] - cardPoints[i];
            best = Math.max(best, ksum);
        }

        return best;
    }

    public int maxScore(int[] cardPoints, int k) {
        int max = 0;
        int sum = 0;

        for (int i = 0; i < cardPoints.length; i++) {
            sum += cardPoints[i];

            if (i > k - 1) {
                sum -= cardPoints[i - k];
            }

            if (i >= k - 1) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    // 643. Maximum Average Subarray I
    public double findMaxAverage2(int[] nums, int k) {

        long answer = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (i > k - 1) {
                sum -= nums[i - k];
            }

            if (i >= k - 1) {
                answer = Math.max(answer, sum);
            }
        }

        return (double) answer / k;
    }

    public double findMaxAverage(int[] nums, int k) {
        double ans = 0.0;
        int i = 0;
        int j = 0;
        double num = 0.0;
        int count = 0;
        while (j < nums.length) {

            num += nums[j];
            count++;

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                ans = Math.max(ans, num / count);

                count--;
                num -= nums[i];

                i++;
                j++;
            }
        }

        return ans;
    }

    // 1297. Maximum Number of Occurrences of a Substring
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        /*
         * TC -> ~O(N)
         * SC -> O(N)
         */
        int countUnique = 0;
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int[] count_occurance = new int[26];

        while (j < s.length()) {

            char jth = s.charAt(j++);
            count_occurance[jth - 'a']++;

            if (count_occurance[jth - 'a'] == 1) {
                countUnique++;
            }

            while ((j - i) >= minSize && (j - i) <= maxSize) {
                if (countUnique <= maxLetters) {
                    String subs = s.substring(i, j);
                    map.put(subs, map.getOrDefault(subs, 0) + 1);
                }

                char ith = s.charAt(i++);
                count_occurance[ith - 'a']--;

                if (count_occurance[ith - 'a'] == 0) {
                    countUnique--;
                }
                i++;
                j++;
            }
        }

        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return max;

    }

    // 1456. Maximum Number of Vowels in a Substring of Given Length
    public int maxVowels2(String s, int k) {
        /*
         * TC -> O(N)
         * SC -> O(5) ~ O(1)
         */

        int ans = 0;
        int i = 0;
        int j = 0;
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int count = 0;
        while (j < s.length()) {
            if (set.contains(s.charAt(j))) {
                count++;
            }

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                ans = Math.max(ans, count);

                if (set.contains(s.charAt(i))) {
                    count--;
                }
                i++;
                j++;
            }

        }
        return ans;
    }

    public int maxVowels(String s, int k) {
        /*
         * TC -> O(n)
         * SC -> O(1)
         */

        int max = Integer.MIN_VALUE;

        HashSet<Character> set = new HashSet<>();

        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        for (int i = 0; i < s.length() - k + 1; i++) {
            String sub = s.substring(i, i + k);
            max = Math.max(max, count_vovels(sub, set));
        }
        return max;
    }

    static int count_vovels(String s, HashSet<Character> set) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> findSubstring2(String s, String[] words) {

        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String ss : words) {
            map.put(ss, map.getOrDefault(ss, 0) + 1);
        }
        int k = words.length * words[0].length();
        int wlen = words[0].length();

        for (int i = 0; i < s.length() - k + 1; i++) {
            String sub = s.substring(i, i + k);
            if (isSame(sub, map, wlen)) {
                ans.add(i);
            }
        }

        return ans;
    }

    private boolean isSame(String sub, Map<String, Integer> map, int wlen) {
        Map<String, Integer> tmp = new HashMap<>();

        for (int i = 0; i < sub.length() - wlen + 1; i += wlen) {
            String seen = sub.substring(i, i + wlen);
            tmp.put(seen, tmp.getOrDefault(seen, 0) + 1);
        }
        return tmp.equals(map);

    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        int k = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (String ss : words) {
            for (char c : ss.toCharArray()) {
                k++;
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        int i = 0;
        int j = 0;
        HashMap<Character, Integer> tmpmap = new HashMap<>();
        while (j < s.length()) {
            tmpmap.put(s.charAt(j), tmpmap.getOrDefault(s.charAt(j), 0) + 1);

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (tmpmap.equals(map)) {
                    ans.add(i);
                }

                if (tmpmap.containsKey(s.charAt(i))) {
                    tmpmap.put(s.charAt(i), tmpmap.get(s.charAt(i)) - 1);
                    if (tmpmap.get(s.charAt(i)) < 1) {
                        tmpmap.remove(s.charAt(i));
                    }
                }
                i++;
                j++;
            }
        }

        return ans;
    }

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