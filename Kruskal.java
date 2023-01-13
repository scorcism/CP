import java.util.ArrayList;
import java.util.Collections;

class DisjointSet{
    int[] rank;
    int[] parent;
    int n;

    DisjointSet(int n){
        this.n = n;
        rank = new int[n];
        parent = new int[n];

        for(int i = 0; i<n ; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find(int x){
        if(parent[x] != x){
            parent[x] = find(x);
        }

        return parent[x];
    }

    void union(int x, int y){
        int xRoot = find(x);
        int yRoot = find(y); 

        if(xRoot == yRoot){
            return;
        }

        if(rank[xRoot] < rank[yRoot]){
            parent[xRoot] = yRoot;
        }else if(rank[xRoot] > rank[yRoot]){
            parent[yRoot] = xRoot;
        }else{
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] +1;
        }
    }

}


public class Kruskal {
    
    static class Edge implements Comparable<Edge>{
        int u;
        int v;
        int weight;

        Edge(int _u, int _v, int _weight){
            this.u = _u;
            this.v = _v;
            this.weight = _weight;
        }


        public int compareTo(Edge that){
            return this.weight - that.weight;
        }
    }


    /*
     * T.C -> V + ElogE + V => O(ElogE)
     * S.C => O(E+V)
     */
    static int spanning_tree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        // here we have given adj matrix
        // we have to convert this into edges
        int ans = 0;

        ArrayList<Edge> edges = new ArrayList<>();

        for(int i = 0; i< adj.size(); i++){
            for(int j = 0; j< adj.get(i).size(); j++){
                int adjNode  = adj.get(i).get(j).get(0);
                int wt  = adj.get(i).get(j).get(1);

                int node =  i;
                Edge tmp = new Edge(i, adjNode, wt);
                edges.add(tmp);
            }
        }

        DisjointSet ds = new DisjointSet(V);
        Collections.sort(edges);

        for(int i  = 0; i< edges.size(); i++){
            int wt = edges.get(i).weight;
            int u = edges.get(i).u;
            int v = edges.get(i).v;

            if(ds.find(u)!=ds.find(v)){
                ans += wt;
                ds.union(u, v);
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        
    }
}
