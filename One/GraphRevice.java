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

    
    // Q: Find the number of connected components. 

    public static void main(String[] args) {
        
    }
}