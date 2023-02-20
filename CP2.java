import java.util.*;
import java.util.LinkedList;

public class CP2 {

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

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        // create a new ListNode
        ListNode tmp = new ListNode(0);
        ListNode curr = tmp; // for moving the pointers

        // why pq coz we want the elements in ascending order and in pq we can define the order of elements by sorting them so in later by iterating it we get the values in sorted order by default

        // put everything in pq
        PriorityQueue<ListNode> pq  = new PriorityQueue<>((a,b)->a.val - b.val);

        // Add all the elements to pq
        for(ListNode node: lists){
            if(node != null){
                // if the current node is not null means it is not the last ele of the curren array of LL
                pq.add(node);
            }
        }

        // iterating in the queue to add ele to out own ll
        while(!pq.isEmpty()){
            curr.next = pq.poll();
            curr = curr.next;

            // 
            if(curr.next != null){
                pq.add(curr.next);
            }

        }
        return tmp.next;
    }

    public static int minOperations(int n) {

        int res = 0;
        while (n > 0) {
            if ((n & 3) == 3) {
                n++;
                res++;
            } else {
                res += n & 1;
                n >>= 1;
            }
        }
        return res;
    }

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        List<int[]> list = new ArrayList<>();

        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            int[] num1val = nums1[i];
            int[] num2val = nums2[j];
            if (num1val[0] < num2val[0]) {
                list.add(num1val);
                i++;
            } else if (num1val[0] > num2val[0]) {
                list.add(num2val);
                j++;
            } else if (num1val[0] == num2val[0]) {
                // both are same
                int tmp = num1val[1] + num2val[1];
                int[] newtmp = { num1val[0], tmp };
                list.add(newtmp);
                i++;
                j++;
            }
        }
        while (i < n1) {
            list.add(nums1[i]);
            i++;
        }
        while (j < n2) {
            list.add(nums2[j]);
            j++;
        }
        return list.toArray(new int[list.size()][]);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            // getting the size of the q so that we can take both the value sin one go
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (q.peek().left != null) {
                    q.offer(q.peek().left);
                }
                if (q.peek().right != null) {
                    q.offer(q.peek().right);
                }
                l.add(q.poll().val);
            }
            ans.add(l);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(15));
        System.out.println(minOperations(20));
        System.out.println(minOperations(6126));
    }
}
