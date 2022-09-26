import java.util.*;



class Recursion {

    public static void base(int n) {
        // This is called a base condition
        if (n <= 10) {
            return;
        }
        System.out.println(n);
        n++;
        base(n);
    }

    public static void printName(String name, int n) {
        if (n < 1) {
            return;
        }

        System.out.println(name);
        printName(name, n - 1);
    }

    public static void printNumber1(int s, int e) {
        if (s > e) {
            return;
        }
        System.out.println(s);
        printNumber1(s + 1, e);
    }

    public static void printNumber2(int e) {
        if (e < 1) {
            return;
        }
        System.out.println(e);
        printNumber2(e - 1);
    }

    public static void printNumber3(int n) {
        if (n < 1) {
            return;
        }
        printNumber3(n - 1);
        System.out.println(n);
    }

    // public static void printName(int n){

    // }

    public static int sum1(int n, int sum) {
        if (n < 0) {
            System.out.println(sum);
            return 0;
        }

        return sum1(n - 1, sum + n);
    }

    public static int sum2(int n) {
        if (n < 1) {
            return 0;
        }
        return (n + sum2(n - 1));
    }

    public static int factorial1(int n) {
        if (n < 1) {
            return 1;
        }
        return n * factorial1(n - 1);
    }

    public static boolean palindrome1(String n, int s) {
        if (s >= (n.length() / 2)) {
            return true;
        }

        if (n.charAt(s) != n.charAt((n.length() - s) - 1)) {
            return false;
        }

        return palindrome1(n, s + 1);
    }

    public static int fibo1(int n) {
        // 0 1 1 2 3 5 8 13 21
        // eg 5th fibo => 5
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }

