import java.util.Stack;

public class Day13 {

    // commit template - tuf-day13-questionName
    public static void main(String[] args) {

    }

    // Sort a Stack
    static void sortStack(Stack<Integer> stack) {

    }

    // Implement stack Using Arrays
    static class StackUArray {
        /*
         * All functions
         * push
         * pop
         * top
         * size()
         * isEmpty()
         * isFull()
         */
        int CAPACITY;
        int[] arr;
        int top;

        public StackUArray(int capacity) {
            this.CAPACITY = capacity;
            arr = new int[CAPACITY];
            top = -1;
        }

        public boolean isFull() {
            return top == CAPACITY - 1; // true if top == capacity
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public void push(int n) {
            if (isFull()) {
                System.out.println("Stack Full");
            } else {
                top++;
                arr[top] = n;
            }
        }

        public int pop() {
            if (!isEmpty()) {
                int n = arr[top];
                top--;
                return n;
            }
            System.out.println("Stack Empty");
            return -1;
        }

        public int size() {
            return top++;
        }

        public int peek() {
            return arr[top];
        }

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
