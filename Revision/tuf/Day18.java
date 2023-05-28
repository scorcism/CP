import java.util.*;

public class Day18 {

    public static void main(String[] args) {

    }

    // Binary Tree Zigzag Level Order Traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                // int index = (leftToRight) ? i : (size - 1 - i);
                if(leftToRight){
                    a.add(node.val);
                }else{
                    a.add(0,node.val);
                }
                // a.add(index, node.val);
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right!= null){
                    q.add(node.right);
                }
            }
            leftToRight = !leftToRight;
            ans.add(a);
        }
        return ans;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // Lowest Common Ancestor of a Binary Tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    // Balanced Binary Tree
    public boolean isBalanced(TreeNode root) {
        return usingHeight(root) != -1;
    }

    private int usingHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = usingHeight(root.left);
        if (lh == -1) {
            return -1;
        }
        int rh = usingHeight(root.right);
        if (rh == -1) {
            return -1;
        }
        if (Math.abs(lh - rh) > 1) {
            return -1;
        }

        return 1 + Math.max(lh, rh);
    }

    // 543. Diameter of Binary Tree
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    private int height(TreeNode root, int[] diameter) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left, diameter);
        int rh = height(root.right, diameter);
        diameter[0] = Math.max(lh + rh, diameter[0]);
        return 1 + Math.max(lh, rh);
    }

    // 104. Maximum Depth of Binary Tree
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
    }

    // 102. Binary Tree Level Order Traversal
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return ans;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (q.peek().left != null) {
                    q.offer(q.peek().left);
                }
                if (q.peek().right != null) {
                    q.offer(q.peek().right);
                }
                a.add(q.poll().val);
            }
            ans.add(a);
        }
        return ans;
    }

    static class TreeNode {
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

}