import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Queue;


class DailyChallenges {

    // fab 9
    // https://leetcode.com/problems/as-far-from-land-as-possible/
    class MaxDistanceClass {
        int row;
        int col;
        int step;

        MaxDistanceClass(int row, int col, int step) {
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }

    public int maxDistance(int[][] grid) {
        int ans = Integer.MIN_VALUE;

        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int[][] distance = new int[n][m];

        Queue<MaxDistanceClass> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new MaxDistanceClass(i, j, 0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int s = q.peek().step;
            distance[r][c] = s;
            q.remove();
            int[] delrow = { -1, 0, 1, 0 };
            int[] delcol = { 0, 1, 0, -1 };

            for (int i = 0; i < 4; i++) {
                int newrow = delrow[i] + r;
                int newcol = delcol[i] + c;

                if (newrow >= 0 && newcol >= 0 && newrow < n &&
                        newcol < m && vis[newrow][newcol] == 0) {
                    q.add(new MaxDistanceClass(newrow, newcol, s + 1));
                    vis[newrow][newcol] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, distance[i][j]);
            }
        }
        return ans;
    }

    // Fab 10
    // https://leetcode.com/problems/shortest-path-with-alternating-colors/
    // 1129. Shortest Path with Alternating Colors
    static class SATNode{
        int node;
        int steps;
        int preColor;

        SATNode(int a, int b, int c){
            this.node = a;
            this.steps = b;
            this.preColor = c;
        }
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // create adj list of the following matrix
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();

        for(int[] re: redEdges){
            adj.computeIfAbsent(re[0],k -> new ArrayList<List<Integer>>()).add(Arrays.asList(re[1],0));
        }

        for(int[] be : blueEdges){
            adj.computeIfAbsent(be[0], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(be[1],1));
        }

        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        boolean[][] visited = new boolean[n][2];

        Queue<int[]> q = new LinkedList<>();

        visited[0][0]  = visited[0][1] = true;
        q.offer(new int[] {0,0,-1});
        answer[0] = 0;
        while(!q.isEmpty()){
            int[] element=  q.poll();

            int node = element[0];
            int steps = element[1];
            int prevColor = element[2];

            if(!adj.containsKey(node)){
                continue;
            }

            for(List<Integer> nei: adj.get(node)){
                int neighbor = nei.get(0);
                int color=  nei.get(1);

                if(!visited[neighbor][color] && color!= prevColor){
                    if(answer[neighbor]==-1){
                        answer[neighbor] =  1+steps;
                    }
                    visited[neighbor][color] = true;
                    q.offer(new int[] {neighbor, 1+steps, color} );
                }
            }

        }

        return answer;
    }

    // Feb 11
    // https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/description/
    // 2477. Minimum Fuel Cost to Report to the Capital
    long minFuel = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        // convert this roads to adj list
        int n = roads.length+1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< n+1; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        

        for(int[] cur: roads){
            adj.get(cur[0]).add(cur[1]);
            adj.get(cur[1]).add(cur[0]);
            indegree[cur[0]]++;
            indegree[cur[1]]++;
        }
        
        return minimumFuelCostBFS(adj,seats,indegree,n);
        
    }
    private long minimumFuelCostBFS(ArrayList<ArrayList<Integer>> adj, int seats, int[] indegree, int n) {
        
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i< n ;i++){
            if(indegree[i]==1){
                q.offer(i);
            }
        }

        int[] representative = new int[n];
        Arrays.fill(representative, 1);
        long minFeul = 1;

        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();

            minFeul += Math.ceil((double)representative[node]/seats);

            for(int neighbor: adj.get(node)){
                indegree[neighbor]--;
                representative[neighbor]+=representative[node];
                if(indegree[neighbor] == 1 && neighbor != 0){
                    q.offer(neighbor);
                }
            }
        }
        return minFeul;

    }

    
}