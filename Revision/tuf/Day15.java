import java.util.*;

class Day15 {

    // String Part - 1
    // commit template -> tuff-day15-questionName
    public static void main(String[] args) {

    }

    // Rabin Karp
    

    // 14. Longest Common Prefix
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[n - 1];
        int count = 0;
        while (count < first.length()) {
            if (first.charAt(count) == last.charAt(count)) {
                count++;
            } else {
                break;
            }
        }
        return count < 1 ? "" : first.substring(0, count);
    }

    // 8. String to Integer (atoi)
    public int myAtoi(String str) {

        final int len = str.length();

        if (len == 0) {
            return 0;
        }

        int index = 0;

        // skipping white spaces
        while (index < len && str.charAt(index) == ' ') {
            ++index;
        }

        boolean isNegative = false;

        // to handle sign cases
        if (index < len) {

            if (str.charAt(index) == '-') {
                isNegative = true;
                ++index;
            } else if (str.charAt(index) == '+') {
                ++index;
            }

        }

        int result = 0;

        // converting digit(in character form) to integer form
        // iterate until non-digit character is not found or we can say iterate till
        // found character is a digit
        while (index < len && isDigit(str.charAt(index))) {

            /*
             * str.charAt(index) - '0' is to convert the char digit into int digit eg: '5' -
             * '0' --> 5
             * or else it will store the ASCII value of 5 i.e. 53,
             * so we do 53(ASCII of 5) - 48(ASCII of 0(zero)) to get 5 as int
             */
            int digit = str.charAt(index) - '0';

            // to avoid integer overflow
            if (result > (Integer.MAX_VALUE / 10) || (result == (Integer.MAX_VALUE / 10) && digit > 7)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            // adding digits at their desired place-value
            result = (result * 10) + digit;

            ++index;
        }

        return isNegative ? -result : result;
        /*
         * Let's understand what
         * if(result > (Integer.MAX_VALUE / 10) || (result == (Integer.MAX_VALUE / 10)
         * && digit > 7)){
         * return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
         * }
         * means in JAVA? You will be able to figure out this statement easily for C++
         * code too.
         * 
         * result > (Integer.MAX_VALUE / 10) means:
         * Suppose,
         * result = 214748365(9 digits)
         * Integer.MAX_VALUE = 2147483647(10 digits) and Integer.MAX_VALUE / 10 =
         * 214748364(9 digits)
         * Here, it is clearly evident that result > Integer.MAX_VALUE / 10( i.e.
         * 214748365 > 214748364) and if we try to add even 0(zero) in result
         * 214748365(9 digits), the number will become 2147483650(10 digits) which is
         * obviously greater than 2147483647(Integer.MAX_VALUE which is of 10 digits).
         * So even before adding 0(zero) or any other digit, we return the
         * Integer.MAX_VALUE or Integer.MIN_VALUE, according to the sign case, in order
         * to avoid integer overflow.
         * 
         * And, result == (Integer.MAX_VALUE / 10) && digit > 7 means:
         * Suppose,
         * result = 214748364(9 digits), and
         * Integer.MAX_VALUE / 10 = 214748364(9 digits)
         * Now, if the result is equal to the Integer.MAX_VALUE / 10 (214748364 ==
         * 214748364) and the digit is greater than 7 i.e. digit > 7 and if we try to
         * add 8(assume the digit greater than 7 to be 8) to the result, then the number
         * will become 2147483648(10 digits), which will result in integer overflow. So,
         * even before adding the digit which is greater than 7, we return the
         * Integer.MAX_VALUE or Integer.MIN_VALUE, according to the sign case, to avoid
         * integer overflow.
         */
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    // 12. Integer to Roman
    public String intToRoman(int num) {
        int[] val = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            for (int i = 0; i < val.length; i++) {
                if (num >= val[i]) {
                    sb.append(symbols[i]);
                    num -= val[i];
                    break;
                }
            }
        }
        return sb.toString();
    }

    // 13. Roman to Integer
    public int romanToInt(String s) {
        // Move from largest to smallest: add them up
        // smaller before larger: subtract smaller
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                ans -= map.get(s.charAt(i));
            } else {
                ans += map.get(s.charAt(i));
            }
        }
        return ans;
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