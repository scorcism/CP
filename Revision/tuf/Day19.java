public class Day19 {

    public static void main(String[] args) {

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
