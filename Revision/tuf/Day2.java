package Revision.tuf;

import java.util.*;

public class Day2 {

    // Commit format => tuf-dayNo-ProblemName
    public static void main(String[] args) {

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
