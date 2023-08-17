import java.util.*;

public class Recursion {
    public static void main(String[] args) {
        Problems prob = new Problems();
        Practice p = new Practice();

    }
}

class Practice {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(A);
        csFunc(B, new ArrayList<Integer>(), 0, A, ans);
        return ans;
    }

    public static void csFunc(int B, ArrayList<Integer> ds, int index, ArrayList<Integer> nums,
            ArrayList<ArrayList<Integer>> ans) {
        if (index == nums.size()) {
            if (B == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if (nums.get(index) <= B) {

            ds.add(nums.get(index));

            csFunc(B - nums.get(index), ds, index, nums, ans);

            ds.remove(ds.size() - 1);
        }

        csFunc(B, ds, index + 1, nums, ans);
    }

    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }

        if (k % 2 == 0) {
            return 1 - kthGrammar(n - 1, (k + 1) >> 1);
        } else {
            return kthGrammar(n - 1, (k + 1) >> 1);
        }
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