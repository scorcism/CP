import java.util.*;

public class SlidingWindow {

    public static void main(String[] args) {
        EasyProblems easy = new EasyProblems();
        System.out.println(easy.divisorSubstrings(430043, 2));
    }
}

class EasyProblems {

    public int divisorSubstrings(int num, int k) {

        String n = Integer.toString(num);

        int i = 0;
        int j = 0;
        int nlen = n.length();
        int count = 0;
        String sb = "";

        while (j < nlen) {
            sb += n.charAt(j);

            if (j - i + 1 < k) {
                j++;
            } 
            else if (j - i + 1 == k) {

                System.out.println(sb);
                
                if (isDivisible(num, Integer.parseInt(sb))) {
                    count++;
                }

                sb = sb.substring(i, j)

                i++;
                j++;
            }
        }
        return count;
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