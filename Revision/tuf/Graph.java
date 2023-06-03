import java.util.*;

public class Graph {
    // more GRAPH question

    public static void main(String[] args) {

    }

    // Rotton oranges
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxTime = 0;
        int countFresh  = 0;
        int[][] vis = new int[n][m];
        Queue<PairRO> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new PairRO(i, j, 0));
                    vis[i][j] = 2;
                }else{
                    vis[i][j] = 0;
                }
                if(grid[i][j]==1){
                    countFresh++;
                }
            }
        }
        int count = 0;
        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};

        while(!q.isEmpty()){
            PairRO node = q.poll();
            maxTime = Math.max(maxTime, node.time);
            
            for(int i = 0; i< 4; i++){
                int nrow = node.row+ drow[i];
                int ncol = node.col+ dcol[i];
                if(nrow >= 0 && nrow < n && ncol >=0 && ncol < m && grid[nrow][ncol]==1 && vis[now][ncol]!=2 ){
                    q.add(new PairRO(nrow,ncol,node.time+1));
                    vis[nrow][ncol] = 1;
                    count++;
                }
            }

        }
        if(count != countFresh){
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
