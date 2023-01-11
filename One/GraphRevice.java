import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class GraphRevice{

    
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int V){

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];

        ArrayList<Integer> ans = new ArrayList<>();

        q.add(0);
        visited[0] = true;

        // to store the answer
        while(!q.isEmpty()){
            int curr = q.peek();
            q.remove();
            ans.add(curr);
            for(Integer it: adj.get(curr)){
                if(visited[it] == false){
                    visited[it] = true;
                    q.add(it);
                }
            }
        }
        return ans;
    }
    
    // Q: FInd the minimum distance between source to destination.
    static boolean minDistance(ArrayList<ArrayList<Integer>> adj, int src, int dest, int V,int[] pred, int[] dist){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[V];

        for(int i = 0; i< V ; i++){
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        visited[src] = true;
        dist[src] = 0;
        q.add(src);

        while(!q.isEmpty()){
            int curr = q.remove();
            
            for(Integer it: adj.get(curr)){
                if(visited[it] == false){
                    visited[it] = true;
                    dist[it] = dist[curr] + 1;
                    pred[it] = curr;
                    q.add(it);

                    if(it == dest){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Q: Find the number of connected components. 
    static int countConnected(ArrayList<ArrayList<Integer>> adj, int V){
        int count = 0;
        boolean[] visited = new boolean[V];

        for(int i  = 1; i <= V; i++){
            if(!visited[i]){
                count++;
                bfs(adj, i);
            }
        }



        return count;
    }

    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj, int V){
        ArrayList<Integer> ans = new ArrayList<>();

        boolean[] visited = new boolean[V];

        dfsUtil(adj,0,visited,ans);

        return ans;
    }

    private static void dfsUtil(ArrayList<ArrayList<Integer>> adj, int v, boolean[] visited, ArrayList<Integer> ans) {
        visited[v] = true;
        ans.add(v);

        for(Integer it: adj.get(v)){
            if(!visited[it]){
                visited[it] = true;
                dfsUtil(adj, it, visited, ans);
            }
        }
    }

    static class isC{
        int parent;
        int current_node;

        isC(int a, int b){
            this.parent  = a;
            this.current_node = b;
        }
    }

    static boolean isCyclicbfs(int V, ArrayList<ArrayList<Integer>> adj){

        boolean visited[] = new boolean[V];

        for(int i = 0; i< V; i++){
            if(isCyclicUtil(i, adj,visited)){
                return true;
            }
        }
        return false;
    }


    private static boolean isCyclicUtil(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {

        visited[i] = true;

        Queue<isC> q = new LinkedList<isC>();

        // add source and -1 to the parent
        q.add(new isC(i, -1));

        while(!q.isEmpty()){
            int p = q.peek().parent;
            int n = q.peek().current_node;
            q.poll();

            for(Integer it: adj.get(n)){
                if(!visited[it]){
                    visited[it] = true;
                    q.add(new isC(p, it));
                }
                if(p == it){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isCyclicdfs(ArrayList<ArrayList<Integer>> adj, int V){

        boolean[] visited = new boolean[V];

        for(int i = 0; i< V; i++){
            if(isCyclicdfsUtil(i,adj,visited,-1)){
                return true;
            }
        }
        return false;
    }

    private static boolean isCyclicdfsUtil(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {
        visited[i] = true;

        for(Integer it: adj.get(i)){
            if(!visited[it]){
                visited[it] = true;
                if(isCyclicdfsUtil(it,adj,visited,i)){
                    return true;
                }
                else if(parent == it){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);


        // ArrayList < Integer > ans = bfs(adj,5);
        // System.out.println(ans);
    }
}