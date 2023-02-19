import java.util.*;
import java.util.LinkedList;

public class CP2 {

    public static int minOperations(int n) {
        int res = 0;
        while (n > 0) {
            if ((n & 3) == 3) {
                System.out.println("n " + n);
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
