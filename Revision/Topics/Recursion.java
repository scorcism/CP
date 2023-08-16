import java.util.*;

public class Recursion {
    public static void main(String[] args) {
        Problems prob = new Problems();
        // prob.getSum();
        System.out.println(prob.generateParenthesis(2));
    }
}

class Problems {

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        gpHelper(new StringBuilder(), n, n, ans);
        return ans;
    }

    public static void gpHelper(StringBuilder sb, int open, int close, List<String> ans) {
        if (open == 0 && close == 0) {
            ans.add(sb.toString());
            return;
        }
        if (open > 0) {
            sb.append("(");
            gpHelper(sb, open - 1, close, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close > 0) {
            if (open < close) {
                sb.append(")");
                gpHelper(sb, open, close - 1, ans);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    // Sum of the array till nth index
    public void getSum() {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(getSumHelper(nums, nums.length - 1));
    }

    public int getSumHelper(int[] nums, int n) {
        if (n < 0) {
            return 0;
        }
        return getSumHelper(nums, n - 1) + nums[n];
    }
}