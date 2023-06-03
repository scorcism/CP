import java.util.*;

public class Day23 {

    // Graph
    public static void main(String[] args) {

    }

    // Is Graph Bipartite?
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];

        for (int i = 0; i < len; i++) {
            //This graph might be a disconnected graph. So check each unvisited node.
            if (colors[i] != 0) {
                continue;
            }

            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            colors[i] = 1;

            while (!q.isEmpty()) {
                int curr = q.poll();
                for (int it : graph[curr]) {
                    if (colors[it] == 0) { // if it is not colord
                        colors[it] = -colors[curr]; // colour it will the opp and put it into q
                        q.offer(it);
                    } else if (colors[it] != -colors[curr])
                    // If it is colored and its color is different, return false;
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Number of Islands
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == false && grid[i][j] == '1') {
                    count++;
                    islandsBFS(i, j, vis, grid);
                }
            }
        }
        return count;
    }

    private void islandsBFS(int ro, int co, boolean[][] vis, char[][] grid) {
        vis[ro][co] = true;
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        q.add(new Pair(ro, co));

        int drow[] = { -1, 0, +1, 0 };
        int dcol[] = { 0, -1, 0, +1 };

        while (!q.isEmpty()) {
            Pair node = q.poll();
            int row = node.row;
            int col = node.col;
            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && !vis[nrow][ncol]) {
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    // Course Schedule
    public boolean canFinish(int V, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int n : adj.get(i)) {
                indegree[n]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        int count = 0;

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return count == V;
    }

    // Detect cycle in a directed graph - BSF
    private static boolean isCyclicBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        // perform topologiccal sort
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int n : adj.get(i)) {
                indegree[n]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        if (count == V) {
            return false;
        } else {
            return true;
        }
    }

    // Topological sort -> BFS
    static int[] topoSort_KahnsAlgo_BFS(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int n : adj.get(i)) {
                indegree[n]++;
            }
        }
        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int[] topo = new int[V];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            topo[i++] = node;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return topo;
    }

    // Topological sort -> DFS
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topoDFS(i, vis, adj, st);
            }
        }

        int[] ans = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.pop();
        }
        return ans;
    }

    private static void topoDFS(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = true;
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                topoDFS(it, vis, adj, st);
            }
        }
        st.push(node);
    }

    // Detect cycle in a directed graph
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (detectDirectedCycle(i, adj, vis, pathVis) == true) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean detectDirectedCycle(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis) {
        vis[i] = true;
        pathVis[i] = true;

        // traverse for adjacent nodes
        for (int it : adj.get(i)) {
            if (!vis[it]) {
                if (detectDirectedCycle(it, adj, vis, pathVis)) {
                    return true;
                }
            } else if (pathVis[it]) {
                return true;
            }
        }
        pathVis[i] = false;
        return false;
    }

    // Detect A cycle in Undirected Graph using DFS
    public boolean isCycleDFS(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean vis[] = new boolean[V + 1];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (detectCycleDFS(i, -1, adj, vis)) {
                    return true;
                }

            }
        }
        return false;
    }

    static boolean detectCycleDFS(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                if (detectCycleDFS(it, node, adj, vis)) {
                    return true;
                }
                ;
            } else if (it != parent) {
                return true;
            }
        }
        return false;
    }

    // Detect A cycle in Undirected Graph using BFS
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (detectCycle(i, vis, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean detectCycle(int src, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        while (!q.isEmpty()) {
            Pair node = q.poll();
            for (int it : adj.get(node.node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(new Pair(it, node.node));
                } else if (it != node.parent) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Pair {
        int node;
        int parent;

        Pair(int n, int p) {
            this.node = n;
            this.parent = p;
        }
    }

    // BFS of graph
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V + 1];
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return ans;
    }

    // DFS of Graph
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] vis = new int[V + 1];
        dfs(0, adj, vis, ans);
        return ans;
    }

    private void dfs(int v, ArrayList<ArrayList<Integer>> adj, int[] vis, ArrayList<Integer> ans) {
        vis[v] = 1;
        ans.add(v);

        for (int it : adj.get(v)) {
            if (vis[it] == 0) {
                dfs(it, adj, vis, ans);
            }
        }
    }
}