import java.util.Stack;
import java.util.Arrays;

public class StackDS {

    public static void previousSmallerElement(int[] array) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            // while stack is not empty and the top element of the stack is not less the the
            // arr[i] keep remoing the top one
            while (!s.isEmpty() && s.peek() >= array[i]) {
                s.pop();
            }

            // if the stack is empty
            if (s.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(s.peek());
            }
            s.push(array[i]);
        }
    }

    public static void previousGreaterElement(int[] array) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            while (!s.isEmpty() && s.peek() <= array[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                System.out.println(-1);
            }
            if (!s.isEmpty() && s.peek() > array[i]) {
                System.out.println(s.peek());
            }
            s.push(array[i]);
        }
    }

    // parenthesis matching
    public static boolean parenthesisMatching(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (isopening(ch)) {
                s.push(ch);
            } else {
                if (s.isEmpty()) {
                    return false;
                } else if (!isMatching(s.peek(), ch)) {
                    return false;
                } else {
                    s.pop();
                }
            }
        }
        return s.isEmpty();
    }

    private static boolean isMatching(char a, char b) {
        return (a == 'C' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']');
    }

    private static boolean isopening(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    public static int[] previousSmallest(int[] array) {
        int[] ans = new int[array.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            while (!s.isEmpty() && array[s.peek()] >= array[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = s.peek();
            }
            s.push(i);
        }
        return ans;
    }

    public static int[] nextSmallest(int[] array) {
        int[] ans = new int[array.length];

        Stack<Integer> s = new Stack<>();

        for (int i = array.length - 1; i > 0; i--) {
            while (!s.isEmpty() && array[s.peek()] >= array[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = s.peek();
            }
            s.push(i);
        }
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == -1) {
                ans[i] = 9;
            }
        }
        return ans;
    }

    public static int largestRectangleHistogram(int[] array) {

        int[] ps = previousSmallest(array);
        int[] ns = nextSmallest(array);

        int ans = 0;

        for (int i = 0; i < array.length; i++) {
            int curans = (ns[i] - ps[i] - 1 )* array[i];
            ans = Math.max(ans,curans) ;
        }

        return ans;
    }

    public static void main(String[] args) {
        int array[] = { 4, 10, 5, 8, 20, 15, 3, 11 };
        int array2[] = { 4, 2, 1, 5, 6, 3, 2, 4, 2 };
        // previousGreaterElement(array);
        System.out.println(largestRectangleHistogram(array2));

    }
}
