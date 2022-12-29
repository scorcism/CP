import java.util.*;

public class Code {    
    
    static public int[][] transposeMatrix(int[][] matrix){
        for(int i = 0; i< matrix.length; i++){
            for(int j = i; j < matrix[0].length ; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        return matrix;
    }


    public static void main(String[] args) {
    
        // Implement queue using 2 stack
        int[][] matr = {{1,2,3},{4,5,6},{7,8,9}};

        for(int[] it: transposeMatrix(matr)){

            System.out.println(Arrays.toString(it));
        }

    }
}
