
import java.util.*;

public class Day3 {

    // commit syntax -> tuf-day3-Questionname
    public static void main(String[] args) {

    }

    public boolean searchMatrix3(int[][] matrix, int target) {
        // squeezing the matrix
        int n = matrix.length;
        int m = matrix[0].length;

        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public boolean searchMatrix4(int[][] matrix, int target) {
        //
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = (n * m) - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // get the element at mid
            int eleAtMid = matrix[mid / m][mid % m];
            if (eleAtMid == target) {
                return true;
            } else if (eleAtMid < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

}
