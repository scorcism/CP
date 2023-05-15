import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Day7 {

    // commit template -> tuf-day7-questionName
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            map.remove(nums[i]);
            for (int j = i + 1; j < n; j++) {
                map.remove(nums[j]);
                if (map.containsKey(-1 * (nums[i] + nums[j]))) {
                    set.add(Arrays.asList(i, j, map.get(-1 * (nums[i] + nums[j]))));
                }

            }
        }
        // omitted
        return ans;

    }

    // Copy List with Random Pointer
    public Node copyRandomList(Node head) {
        // 3 steps

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.

        Node front = head;
        Node iter = head;

        while (iter != null) {
            front = front.next;
            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = front;
            iter = front;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // // Third round: restore the original list, and extract the copy list.
        iter = head;
        Node dummy = new Node(0);
        Node copy = dummy;

        while (iter != null) {
            front = iter.next.next;
            copy.next = iter.next;
            iter.next = front;
            copy = copy.next;
            iter = iter.next;
        }

        return dummy.next;
    }

    // Rotate List
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        int len = 1;
        ListNode t = head;

        while (t.next != null) {
            t = t.next;
            len++;
        }

        t.next = head;
        k = k % len;
        k = len - k;
        while (k > 0) {
            t = t.next;
            k--;
        }

        head = t.next;
        t.next = null;

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}