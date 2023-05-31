import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Day21 {

    public static void main(String[] args) {

    }

    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                TreeNode top = q.poll();
                if (top == null) {
                    sb.append("$ ");
                    continue;
                }
                sb.append(top.val + " ");
                q.add(top.left);
                q.add(top.right);
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == "") {
                return null;
            }
            Queue<TreeNode> q = new LinkedList<>();
            String[] values = data.split(" ");
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            q.add(root);
            for (int i = 1; i < values.length; i++) {
                TreeNode parent = q.poll();
                if (!values[i].equals("$")) {
                    TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                    parent.left = left;
                    q.add(left);
                }
                if (!values[++i].equals("$")) {
                    TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                    parent.right = right;
                    q.add(right);
                }
            }
            return root;
        }
    }

    static class MSBNode {
        int maxNode;
        int minNode;
        int maxSize;

        MSBNode(int minNode, int maxNode, int maxSize) {
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.maxSize = maxSize;
        }
    }

    public int maxSumBST(TreeNode root) {
        return maxSumBSTHelper(root).maxSize;
    }

    private MSBNode maxSumBSTHelper(TreeNode root) {

        // An empty tree is a BST of size 0
        if (root == null) {
            return new MSBNode(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        // Get values from left and right subtree of current tree
        MSBNode left = maxSumBSTHelper(root.left);
        MSBNode right = maxSumBSTHelper(root.right);

        // Current node is greater than max in left AND smaller than min in right, it is
        // a ans
        if (left.maxNode < root.val && root.val < right.minNode) {
            return new MSBNode(Math.min(root.val, left.minNode), Math.max(root.val, right.maxNode),
                    left.maxSize + right.maxSize + 1);
        }

        // Otherwise, return [-inf, inf] so that parent cant be a valid BST
        return new MSBNode(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
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
