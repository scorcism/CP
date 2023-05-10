package Revision.tuf;

import java.util.*;

public class Day2 {

    // Commit format => tuf-dayNo-ProblemName
    public static void main(String[] args) {

    }


    

    // 56. Merge Intervals
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        // check for empty intervals
        if (intervals.length == 0 || intervals == null) {
            return ans.toArray(new int[0][]);
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] first = intervals[0];
        for (int[] a : intervals) {
            if (a[0] <= first[1]) {
                // its merging time
                first[1] = Math.max(a[1], first[1]);
            } else {
                // not merging
                // add to the ans list
                ans.add(new int[] { first[0], first[1] });
                // make first to current one
                first = a;
            }
        }
        ans.add(new int[] { first[0], first[1] });
        return ans.toArray(new int[0][]);

    }

    // 48. Rotate Image
    public void rotate(int[][] matrix) {
        // O(N*N)
        // O(1)
        // get the transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                int tmp = matrix[i][matrix.length - i - 1];
                matrix[i][matrix.length - i - 1] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
}