        return fibo1(n - 2) + fibo1(n - 1);
    }

    // public static int subSequence(String text){
    // // This can be done using Power-Set

    // }

    public static void powerset(String text, int index, String curr) {
        if (index == text.length()) {
            System.out.println(curr);
            return;
        }
        powerset(text, index + 1, curr + text.charAt(index));
        powerset(text, index + 1, curr);

    }

    // public static void permutation(String text, int index, String curr){

    // }
    public static void subSequenceSumK(int[] array, List<Integer> tmp, int sum, int index, int K) {
        int n = array.length;
        if (index == n) {
            if (sum == K) {
                for (int i = 0; i < tmp.size() - 1; i++) {
                    System.out.println(tmp.get(i));
                }
            }
            System.out.println(tmp.get(index));
            return;

        }
        System.out.println(array[index]);
        tmp.add(array[index]);
        sum = sum + array[index];
        subSequenceSumK(array, tmp, sum, index + 1, K);
        sum = sum - array[index];
        tmp.remove(array[index]);
        subSequenceSumK(array, tmp, sum, index + 1, K);

    }

    public static void combinationSum(int[] array, int index, int target, ArrayList<Integer> ds) {
        if (index == array.length) {
            if (target == 0) {
                for (int i = 0; i < ds.size(); i++) {
                    System.out.print(ds.get(i));
                }
                System.out.print(" ");
            }
            return;
        }
        if (array[index] <= target) {
            ds.add(array[index]);
            combinationSum(array, index, target - array[index], ds);
            ds.remove(ds.size() - 1);
        }
        combinationSum(array, index + 1, target, ds);
    }

    public static void callCombination(int[] array, int target) {
        ArrayList<Integer> ds = new ArrayList<Integer>();
        int index = 0;
        combinationSum(array, index, target, ds);
    }

    public static void findCombination(int[] array, int target, List<Integer> ds, int index) {
        if (target == 0) {
            for (int i = 0; i < ds.size(); i++) {
                System.out.println(ds.get(i));
                System.out.println(" ");
                return;
            }
        }

        for (int i = index; i < array.length; i++) {
            if (i > index && array[i] == array[i - 1]) {
                continue;
            }
            if (array[i] > target) {
                break;
            }
            ds.add(array[i]);
            findCombination(array, target - array[i], ds, i + 1);
            ds.remove(ds.size() - 1);
        }

    }

    public static void combinationII(int[] array, int target) {
        Arrays.sort(array);
        ArrayList<Integer> ds = new ArrayList<Integer>();
        findCombination(array, 4, ds, 0);
    }

    public static void getSums(int[] array, int n, int sum, ArrayList<Integer> ds, int index) {
        if (index == n) {
            ds.add(sum);
            // System.out.println(sum);

            return;
        }

        getSums(array, n, sum + array[index], ds, index + 1);
        getSums(array, n, sum, ds, index + 1);

    }

    public static void subsetSums(int[] array) {
        ArrayList<Integer> ds = new ArrayList<Integer>();
        int n = array.length;
        int sum = 0;

        getSums(array, n, sum, ds, 0);
        Collections.sort(ds);
        for (int i = 0; i < ds.size(); i++) {
            System.out.println(ds.get(i));
        }
    }

    public static void getSubsetII(int index, int[] array, List<List<Integer>> ans, List<Integer> ds) {
        ans.add(new ArrayList<>(ds));
        for (int i = index; i < array.length; i++) {
            if (i != index && array[i] == array[i - 1]) {
                continue;
            }
            ds.add(array[i]);
            getSubsetII(i + 1, array, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }

    public static void subsetSumII(int[] array) {
        // With no duplicates
        List<List<Integer>> ans = new ArrayList<>();
        getSubsetII(0, array, ans, new ArrayList<>());
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static void getPermutations(int n, int[] array, List<List<Integer>> ans, ArrayList<Integer> ds,
            boolean[] map) {
        if (ds.size() == n) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!map[i]) {
                map[i] = true;
                ds.add(array[i]);
                getPermutations(n, array, ans, ds, map);
                ds.remove((ds.size() - 1));
                map[i] = false;
            }
        }
    }

    public static void permuteI(int[] array) {
        List<List<Integer>> ans = new ArrayList<>(); // To hold final answers
        // List<Integer> ds = new ArrayList<>(); // To hold answers at each recursion
        // level
        boolean[] map = new boolean[array.length];
        int n = array.length;
        getPermutations(n, array, ans, new ArrayList<>(), map);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static void swap(int[] array, int a, int b) {
        a = array[a] ^ array[b];
        b = array[a] ^ array[b];
        a = array[a] ^ array[b];
    }

    public static void getPermutationII(int[] array, int n, List<List<Integer>> ans, int index) {
        if (index == array.length) {
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < array.length; i++) {
                ds.add(array[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            getPermutationII(array, n, ans, index + 1);
            swap(array, i, index); // This is used for backtracking
        }
    }

    public static void permuteII(int[] array) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = array.length;
        int index = 0;
        getPermutationII(array, n, ans, index);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static boolean isSafe(int row,int column, int[][] board, int n)
    {
        while(row >= 0 && column >= 0){
            // Coz we are checking for top right diagonal elements.
            // This is to check for the diagonal element.

            if(board[row][column] == 'Q') return false;
            column--;
            row--;
        }

        // Checking for column
        while(column>=0){
            if(board[row][column] == 'Q') return false;
            column--;
        }

        // Checking for lower diagonal elements
        while(row>=0 && column >= 0){
            if(board[row][column] == 'Q'){
                return false;
            }
            column--;
            row++;
        }

        return true;
    }

    // public static List<List<String>> NQueens(int n){

    // }

    // public static List<List<Integer>> solveNQueens(int n) {
    //     List<List<Integer>> ans = new ArrayList<>();
    //     int[] array = new int[n];
    //     Arrays.fill(array,0);


    //     return ans;
    // }

    public static boolean isValid(char[][] board, int row, int column, char ch){
        for(int i = 0; i<=8; i++){
            if(board[row][i] == ch){
                return false;
            }
            if(board[i][column] == ch){
                return false;
            }
            if(board[3 * (row / 3) + i/3][3*(column/3) +i % 3] == ch){
                return false;
            }
        }
        return true;
    }

    public static boolean solve(char[][] board){
        for(int i = 0; i< board.length ; i++){
            for (int j = 0; j < board[0].length ; j++){
                if(board[i][j] == '.'){
                    for(char ch = '1'; ch <= '9'; ch++){
                        if(isValid(board,i,j,ch)){
                            board[i][j] = ch;

                            if(solve(board) == true){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }                
            }
        }
        return true;
    }



    public static void main(String[] args) {

        int[] array = { 1, 2, 2 };
        // subsetSums(array);
        // subsetSumII(array);

        // permuteII(array);

        //


        // combinationII(array,4);


        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        solve(board);

        for(int i = 0; i< board.length; i++){
            for(int j = 0;j<board[0].length; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

        /**
         * // base(1);
         * // Print name 5 time
         * String name = "Abhishek";
         * // printName(name,5);
         * 
         * // Print linearly from 1 to N
         * // printNumber1(1,10);
         * 
         * // Print from N to 1
         * // printNumber2(10);
         * 
         * // Print linearly from 1 to N ( But By Backtrack ) +1 is not allowed using
         * backtracing
         * // printNumber3(10);
         * 
         * // Print linearly from N to 1 ( But By Backtrack )
         * // Same :)
         * 
         * // Sum of 1st n number
         * // 1st way (Parameter way)
         * // sum1(3,0);
         * // 2nd way (Function way)
         * // System.out.println(sum2(3));
         * 
         * // System.out.println(factorial1(5));
         * 
         * // Reverse an array
         * // This requires pass by refrence but in java we cannot pass by reference
         * 
         * // check if the given string is palindrome or not
         * // if(palindrome1("madam",0)){
         * // System.out.println("palinform");
         * // }else{
         * // System.out.println("NOT palinform");
         * // }
         * 
         * 
         */

        // Multiple recursion calls
        // Fibonachi number
        // Given N we have to write a recursive function which will give us the nth
        // fibonachi number
        // System.out.println(fibo1(8));

        // Print all sub sequences
        // A contagious / non- contagious seq. which follows te order
        // subSequence("name");

        // Print all th subsets or subsequence
        // String name = "abc";
        // powerset(name,0,"");

        // List<Integer> list = new ArrayList<Integer>();
        // subSequenceSumK(array, list,0,0,3);

        // callCombination(array,2);

    }
}
