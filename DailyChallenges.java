import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Queue;

class DailyChallenges {

    // fab 9
    // https://leetcode.com/problems/as-far-from-land-as-possible/
    class MaxDistanceClass {
        int row;
        int col;
        int step;

        MaxDistanceClass(int row, int col, int step) {
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }

    public int maxDistance(int[][] grid) {
        int ans = Integer.MIN_VALUE;

        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int[][] distance = new int[n][m];

        Queue<MaxDistanceClass> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new MaxDistanceClass(i, j, 0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int s = q.peek().step;
            distance[r][c] = s;
            q.remove();
            int[] delrow = { -1, 0, 1, 0 };
            int[] delcol = { 0, 1, 0, -1 };

            for (int i = 0; i < 4; i++) {
                int newrow = delrow[i] + r;
                int newcol = delcol[i] + c;

                if (newrow >= 0 && newcol >= 0 && newrow < n &&
                        newcol < m && vis[newrow][newcol] == 0) {
                    q.add(new MaxDistanceClass(newrow, newcol, s + 1));
                    vis[newrow][newcol] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, distance[i][j]);
            }
        }
        return ans;
    }

    // Fab 10
    // https://leetcode.com/problems/shortest-path-with-alternating-colors/
    // 1129. Shortest Path with Alternating Colors
    static class SATNode {
        int node;
        int steps;
        int preColor;

        SATNode(int a, int b, int c) {
            this.node = a;
            this.steps = b;
            this.preColor = c;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // create adj list of the following matrix
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();

        for (int[] re : redEdges) {
            adj.computeIfAbsent(re[0], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(re[1], 0));
        }

        for (int[] be : blueEdges) {
            adj.computeIfAbsent(be[0], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(be[1], 1));
        }

        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        boolean[][] visited = new boolean[n][2];

        Queue<int[]> q = new LinkedList<>();

        visited[0][0] = visited[0][1] = true;
        q.offer(new int[] { 0, 0, -1 });
        answer[0] = 0;
        while (!q.isEmpty()) {
            int[] element = q.poll();

            int node = element[0];
            int steps = element[1];
            int prevColor = element[2];

            if (!adj.containsKey(node)) {
                continue;
            }

            for (List<Integer> nei : adj.get(node)) {
                int neighbor = nei.get(0);
                int color = nei.get(1);

                if (!visited[neighbor][color] && color != prevColor) {
                    if (answer[neighbor] == -1) {
                        answer[neighbor] = 1 + steps;
                    }
                    visited[neighbor][color] = true;
                    q.offer(new int[] { neighbor, 1 + steps, color });
                }
            }

        }

        return answer;
    }

    // Feb 11
    // https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/description/
    // 2477. Minimum Fuel Cost to Report to the Capital
    long minFuel = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        // convert this roads to adj list
        int n = roads.length + 1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];

        for (int[] cur : roads) {
            adj.get(cur[0]).add(cur[1]);
            adj.get(cur[1]).add(cur[0]);
            indegree[cur[0]]++;
            indegree[cur[1]]++;
        }

        return minimumFuelCostBFS(adj, seats, indegree, n);

    }

    private long minimumFuelCostBFS(ArrayList<ArrayList<Integer>> adj, int seats, int[] indegree, int n) {

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < n; i++) {
            if (indegree[i] == 1) {
                q.offer(i);
            }
        }

        int[] representative = new int[n];
        Arrays.fill(representative, 1);
        long minFeul = 0;

        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();

            minFeul += Math.ceil((double) representative[node] / seats);

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                representative[neighbor] += representative[node];
                if (indegree[neighbor] == 1 && neighbor != 0) {
                    q.offer(neighbor);
                }
            }
        }
        return minFeul;

    }

    // Feb 14
    // https://leetcode.com/problems/add-binary/
    // 67. Add Binary
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0; // to count the carry bits

        while (i >= 0 || j >= 0) {
            // make a temp vairbale sum which will store the sum of 2 value at each
            // iteration
            int sum = carry;

            // pick the last of string a and convert it into int
            if (i >= 0) {
                sum = sum + a.charAt(i) - '0';
            }

            if (j >= 0) {
                sum = sum + b.charAt(j) - '0';
            }

            sb.append(sum % 2); // store if the num of ith and jth one is 2 to store 0 at that index and more
            // the next 1 to the carry.
            carry = sum / 2;

            i--;
            j--;
        }
        // if something is left in carry
        if (carry != 0) {
            sb.append(carry);
        }
        // return the revse of the string as we are iterating from the back and storing
        // it in the sequence manner
        return sb.reverse().toString();

    }

    // https://leetcode.com/problems/add-to-array-form-of-integer/description/
    // 15 Feb 2023
    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>();

        int curr = k;
        int n = num.length;
        while (--n >= 0 || curr > 0) {
            if (n >= 0) {
                curr = curr + num[n];
            }
            list.add(curr % 10);
            curr = curr / 10;
        }

        Collections.reverse(list);
        return list;
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

    // Feb 17
    
    Integer pre = null;
    Integer res = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        
        return getminDiffInBST(root);
    }

    private int getminDiffInBST(TreeNode root) {
        if(root==null){
            return 0;
        } 
        getminDiffInBST(root.left);
        if(pre != null){
            // If we have iterated the 1st ele in in order and we are at the root node of the left mosr tree
            // We will store the difference in root.val and pre
            res = Math.min(res, root.val - pre); 
        }
        // starting me pre will be none so the current node which will be the lastmost last one in case of inorder whill be the pre
        pre = root.val;
        getminDiffInBST(root.right);

        return res;
    }

    // day 19
    // 103. Binary Tree Zigzag Level Order Traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();       
        
        //  Performing level order traversal
        zzloHelper(root, ans, 0);   
        return ans;

    }

    public static void zzloHelper(TreeNode root, List<List<Integer>> res , int level){
        
        if(root == null){
            return;
        }
    
        // check if the new Arraylist is presnet for the current level
        if(level >= res.size()){
            // means here is no arraylist for the current level
            // so create new arrayList for this level
            res.add(level, new ArrayList<>());
        }

        // we want zig zag so what we can do is reverse the every odd level
        if (level % 2 ==0){
            // even level
            res.get(level).add(root.val);
        }else{
            // odd level
            // here waht we are doing is add new new element of that level to 0th position so all next will 
            //  shifted
            res.get(level).add(0,root.val);
        }

        // goto left and right and increae the level
        zzloHelper(root.left, res, level+1);
        zzloHelper(root.right, res, level+1);

    }

    // 35. Search Insert Position
    // 20 feb
    class Solution {
    public int searchInsert(int[] nums, int target) {
        // iTerate in the nums suppose the current number is greater then or equal to the target means that positionwould be the postion of out target   so return that if not found in the nums means it element is greater then all the lements in the nums it would be at the last position after the last so return nums.length
        for(int i = 0; i< nums.length; i++){
            if(nums[i]>= target){
                return i;
            }
        }
        // element not found
        return nums.length;
    }

    // 21 feb 2023
    // 540. Single Element in a Sorted Array
    public int singleNonDuplicate(int[] nums) {
        int xor = 0;
        for(int i = 0; i< nums.length; i++){
            xor = xor ^ nums[i];
        }
        return xor;
    }
}

}