package Revision;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;

public class Backtracking {
    public static void main(String[] args) {

    }


    
    // Rat in a Maze Problem - I
    public static ArrayList<String> findPath(int[][] m, int n) {
        // TC -> 4^(n*n)
        // SC -> O(n*n)
        ArrayList<String> ans = new ArrayList<>();

        int[][] vis = new int[n][n];

        if (m[0][0] == 1) {
            fpSolve(m, n, 0, 0, "", ans, vis);
        }
        return ans;
    }

    private static void fpSolve(int[][] m, int n, int i, int j, String moves, ArrayList<String> ans, int[][] vis) {
        if (i >= n - 1 && j >= n - 1) {
            ans.add(moves);
            return;
        }
        // move in all 4 directions
        // in lexical order i.r D-L-R-U

        // Down
        if (i + 1 < n && vis[i + 1][j] != 1 && a[i + 1][j] == 1) {
            vis[i][j] = 1;
            fpSolve(m, n, i + 1, j, moves + "D", ans, vis);
            vis[i][j] = 0;
        }

        // Left
        if (j - 1 >= 0 && vis[i][j - 1] != 1 && a[i][j - 1] == 1) {
            vis[i][j] = 1;
            fpSolve(m, n, i, j - 1, moves + "L", ans, vis);
            vis[i][j] = 0;
        }

        // RIGHT
        if (j + 1 < n && vis[i][j + 1] != 1 && a[i][j + 1] == 1) {
            vis[i][j] = 1;
            fpSolve(m, n, i, j + 1, moves + "R", ans, vis);
            vis[i][j] = 0;
        }

        // Up
        if (i - 1 >= 0 && vis[i - 1][j] != 1 && a[i - 1][j] == 1) {
            vis[i][j] = 1;
            fpSolve(m, n, i - 1, j, moves +
                    "U", ans, vis);
            vis[i][j] = 0;
        }
    }

    private static void fpSolve2(int[][] a, int n, int i, int j, String moves, ArrayList<String> ans, int[][] vis) {
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
                fpSolve2(a, n, newrow, newcol, moves + directions.charAt(index), ans, vis);
                vis[newrow][newcol] = 0;
            }
        }

    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        ArrayList<String> paths = new ArrayList<>();
        pallindromePartiioning(s, 0, paths, ans);
        return ans;
    }

    static void pallindromePartiioning(String s, int index, ArrayList<String> paths, List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(paths));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPallindromePossible(s, index, i)) {
                paths.add(s.substring(index, i + 1));
                pallindromePartiioning(s, index + 1, paths, ans);
                paths.remove(path.size() - 1);
            }
        }

    }

    static boolean isPallindromePossible(String s, int x, int y) {
        while (x < y) {
            if (s.charAt(x) != s.charAt(y)) {
                return false;
            }
            x++;
            y--;
        }
        return true;
    }

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

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                board[j][i] = '.';
            }
        }
        solveQueens(0, board, ans, n);
        return ans;
    }

    private void solveQueens(int col, char[][] board, List<List<String>> ans, int n) {

        if (col == board.length) {
            ans.add(contruct(board));
            return;
        }

        // iterate in each row of the current col
        for (int row = 0; row < board.length; row++) {
            if (canfill(row, col, board)) {
                board[row][col] = 'Q';
                solveQueens(col + 1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }

    private List<String> contruct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    private boolean canfill(int row, int col, char[][] board) {

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

    // optimized method
    public List<List<String>> solveNQueens2(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                board[j][i] = '.';
            }
        }
        int[] forRow = new int[n];
        int[] forLowerDiagonal = new int[2 * n - 1];
        int[] forUpperDiagonal = new int[2 * n - 1];

        solveQueens2(0, board, ans, n, forRow, forLowerDiagonal, forUpperDiagonal);
        return ans;
    }

    private void solveQueens2(int col, char[][] board, List<List<String>> ans, int n, int[] forRow,
            int[] forLowerDiagonal, int[] forUpperDiagonal) {

        if (col == board.length) {
            ans.add(contruct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (forRow[row] == 0 && forLowerDiagonal[row + col] == 0 && forUpperDiagonal[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                forRow[row] = 1;
                forLowerDiagonal[row + col] = 1;
                forUpperDiagonal[n - 1 + col - row] = 1;
                solveQueens2(col + 1, board, ans, n, forRow, forLowerDiagonal, forUpperDiagonal);
                board[row][col] = '.';
                forRow[row] = 0;
                forLowerDiagonal[row + col] = 0;
                forUpperDiagonal[n - 1 + col - row] = 0;
            }
        }

    }

}
