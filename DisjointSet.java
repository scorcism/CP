public class DisjointSet {
    int[] rank, parent;
    int n;

    DisjointSet(int n) {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /*
     * 
     * int find(int x) {
     * if (parent[x] == x) {
     * return x;
     * }
     * return find(parent[x]);
     * }
     */

     int find(int x){
        if(parent[x] != x){
            parent[x] = find(x);
        }

        return parent[x];
     }

    void union(int a, int b) {
        int xRoot = find(a);
        int yRoot = find(b);

        // same parent
        if (xRoot == yRoot) {
            return;
        }

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }

    }

}
