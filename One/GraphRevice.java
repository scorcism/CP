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



    public static void main(String[] args) {
        
    }
}