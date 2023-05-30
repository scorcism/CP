public class Day20 {

    // Binary Search Tree
    public static void main(String[] args) {

    }

    // Search in a Binary Search Tree
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            if (val > root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return null;
    }

    // search in BST
    public TreeNode search(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
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

}
