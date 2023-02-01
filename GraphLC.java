import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class GraphLC {

    public static void main(String[] args) {

    }

    public static boolean validTree(int n, int[][] edges) {
        // create a graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            // undirected graph
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);

        int size = 0;
        for(int i = 0 ; i< n; i++){
            if(visited[i] == 1){
                size =+1;
            }
        }

        return vtDFS(0, -1, adj, visited) && (n == size);
        // n==size is to check if there is connected components or not.
    }

    public static boolean vtDFS(int currNode, int previous_node, ArrayList<ArrayList<Integer>> adj, int[] visited) {

        // the node is already visited
        // so there can be a loop
        if (visited[currNode] != -1) {
            return false;
        }

        visited[currNode] = 1;

        for (int it : adj.get(currNode)) {
            if (it == previous_node) {
                // check for parent
                continue;
            }
            // recursive call for the other nodes
            if (!vtDFS(it, currNode, adj, visited)) {
                return false;
            }
        }

        return true;
    }

}
