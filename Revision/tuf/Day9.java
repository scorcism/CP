import java.util.*;

public class Day9 {

    // Recursion Day
    // commit template - tuf-day9-questionName
    public static void main(String[] args) {

    }



    
    // Combiantion sum
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        solvecombinationSum(candidates, 0, target, a, ans);
        return ans;
    }

    private void solvecombinationSum(int[] arr, int i, int target, List<Integer> a, List<List<Integer>> ans) {
        if (i == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(a));
            }
            return;
        }
        if (arr[i] > target) {
            a.add(arr[i]);
            // take and not move
            solvecombinationSum(arr, i, target - arr[i], a, ans);
            a.remove(a.size() - 1);
            // not take but index move
        }
        solvecombinationSum(arr, i + 1, target, a, ans);
    }

    // 90. Subsets II
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        solvesubsetswithdup(0, nums, a, ans);
        return ans;
    }

    private void solvesubsetswithdup(int i, int[] nums, List<Integer> a, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(a));

        for (int index = i; index < nums.length; index++) {
            if (index != i && nums[index] == nums[index - 1]) {
                continue;
            }
            a.add(nums[index]);
            solvesubsetswithdup(index + 1, nums, a, ans);
            a.remove(a.size() - 1);
        }
    }

    // Subset Sums
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> ans = new ArrayList<>();
        solvesubsetSums(arr, 0, N, 0, ans);
        Collections.sort(ans);
        return ans;
    }

    private void solvesubsetSums(ArrayList<Integer> arr, int i, int n, int sum, ArrayList<Integer> ans) {
        if (i >= n) {
            ans.add(sum);
            return;
        }
        // take not take
        solvesubsetSums(arr, i + 1, n, sum += arr.get(i), ans);
        solvesubsetSums(arr, i + 1, n, sum, ans);
    }

}
