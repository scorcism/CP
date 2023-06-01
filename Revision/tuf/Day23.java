import java.util.*;

public class Day23 {

    // Graph
    public static void main(String[] args) {

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