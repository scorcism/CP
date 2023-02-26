import java.util.*;








class Temps {

    public static void printco(int row, int column) {
        for (int i = -1; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                int nrow = row + i;
                int ncol = column + j;
                // System.out.println("nrow: " + nrow + "ncol: " + ncol);
            }
        }
    }

}

class Tmp {

    public static  int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int dp[][] = new int[n+1][m+1];
        
        for(int j = 0; j<= m; j++){
            dp[0][j] = 0;
        }
        for(int i = 0; i<= n; i++){
            dp[i][0] = 0;
        }


        for(int i = 1; i<= n; i++){
            for(int j = 1; i<= m; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] =Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[n][m];

    }

    public static void main(String[] args) {

        System.out.println(longestCommonSubsequence("null", "ll"));

        // List<Integer> list  =new ArrayList<>();

        // list.add(0,12);
        // list.add(0,13);
        // list.add(0,14);
        // list.add(0,15);
        // list.add(0,16);


        // System.out.println(list);
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {2,3,4});
        list.add(new int[] {2,3,});
        list.add(new int[] {2,3,4,5});
        list.add(new int[] {2,3,4,1});

        // System.out.println(list.toArray(new int[list.size()][]));
        for(int[] r: list.toArray(new int[2][])){
            System.out.println(Arrays.toString(r));
        }


        int[] array = new int[10];
        // System.out.println(Arrays.toString(array));

        for (char i = 'A'; i <= 'A' + 5; i++) {
            // System.out.print(i + " ");
        }

        Temps t = new Temps();
        // t.printco(2, 2);

        // int[] ar = new int[7];
        // System.out.println(Arrays.toString(ar));

        int[] ar2 = { 1, 2, 3, 4, 5, 6, 7 };
        // Arrays.fill(ar2,11);

        // for(int i = ar2.length - 1; i >= 0 ; i--){
        // System.out.print(ar2{i} + " ");
        // }
        // System.out.println();

        // System.out.println(Arrays.toString(ar2));

        for (int i = 0; i < ar2.length; i++) {
            // System.out.println(ar2[i]);
        }

        int ar[] = { 2, 2, 1, 8, 3, 2, 2, 4, 2 };

        // To fill complete array with a particular
        // value
        // Arrays.fill(ar, 10);
        // System.out.println("Array completely filled" +
        // " with 10\n" + Arrays.toString(ar));

        // System.out.println(Arrays.toString(ar3));

        // List<Integer> list = new ArrayList<Integer>();
        // list.add(1);
        // list.add(12);
        // list.add(11);
        // list.add(21);
        // list.add(14);
        // System.out.println(list);
        // Collections.sort(list);
        // System.out.println(list);

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

        // char[][] board =
        // {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        // for(char i = '1'; i< '9'; i++){
        // System.out.println(i);
        // System.out.println(Arrays.toString(grid[i]));
        // for(int j = 0;j<board[0].length; j++){
        // System.out.print(board[i][j]);
        // }
        // System.out.println();
        // }
        int s = 8;
        boolean isWord[] = new boolean[s];
        isWord[0] = true;

        // System.out.println(Arrays.toString(isWord));

        int[] c = new int[5];
        // System.out.println(Arrays.toString(c));

        // System.out.println((int)1e9);
        // System.out.println(myAtoi("words and 987"));
    }

    static void tmp() {
        String s = "timetopractice";
        String t = "toct";

        int sLen = s.length();

        int tLen = t.length();

        if (tLen > sLen)
            System.out.println("Invalid Input");

        HashMap<Character, Integer> countMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int end = 0;

        int maxLen = Integer.MAX_VALUE;

        int maxStart = 0; // to track Start index of substring
        int maxEnd = 0; // to track End index of substring

        int count = countMap.size();

        while (end < sLen) {

            char tempCharEnd = s.charAt(end);

            if (countMap.containsKey(tempCharEnd)) {
                countMap.put(tempCharEnd, countMap.get(tempCharEnd) - 1);

                if (countMap.get(tempCharEnd) == 0) {
                    count--;
                }
            }

            while (count == 0) {
                if (maxLen > end - start + 1) {
                    maxLen = end - start + 1;
                    maxStart = start;
                    maxEnd = end + 1;
                }
                char tempCharStart = s.charAt(start);
                if (countMap.containsKey(tempCharStart)) {
                    countMap.put(tempCharStart, countMap.get(tempCharStart) + 1);
                    if (countMap.get(tempCharStart) > 0) {
                        count++;
                    }
                }
                start++;
            }
            end++;
        }
        System.out.println(maxLen);
        System.out
                .println("Start Index : " + maxStart + " End Index :" + maxEnd + ": " + s.substring(maxStart, maxEnd));
    }
    


    // User function Template for Java

    static public int search(String pat, String txt) {
        char[] p = new char[256];
        char[] s = new char[256];
        int count = 0;
        int K = pat.length();
        // put the count of occurance of pat in p
        for (int i = 0; i < K; i++) {
            p[pat.charAt(i)]++;
        }

        // acheive the windows size and
        for (int j = 0; j < K - 1; j++) {
            s[txt.charAt(j)]++;
        }

        // windows size is acheived work on the window size
        // for(int end = K-1,start = 0; start < txt.length(); start++, end++){

        // }

        return count;

    }

    public static int myAtoi(String s) {
        /*
         * We have to take care of 4 condiitons
         * 1) escape white spaces
         * 2) sign check
         * 3) overflow check
         * 4) valid input check
         */
        int result = 0;
        int sign = 1;
        int index = 0;
        int n = s.length();

        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        if (s.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        // System.out.println("Index: " + index);
        // while (index < n && s.charAt(index++) - '0' >= 0 && s.charAt(index++) - '0' <= 9) {
        //     int digit = s.charAt(index) - '0';
        //     System.out.println("Digit: " + digit);
        //     if (result > Integer.MAX_VALUE / 10
        //             || (digit > Integer.MAX_VALUE % 10 && result == Integer.MAX_VALUE / 10)) {
        //         return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        //     }
        //     result = result * 10 + digit;
        //     System.out.println("Index end: " + index);
        // }

        for (int i = index; i < n; i++) {
            if (i < n && s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                int digit = s.charAt(i) - '0';
                // System.out.println("Digit: " + digit);
                if (result > Integer.MAX_VALUE / 10
                        || (digit > Integer.MAX_VALUE % 10 && result == Integer.MAX_VALUE / 10)) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = result * 10 + digit;
                // System.out.println("Index end: " + index);
            }
        }

        return result * sign;
    }

}
