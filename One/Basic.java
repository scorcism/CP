import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Basic {

    public static void reverseNumber(int n) {
        int number = n;
        int sum = 0;

        while (number > 0) {
            int tmp = number % 10;
            System.out.println("tmp: " + tmp);
            sum = tmp + (sum * 10);
            System.out.println("sum: " + sum);
            number = number / 10;
            System.out.println("number: " + number);
        }

        System.out.println(sum);

    }

    static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[0][j] + " ");
            }
            System.out.println();
        }
    }

    static void setZerosBrute(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // assumption if matrix[i][j] > 0

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    // iterate in the row and col and mark them with -1
                    for (int r = i; r < row; r++) {
                        if (matrix[r][j] != 0) {
                            matrix[r][j] = -1;
                        }
                    }
                    for (int r = i; r < row; r++) {
                        if (matrix[r][j] != 0) {
                            matrix[r][j] = -1;
                        }
                    }
                    for (int c = j; c < col; c++) {
                        if (matrix[i][c] != 0) {
                            matrix[i][c] = -1;
                        }
                    }

                    // int[] drow = {-1,0,+1,0};
                    // int[] dcol = {0,1,0,-1};

                    // for(int r = i ; r )

                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static void transposeMatrix(int[][] matrix) {
        // for (int i = 0; i < mat.length ; i++) {
        // for (int j = i; j < mat[0].length ; j++) {
        // int tmp = mat[i][j];
        // mat[i][j] = mat[j][i];
        // mat[j][i] = tmp;
        // }
        // }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        // reverseNumber(321);
        int[][] mat = { { 1, 2, 3,6 }, { 4, 0, 6,7}, { 7, 8, 9,8 },{3,6,8,2} };
        // printMatrix(mat);
        // setZerosBrute(mat);
        // int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // for (int[] m : mat) {
        //     System.out.println(Arrays.toString(m));
        // }
        // System.out.println(mat.length);
        // System.out.println(mat[0].length);
        // transposeMatrix(mat);

        mapFunction();
    }

    static void mapFunction(){
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        
        System.out.println(map);
        map.remove(2,"Two");
        System.out.println(map);


    }   
}
