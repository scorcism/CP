import java.util.*;

public class Day14 {

    // commit template -> tuf-day14-questionName
    public static void main(String[] args) {
        int[] A = { 3, 2, 1 };
        System.out.println(Arrays.toString(prevSmaller(A)));
    }

    static public int[] prevSmaller(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        // List<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int p = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= A[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            } else {
                ans[i] = -1;
            }
            stack.push(A[i]);
        }

        return ans;

    }
}
