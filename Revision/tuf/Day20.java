public class Day20 {

    // Binary Search Tree
    public static void main(String[] args) {

    }


    
    // Construct Binary Search Tree from Preorder Traversal
    int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return bsfPreorderHelper(preorder, Integer.MAX_VALUE);
    }

    private TreeNode bsfPreorderHelper(int[] preorder, int bound) {
        if (i == preorder.length || preorder[i] > bound) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[i++]);

        node.left = bsfPreorderHelper(preorder, node.val);

        node.right = bsfPreorderHelper(preorder, bound);

        return node;
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

    static public class TreeNode {
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
