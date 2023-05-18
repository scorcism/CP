import java.util.*;

public class Day10 {

    // commit template -> tuf-day10-questionname
    public static void main(String[] args) {

    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        // TC -> 4^(n*n)
        // SC -> O(n*n)
        ArrayList<String> ans = new ArrayList<>();

        int[][] vis = new int[n][n];

        if (m[0][0] == 1) {
            fpSolve(m, n, 0, 0, ans, "", vis);
        }
        return ans;
    }

    private static void fpSolve(int[][] a, int n, int i, int j, ArrayList<String> ans, String moves, int[][] vis) {
        if (i >= n - 1 && j >= n - 1) {
            ans.add(moves);
            return;
        }

        int[] drow = { -1, 0, +1, 0 };
        int[] dcol = { 0, 1, 0, -1 };
        String directions = "DLRU";

        for (int index = 0; index < 4; index++) {

            int newrow = drow[index] + i;
            int newcol = dcol[index] + j;

            if (newrow >= 0 && newcol >= 0 && newrow < n && newcol < n && a[newrow][newcol] == 1
                    && vis[newrow][newcol] != 1) {
                vis[newrow][newcol] = 1;
                fpSolve(a, n, newrow, newcol, moves + directions.charAt(index), ans, vis);
                vis[newrow][newcol] = 0;
            }
        }

    }

    // M-Coloring Problem
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // T.C -> (N^M)
        // S.C -> (N+N)
        int color[] = new int[n];
        for (int i = 0; i < n; i++)
            color[i] = 0;
        if (graphColoringUtil(graph, m, color, 0, n) == false) {
            return false;
        }
        return true;
    }

    private boolean graphColoringUtil(boolean[][] graph, int m, int[] color, int node, int n) {
        if (node == n) {
            return true;
        }
        for (int c = 1; c <= m; c++) {
            if (issafetocolor(graph, node, color, c, n)) {
                color[node] = c;
                if (graphColoringUtil(graph, node + 1, color, c, n) == true) {
                    return true;
                }
                color[node] = 0;
            }
        }
        return false;
    }

    private boolean issafetocolor(boolean[][] graph, int node, int[] color, int c, int n) {
        for (int i = 0; i < n; i++) {
            if (graph[node][i] && c == color[i]) {
                return false;
            }
        }
        return true;
    }

    // sudoku solver
    public void solveSudoku(char[][] board) {
        solvingSudoku(board);
    }

    private boolean solvingSudoku(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (canFitNumber(i, j, board, k)) {
                            board[i][j] = k;
                            if (solvingSudoku(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean canFitNumber(int row, int col, char[][] board, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c)
                return false;
            if (board[row][i] == c)
                return false;

            // checking in the kube box
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

    // 51. N-Queens
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        solvenqueens(n, 0, board, ans);
        return ans;

    }

    private void solvenqueens(int n, int col, char[][] board, List<List<String>> ans) {

        if (n == col) {
            ans.add(convert(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                solvenqueens(n, col + 1, board, ans);
                board[row][col] = '.';
            }
        }
    }

    private List<String> convert(char[][] board) {
        List<String> l = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            l.add(s);
        }
        return l;
    }

    private boolean isSafe(int row, int col, char[][] board) {

        int drow = row;
        int dcol = col;

        // top left
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }

        // left
        row = drow;
        col = dcol;
        while (col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            col--;
        }

        row = drow;
        col = dcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q')
                return false;
            col--;
            row++;
        }

        return true;
    }

    // 46. Permutations
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        // solvepermute(nums, new ArrayList<Integer>(), flag, ans);
        solvepermute2(nums, 0, ans);
        return ans;
    }

    private void solvepermute(int[] nums, List<Integer> list, boolean[] flag, List<List<Integer>> ans) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));

        }

        for (int index = 0; index < flag.length; index++) {
            if (flag[index] = false) {
                flag[index] = true;
                list.add(nums[index]);
                solvepermute(nums, list, flag, ans);
                list.remove(list.size());
                flag[index] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    private void solvepermute2(int[] nums, int i, List<List<Integer>> ans) {
        if (i == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int p = 0; p < nums.length; p++) {
                list.add(nums[p]);
            }
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int index = i; index < nums.length; index++) {
            swap(nums, i, index);
            solvepermute2(nums, i + 1, ans);
            swap(nums, i, index);
        }
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}