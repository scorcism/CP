public class Day20 {

    // Binary Search Tree
    public static void main(String[] args) {

    }

    // 116. Populating Next Right Pointers in Each Node
    public Node connect(Node root) {
        // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/solutions/962728/java-0ms-with-visual-explanation/
        if (root == null) {
            return null;
        }
        // for level 1 eg
        if (root.left != null) {
            root.left.next = root.right;
        }

        // eg for level 2
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    // Inorder Successor
    static TreeNode inorderSuccessor(TreeNode node, TreeNode p) {
        TreeNode successor = null;

        while (node != null) {
            if (node.val <= p.val) {
                node = node.right;
            } else {
                successor = node;
                node = node.left;
            }
        }
        return successor;
    }

    // Populate Next Right pointers of Tree

    // 108. Convert Sorted Array to Binary Search Tree
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBSTHelper(nums, 0, nums.length - 1);
    }

    private TreeNode toBSTHelper(int[] nums, int i, int j) {
        if (i > j) {
            return null;
        }
        int mid = (j + i) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBSTHelper(nums, i, mid - 1);
        root.right = toBSTHelper(nums, mid + 1, j);
        return root;
    }

    // Inorder Predecessor
    static TreeNode inorderPredecessor(TreeNode node, TreeNode p) {
        TreeNode predecessor = null;

        while (node != null) {
            if (node.val <= p.val) {
                predecessor = node;
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return predecessor;
    }

    // 235. Lowest Common Ancestor of a Binary Search Tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int rootval = root.val;
        if (rootval < p.val && rootval < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (rootval > p.val && rootval > q.val) {
            return lowestCommonAncestor(root.left, p, q);

        } else {
            return root;
        }
    }

    // 98. Validate Binary Search Tree
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }

        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }

        return isValidBSTHelper(root.left, minValue, root.val) && isValidBSTHelper(root.right, root.val, maxValue);
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

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

}