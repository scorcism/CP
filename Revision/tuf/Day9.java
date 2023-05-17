import java.util.*;

public class Day9 {

    // Recursion Day
    // commit template - tuf-day9-questionName
    public static void main(String[] args) {

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
