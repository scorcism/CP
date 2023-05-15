import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Day7 {

    // commit template -> tuf-day7-questionName
    public static void main(String[] args) {

    }

    
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxans = 0;
        
        int count = 0;
        for(int n: nums){
            if(n==1){
                count++;
            }else{
                count=0;
                maxans = Math.max(count,maxans);
            }
        }

        return maxans;
    }


    public int removeDuplicates1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int j = 0;
        for (int p : set) {
            nums[j++] = p;
        }

        return set.size();
    }

    public int removeDuplicates2(int[] nums) {
        int i = 0;
        int n = nums.length;
        for (int j = 0; j < n; j++) {
            if (nums[i] == nums[j]) {
                continue;
            } else if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    // Trapping Rain Water
    public int trap1(int[] height) {
        int[] prefixSum = new int[height.length];
        int[] suffixSum = new int[height.length];

        // get prefix sum
        prefixSum[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            prefixSum[i] = Math.max(prefixSum[i - 1], height[i]);
        }

        // get Suffix sum
        suffixSum[height.length - 1] = height[height.length - 1];

        for (int i = height.length - 2; i >= 0; i--) {
            suffixSum[i] = Math.max(height[i], suffixSum[i + 1]);
        }

        int maxsum = 0;

        for (int i = 0; i < height.length; i++) {
            maxsum += Math.min(prefixSum[i], suffixSum[i]) - height[i];
        }
        return maxsum;
    }

    public int trap2(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;

        int leftmax = 0;
        int rightmax = 0;
        int ans = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftmax) {
                    leftmax = height[left];
                } else {
                    ans += leftmax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightmax) {
                    rightmax = height[right];
                } else {
                    ans += rightmax - height[right];
                }
                right++;
            }
        }
        return ans;
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