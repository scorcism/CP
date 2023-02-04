import java.util.Arrays;

public class Basic {
    
    public static void reverseNumber(int n){
        int number = n;
        int sum = 0;

        while(number > 0){
            int tmp = number % 10;
            System.out.println("tmp: " + tmp);
            sum = tmp + (sum * 10);
            System.out.println("sum: " + sum);
            number = number / 10;
            System.out.println("number: " + number);
        }

        System.out.println(sum);

    }

    static void printMatrix(int[][] a){
        for(int i = 0; i < a.length; i++){
            for(int j = 0 ; j< a[0].length; j++){
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
                if(matrix[i][j] == 0){
                    // iterate in the row and col and mark them with -1
                    for(int r = i; r < row ; r++){
                        if(matrix[r][j] != 0){
                            matrix[r][j] =  -1;
                        }
                    }
                    for(int r = i; r < row ; r++){
                        if(matrix[r][j] != 0){
                            matrix[r][j] =  -1;
                        }
                    }
                    for(int c = j; c < col ; c++){
                        if(matrix[i][c] != 0){
                            matrix[i][c] =  -1;
                        }
                    }

                    // int[] drow = {-1,0,+1,0};
                    // int[] dcol = {0,1,0,-1};
                    
                    // for(int r = i ; r )

                }
            }
        }

        for(int i  = 0; i< row; i++){
            for(int j = 0; j< col ; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int[] a: matrix){
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        // reverseNumber(321);
        int[][] mat = {{1,2,3},{4,0,6},{7,8,9}};
        // printMatrix(mat);
        setZerosBrute(mat);
    }
}
