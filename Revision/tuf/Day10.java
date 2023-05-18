import java.util.*;

public class Day10 {

    // commit template -> tuf-day10-questionname
    public static void main(String[] args) {

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