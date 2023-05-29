import java.util.*;

public class Day19 {

    public static void main(String[] args) {

    }


    
    // Construct Binary Tree from Preorder and Inorder Traversal
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);

        return root;
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);

        int inorderIndex = map.get(node.val);
        int leftIndexToNodeInInorder = inorderIndex - inStart;

        node.left = buildTree(preorder, preStart + 1, preStart + leftIndexToNodeInInorder, inorder, inStart,
                inorderIndex - 1, map);

        node.right = buildTree(preorder, preStart + leftIndexToNodeInInorder + 1, preEnd, inorder, inorderIndex + 1,
                inEnd, map);

        return node;
    }

    // Binary Tree Maximum Path Sum
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        maxpathsum(root, ans);
        return ans[0];
    }

    static int maxpathsum(TreeNode root, int[] ans) {
        if (root == null) {
            return 0;
        }
        int maxL = Math.max(0, maxpathsum(root.left, ans));
        int maxR = Math.max(0, maxpathsum(root.right, ans));
        ans[0] = Math.max(ans[0], maxL + maxR + root.val);
        return root.val + Math.max(maxL, maxR);
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
