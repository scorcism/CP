import java.util.*;

public class DFS {
    
    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls){
        vis[node] = true;
        ls.add(node);

        for (Integer it : adj.get(node)) {
            if(vis[node] == false){
                dfs(it, vis, adj, ls);
            }
        }
    }

    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        
        // Boolean array to keep track of visited vertices
        boolean vis[] = new boolean[V+1];
        vis[0] = true;
        
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(V, vis, adj, ls);

        return ls;
    }

    public static void main(String[] args) {
        
    }
}
