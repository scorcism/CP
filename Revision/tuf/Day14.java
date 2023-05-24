import java.util.*;

public class Day14 {

    // commit template -> tuf-day14-questionName
    public static void main(String[] args) {
        int[] A = { 3, 2, 1 };
        // System.out.println(Arrays.toString(prevSmaller(A)));
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
