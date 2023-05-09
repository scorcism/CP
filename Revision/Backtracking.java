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
}