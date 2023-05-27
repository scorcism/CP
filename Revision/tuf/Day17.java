import java.util.*;

public class Day17 {

    // Day 17: Binary Tree
    // commit template-> tuf-day17-questionName
    public static void main(String[] args) {

    }

    // Right View of Binary Tree
    static ArrayList<Integer> rightView(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        right(node, ans,0);
        return ans;
    }

    private static void right(Node node, ArrayList<Integer> ans, int level) {
        if(node == null){
            return;
        }
        if(ans.size()== level){
            ans.add(node.data);
        }
        right(node.right, ans, level+1);
        right(node.left, ans, level+1);
    }

    // Left View of Binary Tree
    static ArrayList<Integer> LeftView(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        left(node, ans,0);
        return ans;
    }

    private static void left(Node node, ArrayList<Integer> ans, int level) {
        if(node == null){
            return;
        }
        if(ans.size()== level){
            ans.add(node.data);
        }
        right(node.right, ans, level+1);
        right(node.left, ans, level+1);
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

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
