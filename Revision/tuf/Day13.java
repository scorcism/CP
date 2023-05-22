import java.util.Stack;

public class Day13 {

    // commit template - tuf-day13-questionName
    public static void main(String[] args) {

    }

    public int[] nextGreaterElements(int[] nums) {
        int[] nge = new int[nums.length];
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            if (i < n) {
                if (!stack.isEmpty()) {
                    nge[i] = stack.peek();
                } else {
                    nge[i] = -1;
                }
            }
            stack.add(nums[i]);

        }
        return nge;
    }

    public int[] nextGreaterElements2(int[] nums) {
        int[] nge = new int[nums.length];
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            if (i < n) {
                if (!stack.isEmpty()) {
                    nge[i] = stack.peek();
                } else {
                    nge[i] = -1;
                }
            }
            stack.add(nums[i % n]);

        }
        return nge;
    }

    // Check for balanced parentheses
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (isOpening(s.charAt(i))) {
                stack.add(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!isMatching(s.charAt(i), stack.peek())) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean isMatching(char close, Character open) {
        return (open == '(' && close == ')' || open == '[' && close == ']' || open == '{' && close == '}');
    }

    private boolean isOpening(char c) {
        return (c == '{' || c == '(' || c == '[');
    }
}
