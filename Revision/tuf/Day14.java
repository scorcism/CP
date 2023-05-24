import java.util.*;

public class Day14 {

    // commit template -> tuf-day14-questionName
    public static void main(String[] args) {
        int[] A = { 3, 2, 1 };
        // System.out.println(Arrays.toString(prevSmaller(A)));
    }


    // The Celebrity Problem
    int celebrity(int M[][], int n)
    {
    	
    }

    // Find the maximum of minimums of every window size
    public static int[] maxMinWindow(int[] a, int n) {
        // Get next Smaller
        // Get previous Smaller
        int[] nextSmaller = new int[n];
        int[] previousSmaller = new int[n];

        Stack<Integer> st = new Stack<>();

        // calculate next smaller
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                nextSmaller[i] = st.peek();
            } else {
                nextSmaller[i] = n;
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            st.pop();
        }

        // calculate previus small
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                nextSmaller[i] = st.peek();
            } else {
                nextSmaller[i] = 0;
            }
            st.push(i);
        }

        int[] ans = new int[n + 1];
        Arrays.fill(ans, 0);
        for (int i = 0; i < n; i++) {
            int len = nextSmaller[i] - previousSmaller[i] -1;
            ans[len] = Math.max(ans[len],a[i]);
        }

        for (int i = n - 1; i >= 1; i--)
            ans[i] = Math.max(ans[i], ans[i + 1]);

        return ans;
    }

    static class StockSpanner {

        class Pair {
            int value;
            int ans;

            Pair(int v, int a) {
                this.value = v;
                this.ans = a;
            }
        }

        Stack<Pair> stack;

        public StockSpanner() {
            stack = new Stack<Pair>();
        }

        public int next(int price) {
            int ans = 1;
            while (!stack.isEmpty() && stack.peek().value <= price) {
                ans += stack.pop().ans;
            }

            stack.push(new Pair(price, ans));
            return ans;
        }
    }

    // 994. Rotting Oranges
    public int orangesRotting(int[][] grid) {

    }

    // 155. Min Stack
    static class MinStack {

        public MinStack() {

        }

        public void push(int val) {

        }

        public void pop() {

        }

        public int top() {

        }

        public int getMin() {

        }
    }

    // 239. Sliding Window Maximum
    public int[] maxSlidingWindow(int[] nums, int k) {

    }

    public int largestRectangleArea2(int[] heights) {
        return 0;
    }

    // Largest Rectangle in Histogram
    public int largestRectangleArea(int[] heights) {
        // Get previus i.e. left smaller
        // Get next i.e right smaller
        int n = heights.length;
        int[] nse = new int[n];
        int[] pse = new int[n];

        Stack<Integer> stack = new Stack<>();
        // previus smaller
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                pse[i] = 0;
            } else {
                pse[i] = stack.peek() + 1;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            stack.pop();
        }
        // next smaller
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nse[i] = n - 1;
            } else {
                nse[i] = stack.peek() - 1;
            }
            stack.push(i);
        }
        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i] * (nse[i] - pse[i] + 1));
        }
        return maxA;
    }

    // LFU Cache
    static class LRUCache {

        class Node {
            Node prev, next;
            int key, value;

            Node(int _key, int _value) {
                this.key = _key;
                this.value = _value;
            }
        }

        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);
        Map<Integer, Node> map = new HashMap();
        int capacity;

        public LRUCache(int _capacity) {
            capacity = _capacity;
            head.next = tail;
            tail.prev = head;
        }

        private void remove(Node node) {
            map.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void insert(Node node) {
            map.put(node.key, node);
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                remove(node);
                insert(node);
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                remove(map.get(key));
            }
            if (map.size() == capacity) {
                remove(tail.prev);
            }
            insert(new Node(key, value));
        }
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
