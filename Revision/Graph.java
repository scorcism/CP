import java.util.*;

public class Graph {
    // more GRAPH question

    public static void main(String[] args) {

    }


    
    // Implementing Dijkstra Algorithm
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<PairD> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);

        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);

        pq.add(new PairD(0, S));
        dist[S] = 0;

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int dis = pq.peek().distance;
            pq.poll();

            for (int it = 0; it < adj.get(node).size(); it++) {
                int adjNode = adj.get(node).get(it).get(0);
                int edgeWeight = adj.get(node).get(it).get(1);

                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new PairD(dist[adjNode], adjNode));
                }
            }
        }

        return dist;

    }

    static class PairD {
        int distance;
        int node;

        PairD(int d, int n) {
            this.distance = d;
            this.node = n;
        }
    }

    // Shortest path in Undirected Graph having unit distance
    public int[] shortestPathUndirected(int[][] edges, int n, int m, int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;
        q.add(src);
        while (!q.isEmpty()) {
            int top = q.poll();

            for (int it : adj.get(top)) {
                if (dist[top] + 1 < dist[it]) {
                    dist[it] = dist[top] + 1;
                    q.add(it);
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }

    // Shortest path in Directed Acyclic Graph
    public int[] shortestPath(int N, int M, int[][] edges) {
        ArrayList<ArrayList<PairshortestPath>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<PairshortestPath>());
        }

        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new PairshortestPath(v, wt));
        }

        Stack<Integer> st = new Stack<>();
        int[] vis = new int[N];
        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                dfsTopo(i, adj, vis, st);
            }
        }

        // Step 2;
        int[] dist = new int[N];
        Arrays.fill(dist, (int) 1e9);

        dist[0] = 0;
        while (!st.isEmpty()) {
            int top = st.pop();

            for (int i = 0; i < adj.get(top).size(); i++) {
                int v = adj.get(top).get(i).v;
                int weight = adj.get(top).get(i).weight;

                // perform relaxation
                if (dist[top] + weight < dist[v]) {
                    dist[v] = dist[top] + weight;
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }

    private void dfsTopo(int i, ArrayList<ArrayList<PairshortestPath>> adj, int[] vis, Stack<Integer> st) {
        vis[i] = 1;

        for (int k = 0; k < adj.get(i).size(); k++) {
            int v = adj.get(i).get(k).v;
            if (vis[v] == 0) {
                dfsTopo(v, adj, vis, st);
            }
        }

        st.push(i);
    }

    static class PairshortestPath {
        int v;
        int weight;

        PairshortestPath(int v, int w) {
            this.v = v;
            this.weight = w;
        }
    }

    // Alien Dictionary
    public String findOrder(String[] dict, int N, int K) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        ArrayList<Integer> topo = topoSortBFS(K, adj);
        String s = "";

        for (int x : topo) {
            s = s + (char) (x + (int) 'a');
        }
        return s;

    }

    private static ArrayList<Integer> topoSortBFS(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return topo;
    }

    // Rotton oranges
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxTime = 0;
        int countFresh = 0;
        int[][] vis = new int[n][m];
        Queue<PairRO> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new PairRO(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }
        int count = 0;
        int[] drow = { -1, 0, +1, 0 };
        int[] dcol = { 0, +1, 0, -1 };

        while (!q.isEmpty()) {
            PairRO node = q.poll();
            maxTime = Math.max(maxTime, node.time);

            for (int i = 0; i < 4; i++) {
                int nrow = node.row + drow[i];
                int ncol = node.col + dcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[now][ncol] != 2) {
                    q.add(new PairRO(nrow, ncol, node.time + 1));
                    vis[nrow][ncol] = 1;
                    count++;
                }
            }

        }
        if (count != countFresh) {
            return -1;
        }
        return maxTime;
    }

    static class PairRO {
        int row;
        int col;
        int time;

        PairRO(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

}
