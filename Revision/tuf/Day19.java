import java.util.*;

public class Day19 {

    public static void main(String[] args) {

    }

    // Flatten Binary Tree to Linked List
    static TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    public void flatten2(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            if (curr.right != null) {
                st.add(curr.right);
            }
            if (curr.left != null) {
                st.add(curr.left);
            }
            if (!st.isEmpty()) {
                curr.right = st.peek();
            }
            curr.left = null;
        }
    }

    public void flatten3(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    // 101. Symmetric Tree
    public boolean isSymmetric(TreeNode root) {
        return root == null || helperS(root.left, root.right);
    }

    private boolean helperS(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return helperS(left.left, right.right) && helperS(left.right, right.left);
    }

    // Construct Binary Tree from Inorder and Postorder
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = buildTree2(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);

        return root;
    }

    private TreeNode buildTree2(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
            Map<Integer, Integer> map) {
        if (is > ie || ps > pe) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[pe]);

        int inOrderIndex = map.get(postorder[pe]);

        int numsToLeftOfIndexOfRoot = inOrderIndex - is;

        node.left = buildTree2(inorder, is, inOrderIndex - 1, postorder, ps, pe + numsToLeftOfIndexOfRoot - 1, map);

        node.right = buildTree2(inorder, inOrderIndex + 1, ie, postorder, ps + numsToLeftOfIndexOfRoot, pe - 1, map);

        return node;
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
