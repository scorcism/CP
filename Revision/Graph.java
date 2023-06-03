import java.util.*;

public class Graph {
    // more GRAPH question

    public static void main(String[] args) {

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
