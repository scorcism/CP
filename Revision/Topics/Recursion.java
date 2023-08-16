import java.util.*;

public class Recursion {
    public static void main(String[] args) {
        Problems prob = new Problems();

    }
}

class Problems {

    public List<List<Integer>> subsets(int[] nums) {
        // TC-> 
        List<List<Integer>> ans = new ArrayList<>();
        subsetsHelper(nums, 0, ans, new ArrayList<Integer>());
        return ans;
    }

    public void subsetsHelper(int[] nums, int i, List<List<Integer>> ans, ArrayList<Integer> list) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        subsetsHelper(nums, i + 1, ans, list);

        list.add(nums[i]);
        subsetsHelper(nums, i + 1, ans, list);
        list.remove(list.size() - 1);
    }

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