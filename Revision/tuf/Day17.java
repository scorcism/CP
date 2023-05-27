import java.util.*;

public class Day17 {

    // Day 17: Binary Tree
    // commit template-> tuf-day17-questionName
    public static void main(String[] args) {

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
}
