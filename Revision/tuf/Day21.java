public class Day21 {

    public static void main(String[] args) {

    }

    // Kth Smallest Element in a BST
    int number = -1;

    public int kthSmallest(TreeNode root, int k) {
        getKthSmallest(root, new int[] { k });
        return number;
    }

    private void getKthSmallest(TreeNode root, int[] k) {
        if (root == null) {
            return;
        }
        getKthSmallest(root.left, k);

        k[0]--;
        if (k[0] == 0) {
            number = root.val;
            return;
        }
        getKthSmallest(root.right, k);
    }

    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null)
            return -1;
        // Code here
        int ceil = -1;
        while (root != null) {
            if (root.data == key) {
                return root.data;
            }
            if (root.data <= key) {
                root = root.right;
            } else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }

    // Floor int BST
    public static int floor(Node root, int x) {
        int floor = -1;
        while (root != null) {
            if (root.data == x) {
                return x;
            }
            if (root.data <= x) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
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
        int data;
        Node right;
        Node left;

        Node(int val) {
            data = val;
            right = null;
            left = null;
        }
    }

}
