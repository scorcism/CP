import java.util.Stack;

public class Day21 {

    public static void main(String[] args) {

    }


    
    class BSTIterator2 {
        private Stack<TreeNode> stack = new Stack<>();
        boolean reverse = true;
        // reverse = true = before
        // reverse = false = next;

        public BSTIterator2(TreeNode root, boolean isReverse) {
            reverse = isReverse;
            pushAll(root);
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int next() {
            TreeNode top = stack.pop();
            if (reverse == false) {
                pushAll(top.right);
            } else {
                pushAll(top.left);
            }

            return top.val;
        }

        private void pushAll(TreeNode node) {
            while (node != null) {
                stack.push(node);
                if (reverse) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
        }
    }

    // Two Sum IV - Input is a BST
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        BSTIterator2 l = new BSTIterator2(root, false);
        BSTIterator2 r = new BSTIterator2(root, true);

        int i = l.next();
        int j = r.next();
        while (i < j) {
            if (i + j == k) {
                return true;
            } else if (i + j < k) {
                i = l.next();
            } else {
                j = r.next();
            }
        }
        return false;
    }

    static class BSTIterator {
        private Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            // push all left of node to left
            pushAll(root);
        }

        public int next() {
            TreeNode top = stack.pop();
            pushAll(top.right);
            return top.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        void pushAll(TreeNode node) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
        }
    }

    // return the Kth largest element in the given BST rooted at 'root'
    int no = -1;

    public int kthLargest(Node root, int K) {
        getKthLargest(root, new int[] { k });
        return no;
    }

    private void getKthLargest(Node root, int[] K) {
        if (root == null) {
            return;
        }
        getKthLargest(root.right, K);
        K[0]--;
        if (K[0] == 0) {
            no = root.data;
            return;
        }
        getKthLargest(root.left, K);
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
