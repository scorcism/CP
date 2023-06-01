import java.util.*;

public class Day23 {

    // Graph
    public static void main(String[] args) {

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