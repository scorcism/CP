
import java.util.*;

public class Main {

    public static void main(String[] args) {

    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], (int) 1e9);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.add(new int[] { 0, 0, 0, 0 });

        int[][] directions = {
                { -1, 0 },
                { 1, 0 },
                { 0, -1 },
                { 0, 1 }
        };

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int v = curr[1];

            if (u == m - 1 && v == n - 1) {
                break;
            }

            for (int[] d : directions) {
                int n_u = u + d[0];
                int n_v = v + d[1];

                if (n_u < 0 || n_v < 0 || n_u >= m || n_v >= n) {
                    continue;
                }

                int newWt = Math.max(curr[2], Math.abs(heights[u][v] - heights[n_u][n_v]));

                if (newWt < dist[n_u][n_v]) {
                    pq.add(new int[] { n_u, n_v, dist[n_u][n_v] = newWt });
                }
            }
        }

        return dist[m - 1][n - 1];
    }

    public int minCostConnectPoints(int[][] points) {
        int sum = 0;

        int n = points.length;
        boolean[] visited = new boolean[n];

        int reqEdges = n - 1;

        PriorityQueue<PairST> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        int[] cord1 = points[0];

        for (int i = 0; i < points.length; i++) {
            int[] cord2 = points[i];
            int wt = Math.abs(cord2[0] - cord1[0]) + Math.abs(cord2[1] - cord1[1]);
            pq.add(new PairST(0, i, wt));
        }

        visited[0] = true;

        while (!pq.isEmpty() && reqEdges > 0) {
            PairST pair = pq.poll();
            int u = pair.node;
            int v = pair.dist;
            int wt = pair.cost;

            if (!visited[v]) {
                sum += wt;
                visited[v] = true;

                for (int i = 0; i < n; i++) {
                    if (!visited[i]) {
                        int dist = Math.abs(points[v][0] - points[i][0]) + Math.abs(points[v][1] - points[i][1]);

                        pq.add(new PairST(v, i, dist));
                    }
                }
                reqEdges--;
            }
        }

        return sum;
    }

    class PairST {
        int node;
        int dist;
        int cost;

        PairST(int n, int d, int c) {
            this.node = n;
            this.dist = d;
            this.cost = c;
        }
    }

    class Node {
        TreeNode node;
        int level;

        Node(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public int maxLevelSumOwn(TreeNode root) {
        Queue<Node> q = new LinkedList<>();
        int l = 0;
        int maxsum = Integer.MIN_VALUE;

        q.add(new Node(root, 1));

        while (!q.isEmpty()) {

            int size = q.size();

            int level = 0;

            int sum = 0;

            for (int i = 0; i < size; i++) {
                Node n = q.poll();

                sum += n.node.val;

                level = n.level;

                if (n.node.left != null) {
                    q.add(new Node(n.node.left, level + 1));
                }
                if (n.node.right != null) {

                    q.add(new Node(n.node.right, level + 1));
                }

            }
            if (maxsum < sum) {
                maxsum = sum;
                l = level;
            }
        }
        return l;

    }

    int minDiff = Integer.MAX_VALUE;
    TreeNode parent = null;

    public int getMinimumDifference(TreeNode root) {
        getMin(root);
        return minDiff;
    }

    void getMin(TreeNode root) {
        if (root == null) {
            return;
        }
        getMin(root.left);
        if (parent != null) {
            minDiff = Math.min(minDiff, parent.val - root.val);
        }
        parent = root;
        getMin(root.right);
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

    // Biweekly Contest 104
    // https://leetcode.com/contest/biweekly-contest-104/problems/number-of-senior-citizens/
    public int countSeniors(String[] details) {
        int n = 0;
        for (String s : details) {
            int first = s.charAt(11) - '0';
            int second = s.charAt(12) - '0';
            // System.out.println("f: " + first);
            // System.out.println("s: " + second);
            //
            int age = (first * 10) + second;
            // System.out.println(age);
            // System.out.println(age + " age");

            if (age >= 60) {
                n++;
            }
        }
        return n;
    }

    public int matrixSum(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;

        long ans = 0;

        for (int i = 0; i < m; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, nums[j][i]);
            }
            ans += max;
        }
        return (int) ans;
    }

    public int matrixSum2(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;

        long ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, nums[j][i]);
            }
            set.add(max);
            // ans+=max;
        }
        for (int i : set) {
            ans += i;
        }
        return (int) ans;
    }

    public long maximumOr(int[] nums, int k) {
        long ans = 0;

        long curr_ans = 0;
        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            int num_choosen = nums[i];
            int t_k = k;
            while (t_k >= 0) {
                num *= 2;
            }

            curr_ans |= num;
            for (int nu = 0; nu < nums.length; nu++) {
                if (nums[nu] != num_choosen) {
                    curr_ans |= nums[nu];
                }
            }
            ans = Math.max(curr_ans, ans);
        }
        return ans;
    }

    public long maximumOrdp(int[] nums, int k) {
        return getmaxOr(nums, 0, 0, k, 0);
    }

    private long getmaxOr(int[] nums, int i, int prek, int k, long a) {
        if (i == nums.length) {
            return a;
        }
        while (prek < k) {
            nums[i] *= 2;
            prek++;
        }
        // long localans = 0;
        for (int p = 0; p < nums.length; p++) {
            a |= nums[p];
        }

        long one = getmaxOr(nums, i, prek + 1, k, a);
        long two = getmaxOr(nums, i + 1, prek, k, a);
        return Math.max(one, two);
    }
}
