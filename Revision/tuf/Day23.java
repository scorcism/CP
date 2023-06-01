import java.util.*;

public class Day23 {

    // Graph
    public static void main(String[] args) {

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