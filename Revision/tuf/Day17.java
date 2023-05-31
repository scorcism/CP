import java.util.*;

public class Day17 {

    // Day 17: Binary Tree
    // commit template-> tuf-day17-questionName
    public static void main(String[] args) {

    }

    // Maximum Width of Binary Tree
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().index;
            int first = 0;
            int last = 0;
            for (int i = 0; i < size; i++) {
                int curr_index = q.peek().index - min;
                TreeNode node = q.poll().node;
                if (i == 0) {
                    first = curr_index;
                }
                if (i == size - 1) {
                    last = curr_index;
                }
                if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * curr_index + 1));
                }
                if (node.right != null) {
                    q.offer(new Pair(node.right, 2 * curr_index + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }

    static class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    // Root to node path in a Binary Tree
    // Root to leaf path in a Binary Tree
    static ArrayList<Integer> rootToNode(TreeNode root, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        rtn(root, ans, x);
        return ans;
    }

    private static boolean rtn(TreeNode root, ArrayList<Integer> ans, int x) {
        if(root == null){
            return false;
        }
        ans.add(root.val);
        if(root.val == x){
            return true;
        }
        if(rtn(root.left, ans, x) || rtn(root.right, ans, x)){
            return true;
        }
        ans.remove(ans.size()-1)
        return false;
    }

    // Preorder inorder postorder in a single traversal
    static void treeTraverse(TreeNode root) {
        Stack<Pair> st = new Stack<>();
        ArrayList<Integer> inorder = new ArrayList<>();
        ArrayList<Integer> preorder = new ArrayList<>();
        ArrayList<Integer> postorder = new ArrayList<>();
        st.add(new Pair(root, 1));
        while (!st.isEmpty()) {
            Pair it = st.pop();

            if (it.number == 1) {
                preorder.add(it.node.val);
                it.number++;
                st.push(it);
                if (it.node.left != null) {
                    st.push(new Pair(it.node.left, 1));
                }
            } else if (it.number == 2) {
                inorder.add(it.node.val);
                it.number++;
                st.push(it);
                if (it.node.right != null) {
                    st.add(new Pair(it.node.right, 1));
                }
            } else {
                postorder.add(it.node.val);
            }
        }
    }

    static class Pair {
        TreeNode node;
        int number;

        Pair(TreeNode node, int number) {
            this.node = node;
            this.number = number;
        }
    }

    // Top View of Binary Tree
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<tvNode> q = new LinkedList<tvNode>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new tvNode(root, 0));

        while (!q.isEmpty()) {
            tvNode node = q.poll();
            int hd = node.hd;
            int data = node.node.data;

            if (!map.containsKey(hd)) {
                map.put(hd, data);
            }

            if (node.node.left != null) {
                q.add(new tvNode(node.node.left, hd - 1));
            }

            if (node.node.right != null) {
                q.add(new tvNode(node.node.right, hd + 1));
            }
        }

        for (int n : map.values()) {
            ans.add(n);
        }
        return ans;
    }

    static class tvNode {
        Node node;
        int hd;

        public tvNode(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Bottom View of Binary Tree
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<Node> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        root.hd = 0;
        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.poll();
            int hd = node.hd;
            map.put(hd, node.data);

            if (node.left != null) {
                node.left.hd = hd - 1;
                q.add(node.left);
            }

            if (node.right != null) {
                node.right.hd = hd + 1;
                q.add(node.right);
            }
        }

        for (int n : map.values()) {
            ans.add(n);
        }

        return ans;
    }

    // 987. Vertical Order Traversal of a Binary Tree

    // Right View of Binary Tree
    static ArrayList<Integer> rightView(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        right(node, ans, 0);
        return ans;
    }

    private static void right(Node node, ArrayList<Integer> ans, int level) {
        if (node == null) {
            return;
        }
        if (ans.size() == level) {
            ans.add(node.data);
        }
        right(node.right, ans, level + 1);
        right(node.left, ans, level + 1);
    }

    // Left View of Binary Tree
    static ArrayList<Integer> LeftView(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        left(node, ans, 0);
        return ans;
    }

    private static void left(Node node, ArrayList<Integer> ans, int level) {
        if (node == null) {
            return;
        }
        if (ans.size() == level) {
            ans.add(node.data);
        }
        right(node.right, ans, level + 1);
        right(node.left, ans, level + 1);
    }

    // Morris preorder Traversal
    public List<Integer> morrisPreorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    ans.add(curr.val);
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }

    // Morris Inorder Traversal
    public List<Integer> morrisInorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }

    // Binary Tree Postorder Traversal
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postOrder(root, ans);
        return ans;
    }

    private void postOrder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        postOrder(root.left, ans);
        postOrder(root.right, ans);
        ans.add(root.val);
    }

    public List<Integer> postorderTraversalIterative1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            root = st1.pop();
            st2.add(root);
            if (root.left != null) {
                st1.add(root.left);
            }
            if (root.right != null) {
                st1.add(root.right);
            }
        }
        while (!st2.isEmpty()) {
            ans.add(st2.pop().val);
        }
        return ans;
    }

    // 144. Binary Tree Preorder Traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }

    private void preorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }

    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            root = st.pop();
            ans.add(root.val);
            if (root.right != null) {
                st.push(root.right);
            }
            if (root.left != null) {
                st.push(root.left);
            }
        }
        return ans;
    }

    // Binary Tree Inorder Traversal
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder1(root, ans);
        return ans;
    }

    private void inorder1(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        inorder1(root.left, ans);
        ans.add(root.val);
        inorder1(root.right, ans);
    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                node = stack.pop();
                ans.add(node.val);
                node = node.right;
            }
        }
        return ans;
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

    class Node {
        int data;
        Node left, right;
        int hd;

        public Node(int data) {
            this.data = data;
            left = right = null;
            hd = Integer.MAX_VALUE;
        }
    }
}
