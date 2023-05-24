import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;


public class Day13 {

    // commit template - tuf-day13-questionName
    public static void main(String[] args) {
    }

    // Sort a Stack
    static void sortStack(Stack<Integer> stack) {

    }

    // 	Implement Stack[LIFO] using Queue[FIFO] (using single queue)
    static class StackUsingQueue1{
        // SC -> O(N+N) = O(N)
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();

        // Steps
        /*
         * push(m)
         * Add m -> q2
         * Move q1 -> q2 element by element
         * swap(q1, q2)
         */

        void push(int x){
            q2.add(x);
            while(!q1.isEmpty()){
                q2.add(q1.poll());
            }
            Deque<Integer> tmp = q1;
            q1 = q2;
            q2 = tmp;
        }

        /*
         * Remove element from q1
         */
        void pop(){
            if(!q1.isEmpty()){
                q1.poll();
            }
        }

        int top(){
            return q1.peekFirst();
        }
    }


    // Implement Queue[FIFO] Using Arrays
    static class QueueUArray {

        int CAPACITY;
        int[] arr;
        int front;
        int rare;
        int count;

        public QueueUArray(int capacity) {
            this.CAPACITY = capacity;
            arr = new int[CAPACITY];
            front = 0;
            rare = 0;
            count = 1;
        }

        void push(int n) {
            if (count == CAPACITY) {
                System.out.println("FULL");
                return;
            }
            arr[rare % CAPACITY] = n;
            rare++;
            count++;
        }

        int pop() {
            if (count == 0) {
                System.out.print("EMPTY");
                return -1;
            }
            int n = arr[front % CAPACITY];
            front++;
            count--;
            return n;
        }

        int size() {
            if (count == 0) {
                return -1;
            }
            return count;
        }

        int top() {
            if(count == 0){
                return -1;
            }
            return arr[front%CAPACITY];
        }

        int front() {
            if(front != rare){
                return arr[front % CAPACITY];
            }
            return -1;
        }
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
