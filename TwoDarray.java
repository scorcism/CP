import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoDarray {

    public static void main(String[] args) {
        int[][] arr = {
                { 3, 4, 11, 45 },
                { 2, 12, 211, 40 },
                { 7, 8, 7, 4 },
        };
        int[][] arr2 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        // rowSum(arr);
        // System.out.println(wavePrint(arr));
        // System.out.println(spiralOrder(arr2));
        // rotate(arr2);
        // for(int a[]: arr2){
        // System.out.println(Arrays.toString(a));
        // }

    }

    // Linear search in 2d array
    public static void linearSearch(int[][] arr) {
        // normal traversals
    }

    // Row wise sum
    public static void rowSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        int row = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[0].length; j++) {
                sum += arr[i][j];
            }
            if (max < sum) {
                max = sum;
                row = i;
            }

            System.out.println(sum);
        }
        System.out.println(row);
    }

    public static ArrayList<Integer> wavePrint(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int col = 0; col < n; col++) {

            if ((col & 1) != 0) {
                // odd
                for (int row = m - 1; row >= 0; row--) {
                    ans.add(arr[row][col]);
                }
            } else {
                // even
                for (int row = 0; row < m; row++) {
                    ans.add(arr[row][col]);
                }
            }
        }
        return ans;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;

        int startrow = 0;
        int endrow = row - 1;
        int startcol = 0;
        int endcol = col - 1;

        while (startrow <= endrow && startcol <= endcol) {

            // print left to right
            for (int index = startcol; index <= endcol; index++) {
                ans.add(matrix[startrow][index]);
            }
            startrow++;

            // print top to bottom
            for (int index = startrow; index <= endrow; index++) {
                ans.add(matrix[index][endcol]);
            }
            endcol--;

            // print right to left
            for (int index = endcol; endcol >= 0 && index >= startcol; index--) {
                ans.add(matrix[endrow][index]);
            }
            endrow--;
            // print bottom to up
            for (int index = endrow; index >= startrow; index--) {
                ans.add(matrix[index][startcol]);
            }
            startcol++;
        }
        return ans;
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = t;
            }
        }
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // try to assume the matrix as a linear matrix
        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // we have to find element at mid;
            int r = mid / n;
            int c = mid % n;
            int element = matrix[r][c];

            if (element == target) {
                return true;
            }
            if (element < mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrixii(int[][] matrix, int target) {
        // squeezing the search space

        int row = matrix.length;
        int col = matrix[0].length;

        int rowindex = 0;
        int colindex = col -1;

        while(rowindex < row && colindex >=0){
            int ele  = matrix[rowindex][colindex];

            if(ele == target){
                return true;
            }
            if(ele < target){
                rowindex++;
            }else{
                colindex--;
            }
        }

        return false;
    }
}