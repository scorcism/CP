import java.util.*;

class Tmp {

    public static void main(String[] args){
        // int[] ar = new int[7];
        // System.out.println(Arrays.toString(ar));
        
        int[] ar2 = {1,2,3,4,5,6,7};
        Arrays.fill(ar2,11);

        // for(int i = ar2.length - 1; i >= 0 ; i--){
        //     System.out.print(ar2{i} + " ");
        // }
        // System.out.println();

        // System.out.println(Arrays.toString(ar2));

            for(int i = 0; i<ar2.length; i++){
                System.out.println(ar2[i]);
            }

        int ar[] = {2, 2, 1, 8, 3, 2, 2, 4, 2};
  
        // To fill complete array with a particular
        // value
        Arrays.fill(ar, 10);
        // System.out.println("Array completely filled" +
                //   " with 10\n" + Arrays.toString(ar));

        
        // System.out.println(Arrays.toString(ar3));

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(12);
        list.add(11);
        list.add(21);
        list.add(14);
    //     System.out.println(list);
    //    Collections.sort(list);
    //    System.out.println(list);

    // String name = "Abhishek";
    // System.out.println(name.charAt(1));

    
    int grid[][] = { 
    { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
    { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
    { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
    { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
    { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
    { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
    { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
    { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
    { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
};

    // char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

    // for(char i = '1'; i< '9'; i++){
        // System.out.println(i);
        // System.out.println(Arrays.toString(grid[i]));
        // for(int j = 0;j<board[0].length; j++){
        //     System.out.print(board[i][j]);
        // }
        // System.out.println();
    // }
            int s = 8;
    boolean isWord[] = new boolean[s];
    isWord[0] = true;

    System.out.println(Arrays.toString(isWord));

    }
}