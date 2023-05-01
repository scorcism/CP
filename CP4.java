import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class CP4 {
    public static void main(String[] args) {
        // lps("acccbaaacccbaac");
        // System.out.println(transform("abcd", "efgh"));

        int[][] A = {
                { 1, 2, 3 },
                { 4, 0, 6 },
                { 7, 8, 9 }
        };
        int[][] A2 = {
                { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 },
        };

        // setZeroes2(A2);
        // for (int[] a : A2) {
        // System.out.println(Arrays.toString(a));
        // }
        int[][] arr = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        // System.out.println(spiralOrder(arr));
        // rotate2(arr);
        // fill0X(5, 6);

        int[] arr2 = { 4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6 };
        // nextGreater(arr2);
        // previousSmaller(arr2);
        // nextSmaller(arr2);
        // largestrectangleArea(arr2);

        // System.out.println(setBits(787897));
        // singleNumber(new int[] { 2, 1, 3, 2 });
    }

    public static void singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        System.out.println(xor);
        // get the right most set bit
        xor = (xor & -(xor - 1));
        System.out.println("-xor "  + xor);
        int x = 0;
        int y = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & xor) > 0) {
                System.out.println((nums[i]&xor) + " &");
                x = x ^ nums[i];
            } else {
                y = y ^ nums[i];
            }
        }
        System.out.println(x + " " + y);
    }

    static int setBits(int N) {
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            if (((N >> i) & 1) == 1) {
                // System.out.println("in");
                count++;
            }
        }
        return count;
    }

    int largestrectangleAreaOptimized(int[] height) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        int n = height.length;
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || height[st.peek()] >= height[i])) {
                int h = height[st.peek()];
                st.pop();
                int width = 0;
                if (st.isEmpty()) {
                    width = i;
                } else {
                    width = i - st.peek() - 1;
                }
                max = Math.max(max, width * h);
            }
            st.push(i);
        }
        return max;
    }

    // for previous one's run loop from 0>n
    // for next ones run toop form n -> 0
    public static int largestrectangleArea(int[] height) {
        int max = 0;
        int n = height.length;
        int[] ps = new int[n];
        int[] ns = new int[n];
        Stack<Integer> st = new Stack<>();
        // previous smaller
        for (int i = 0; i < n; i++) {
            // coz we are working with indices
            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ps[i] = 0;
            } else {
                ps[i] = st.peek() + 1;
            }
            st.add(i);
        }
        // empty the stack for recuse
        while (!st.isEmpty()) {
            st.pop();
        }
        // next smaller
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ns[i] = n - 1;
            } else {
                ns[i] = st.peek() - 1;
            }
            st.add(i);
        }
        // iterating in all the index
        for (int i = 0; i < n; i++) {
            max = Math.max(max, (ns[i] - ps[i] + 1) * height[i]);
        }

        return max;
    }

    public static void nextSmaller(int[] arr) {
        int n = arr.length;
        int[] ns = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ns[i] = n - 1;
            } else {
                ns[i] = st.peek() - 1;
            }
            st.add(i);
        }
        System.out.println(Arrays.toString(ns));
    }

    public static void previousSmaller(int[] arr) {
        int n = arr.length;
        int[] ps = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                ps[i] = 0;
            } else {
                ps[i] = s.peek() + 1;
            }
            s.add(i);
        }
        System.out.println(Arrays.toString(ps));
    }

    public static void nextGreater(int[] arr) {
        int n = arr.length;
        int[] ngr = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = (2 * n) - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= arr[i % n]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                ngr[i % n] = s.peek();
            } else {
                ngr[i % n] = -1;
            }
            s.add(arr[i % n]);
        }
        System.out.println(Arrays.toString(ngr));
        // TC ->
    }

    public static void fill0X(int m, int n) {
        char p = 'X';
        int startrow = 0;
        int endrow = m - 1;
        int startcol = 0;
        int endcol = n - 1;

        char[][] arr = new char[m][n];

        while (startrow <= endrow && startcol <= endcol) {
            for (int i = startcol; i <= endcol; i++) {
                arr[startrow][i] = p;
            }
            startrow++;
            for (int i = startrow; i <= endrow; i++) {
                arr[i][endcol] = p;
            }
            endcol--;
            if (startcol <= endcol) {
                for (int i = endcol; i >= startcol; i--) {
                    arr[endrow][i] = p;
                }
            }
            endrow--;
            if (startrow <= endrow) {
                for (int i = endrow; i >= startrow; i--) {
                    arr[i][startcol] = p;
                }
            }
            startcol++;

            // change char
            p = (p == '0') ? 'X' : '0';
        }
        for (char[] c : arr) {
            System.out.println(Arrays.toString(c));
        }
    }

    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {
        // code here
        HashSet<Integer> ans = new HashSet<>();
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n1 && j < n2 && k < n3) {
            if (A[i] == B[j] && B[j] == C[k]) {
                ans.add(A[i]);
                i++;
                j++;
                k++;
            } else if (A[i] < B[j]) {
                i++;
            } else if (B[j] < C[k]) {
                j++;
            } else {
                k++;
            }
        }
        ArrayList<Integer> ans2 = new ArrayList<>(ans);
        Collections.reverse(ans2);
        return ans2;
    }

    static char[][] fill(int n, int m, char a[][]) {
        // The idea is that if there is any 0 in edge then all the connected 0 cannot be
        // replaced to 0 as if will not follow the rule.
        // iterating in all th boundary and rinning a dfs and if 0 is found marking all
        // the 0 with 1
        // code here
        int[][] vis = new int[n][m];

        // for 1st col and last col
        for (int i = 0; i < n; i++) {
            if (a[0][i] == 'O') {
                fillDfs(0, i, a, vis);
            }
            if (a[n - 1][i] == 'O') {
                fillDfs(n - 1, i, a, vis);
            }
        }
        // for 1st row and last row
        for (int i = 0; i < m; i++) {
            if (a[i][0] == 'O') {
                fillDfs(i, 0, a, vis);
            }
            if (a[i][m - 1] == 'O') {
                fillDfs(i, m - 1, a, vis);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'O' && vis[i][j] == 0) {
                    a[i][j] = 'X';
                }

            }
        }

        return a;

    }

    private static void fillDfs(int i, int j, char[][] a, int[][] vis) {
        // mark the current one has visited
        vis[i][j] = 1;

        // check all the four sides
        int[] deltarow = { -1, 0, +1, 0 };
        int[] deltacol = { 0, +1, 0, -1 };

        for (int k = 0; k < 4; k++) {
            int newI = i + deltarow[k];
            int newJ = j + deltacol[k];

            if (newI >= 0 && newJ >= 0 && newI < a.length && newJ < a[0].length && a[newI][newJ] == 'O'
                    && vis[newI][newJ] == 0) {
                fillDfs(newI, newJ, a, vis);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        boolean vis[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && vis[i][j] == false) {
                    count++;
                    numIslandsBFS(grid, i, j, vis);
                }
            }
        }

        return count;
    }

    static class PairsIsland {
        int i;
        int j;

        PairsIsland(int a, int b) {
            this.i = a;
            this.j = b;
        }
    }

    private static void numIslandsBFS(char[][] grid, int i, int j, boolean[][] vis) {

        Queue<PairsIsland> q = new LinkedList();

        q.add(new PairsIsland(i, j));
        vis[i][j] = true;

        while (!q.isEmpty()) {
            PairsIsland value = q.peek();
            int r = value.i;
            int s = value.j;
            q.poll();

            int[] fori = { -1, -1, 0, +1, +1, +1, 0, -1 };
            int[] forj = { 0, +1, +1, +1, 0, -1, -1, -1 };

            for (int k = 0; k < 8; k++) {
                int newI = r + fori[k];
                int newJ = s + forj[k];

                if (newI >= 0 && newJ >= 0 &&
                        newI < grid.length && newJ < grid[0].length &&
                        grid[newI][newJ] == '1' && vis[newI][newJ] == false) {
                    vis[newI][newJ] = true;
                    q.add(new PairsIsland(newI, newJ));
                }

            }
        }
    }

    public boolean exist(char[][] board, String word) {
        // using dfs
        int m = board.length;
        int n = board[0].length;
        boolean vis[][] = new boolean[m][n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(k) &&
                        searchWord(i, j, k, vis, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(int i, int j, int k, boolean[][] vis, char[][] board, String word) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || board[i][j] != word.charAt(k) || vis[i][j]) {
            return false;
        }

        // look for all four sides
        if (searchWord(i + 1, j, k + 1, vis, board, word) ||
                searchWord(i - 1, j, k + 1, vis, board, word) ||
                searchWord(i, j + 1, k + 1, vis, board, word) ||
                searchWord(i, j - 1, k + 1, vis, board, word)) {
            return true;
        }

        return false;
    }

    public static void rotate2(int[][] matrix) {
        int m = matrix.length;

        // get the transpose
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // for(int a[]: matrix){
        // System.out.println(Arrays.toString(a));
        // }
        // reverse each row in transpose
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][m - j - 1];
                matrix[i][m - j - 1] = tmp;
            }
        }
        // for(int a[]: matrix){
        // System.out.println(Arrays.toString(a));
        // }
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int startrow = 0;
        int startcol = 0;
        int endrow = m - 1;
        int endcol = n - 1;

        while (startcol <= endcol && startrow <= endrow) {
            // move left to right
            for (int i = startcol; i <= endcol; i++) {
                ans.add(matrix[startrow][i]);
            }
            startrow++;

            // move top to bottom
            for (int i = startrow; i <= endrow; i++) {
                ans.add(matrix[i][endcol]);
            }
            endcol--;

            // move right to left
            if (startcol <= endcol) {

                for (int i = endcol; i >= startcol; i--) {
                    ans.add(matrix[endrow][i]);
                }
            }
            endrow--;

            // move bottom to top
            if (startcol <= endcol) {
                for (int i = endrow; i >= startrow; i--) {
                    ans.add(matrix[i][startcol]);
                }
            }
            startcol++;

        }
        return ans;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        ArrayList<Integer> ans = new ArrayList<>();

        int startrow = 0;
        int endrow = m - 1;
        int startcol = 0;
        int endcol = n - 1;

        while (startrow <= endrow && startcol <= endcol) {
            for (int i = startcol; i <= endcol; i++) {
                ans.add(matrix[startrow][i]);
                // System.out.println(matrix[startrow][i]);
            }
            startrow++;

            for (int i = startrow; i <= endrow; i++) {
                ans.add(matrix[i][endcol]);
                // System.out.println(matrix[i][endcol]);
            }
            endcol--;

            for (int i = endcol; startrow <= endrow && i >= startcol; i--) {
                ans.add(matrix[endrow][i]);
            }
            endrow--;

            for (int i = endrow; startrow <= endrow && i >= startrow; i--) {
                ans.add(matrix[i][startcol]);
            }
            startcol++;
        }

        return ans;
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Better approach
        int[] row = new int[m];
        int[] col = new int[n];
        Arrays.fill(row, -1);
        Arrays.fill(col, -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {

                    row[i] = 0;
                    col[j] = 0;
                }
                // System.out.println();
            }
        }

        // System.out.println(Arrays.toString(row));
        // System.out.println(Arrays.toString(col));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 0 || col[j] == 0) {
                    // System.out.print(row[i] + " " + j + " i j ");
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Optimal approach
        int col00 = 1;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col00 = 0;
                // if we have any 0 in any of the 1st row column we mark it with coll00 with
                // false so the row 00 will not be affected
            }
            // starting form 1st col coz the 0th col will be handled by col00 variable
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        // iterating form back side coz if we start from the front side the 00 or 01 or
        // 10 wil affect the row or col
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col00 == 0) {
                matrix[i][0] = 0;
            }
        }
    }

    static ArrayList<Integer> downwardDiagonal(int N, int A[][]) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans.add(A[i][j]);
            }
        }

        return ans;
    }

    public static int transform(String A, String B) {
        // code here
        int n = A.length() - 1;
        int m = B.length() - 1;

        if (n != m) {
            return -1;
        }

        int[] char_count = new int[26];
        for (int i = 0; i < n; i++) {
            char_count[A.charAt(i)]++;
            char_count[B.charAt(i)]--;
        }

        for (int k : char_count) {
            if (k != 0) {
                return -1;
            }
        }

        int i = n - 1, j = n - 1;
        int res = 0;
        while (i >= 0 && j >= 0) {
            while (i >= 0 && A.charAt(i) != B.charAt(j)) {
                i--;
                res++;
            }

            i--;
            j--;
        }

        return res;

    }

    public static boolean match(String wild, String pattern) {
        return matchfunc(wild, wild.length() - 1, pattern, pattern.length() - 1);
    }

    public static void lps(String s) {
        // code here
        int[] lpss = new int[s.length()];
        int i = 1;
        int j = 0;
        lpss[0] = 0;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                lpss[i] = j;
                i++;
            } else {
                if (j != 0) {
                    j = lpss[j - 1];
                } else {
                    lpss[i] = 0;
                    i++;
                }
            }
        }
        System.out.println(Arrays.toString(lpss));
    }

    public static boolean matchfunc(String w, int wlen, String p, int plen) {

        if (wlen < 0 && plen < 0) {
            return true;
        }

        if (wlen < 0 && plen >= 0) {
            return false;
        }

        if (wlen >= 0 && plen < 0) {
            for (int i = 0; i < wlen; i++) {
                if (w.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (w.charAt(wlen) == p.charAt(plen) || w.charAt(wlen) == '?') {
            return matchfunc(w, wlen - 1, p, plen - 1);
        }

        if (w.charAt(wlen) == '*') {
            return (matchfunc(w, wlen - 1, p, plen) || matchfunc(w, wlen, p, plen - 1));
        }

        return false;

    }

    public static String smallestWindow(String s, String p) {
        int slen = s.length();
        int plen = p.length();

        if (plen > slen) {
            return "-1";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = map.size();

        int end = 0;
        int start = 0;
        int minStart = 0;
        int maxEnd = 0;
        int windowSize = Integer.MAX_VALUE;

        while (end < slen) {
            char charAtend = s.charAt(end);
            if (map.containsKey(charAtend)) {
                map.put(s.charAt(end), map.get(s.charAt(end)) - 1);

                if (map.get(s.charAt(end)) == 0) {
                    count--;
                }
            }

            while (count == 0) {
                char charAtstart = s.charAt(start);
                if (windowSize > end - start + 1) {
                    windowSize = end - start + 1;
                    minStart = start;
                    maxEnd = end + 1;
                }

                if (map.containsKey(charAtstart)) {
                    map.put(charAtstart, map.get(charAtstart) + 1);

                    if (map.get(charAtstart) == 1) {
                        count++;
                    }
                }
                start++;
            }
            end++;

        }

        // return windowSize>0?s.substring(minStart, maxEnd):"-1";
        // System.out.println(windowSize);
        if (windowSize != Integer.MAX_VALUE && windowSize > 0) {
            return s.substring(minStart, maxEnd);
        } else {

            String minus1 = new String("-1");
            return minus1;
        }
    }

}

class BitTricks extends NumberTheory {
    // ODD EVEN
    /*
     * ODD number lsb(least significant bit) is 1
     * EVEN number lsb is 0
     */
    public void checkodd(int n) {
        if ((n & 1)) {
            // If the condition eveluates true means we have 1 in the lsb so this evaluates
            // true
            System.out.println("ODD");
        } else {
            System.out.println("EVEN");
        }
    }

    public void AtoZee() {
        for (char i = 'A'; i <= 'Z'; ++i) {
            System.out.println(i);
            printBinary(i - '0');
        }
    }

    public void atozee() {
        for (char i = 'a'; i <= 'z'; ++i) {
            System.out.println(i);
            printBinary(i - '0');
        }
    }
    // After this if we observer an pattern, we can see that the 5th bit in 'A' is
    // set bit and in 'a' it
    // is not set. SO out task will be to unset the 5th bit or set the 5th to
    // convert to convert it to
    // lowercase or uppercase respectively

    // Convert 'A' to 'a'
    // set the 5th bit
    public void Atoa1(char c) {
        int a = c | (1 << 5);
        System.out.println((char) a);
    }

    // Convert 'a' to 'A'
    // unset 5th bit
    public void atoA1(char c) {
        System.out.println((char) (c & (~(1 << 5))));
    }

    /*
     * If we have a closer look we can see that
     * space(" ") is represented by 1<<5
     */

    // Convert 'A' to 'a'
    // set the 5th bit
    public void Atoa2(char c) {
        int a = c | ' ';
        System.out.println((char) a);
    }

    /*
     * ASCII of ~(1<<5) doest not exist but as per over oberservation to unset the
     * 5th bit
     * we can use 111101111 (000101111) with & operation to convert uppercase to
     * lower case
     * 000101111 is binary for '_' so we can use '_'
     * 
     */
    // Convert 'a' to 'A'
    // unset 5th bit
    public void atoA2(char c) {
        System.out.println((char) (c & '_'));
    }

    public void summaryCapitaltoSmall() {

        /*
         * To convert A to a "perform or operation wth ' '(space)"
         * To convert a to A "perform and operation with '_'(underscore)"
         */

        // A to a
        char A = 'A';
        char a = A | ' ';
        // System.out.println(char(a));

        // a to A
        char a = 'a';
        char A = a & '_';
        // System.out.println(char(A));
    }

    public void clearLSBTilli(int a, int i) {

        int b = (a & (~((1 << i + 1) - 1)));
        /*
         * Number - 15 -> 1111 clear till 1st
         * so we need 1100 then we can perform & operation on the Number to get the
         * desired one.
         * 1100 we can get using ~0011
         * and 0011 we can get using (0100 -1 )
         * and 0100 we cn get using (1<i+1)
         * 
         * (1<<i+1) -> 0100
         * (1<<i+1)-1 -> 0011
         * ~(1<<i+1)-1 -> 1100
         * n& ~(1<<i+1)-1 -> 1111 & (1100)
         */

        printBinary(b);
    }

    public void clearMSBTilli(int a, int i) {

        int b = (a & ((1 << i + 1) - 1));
        /*
         * ( _ is or understanding )
         * Number = 0000_0111_011 clear msb i
         * o/p = 0000_0001_011
         * 0000_0110_11 & (0000_0001_111)
         * 
         * 0000_0001_111 we can get using 0000_0010_000
         * 0000_0010_000 we can get using (1<<i+1)
         * 
         * (1<<i+1)
         * (1<<i+1)-1
         * a & (1<<i+1)-1
         */

        printBinary(b);
    }

    // check power of 2
    public void checkPower2(int n) {
        if (n & (n - 1)) {
            System.out.println("Not Power of 2");
        } else {
            System.out.println("Power of 2");
        }
    }

}

class NumberTheory {

    // Decimal to Binary
    public void printBinary(int n) {
        for (int i = 10; i >= 0; --i) {
            System.out.print((n >> i) & 1);
        }
        System.out.println();
    }

    // Check ith bit set or not
    public void checkIthSet(int n, int i) {
        int mask = (1 << i);
        if ((n & mask) != 0) {
            System.out.println("set bit");
        } else {
            System.out.println("unset bit");
        }
    }

    // check ith unset bit
    public void checkIthUnset(int n, int i) {
        int mask = (1 << i);
        if ((n & (~mask)) != 0) {
            System.out.println("unset bit at i");
        } else {
            System.out.println("no unset bit at i");
        }
    }

    // Toggle ith bit
    public void toggleIth(int n, int i) {
        int mask = (1 << i);
        int toggled = (n ^ mask);
        printBinary(toggled);
    }

    public static void subsetXOR(int[] arr) {
        int n = arr.length;
        int subset_count = (1 << n); // 2^n
        for (int mask = 0; mask > subset_count; mask++) {
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                // check for set bit at ith position
                if ((mask & (1 << i)) != 0) {
                    ans.add(arr[i]);
                }
            }
            System.out.println(ans);
        }
    }

}
