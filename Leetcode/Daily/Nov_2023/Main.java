package Leetcode.Daily.Nov_2023;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}

class Solution {
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        int count = 1;
        int max = 0;
        Integer prev = null;
        findModeTraverse(root, list, prev, count, max);
        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void findModeTraverse(TreeNode root, List<Integer> list, Integer prev, int count, int max) {
        if (root == null) {
            return;
        }
        findModeTraverse(root.left, list, prev, count, max);
        if (prev != null) {
            if (root.val == prev) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        findModeTraverse(root.right, list, prev, count, max);
    }
}

class TreeNode {
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
