import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.swing.border.Border;

import java.util.LinkedList;
import java.util.HashSet;
import java.util.Queue;

class Interval {
    public int[][] mergeIntervals(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        if (intervals == null | intervals.length == 0) {
            return res.toArray(new int[0][]);
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] it : intervals) {
            if (it[0] <= end) 
                // merge
                end = Math.max(end, it[1]);
            } else {
                // put start and new end to the res
                res.add(new int[] { start, end });
                start = it[0];
                end = it[1];
            }
            // put last one into the res
            res.add(new int[]{start,end});
            
            return res.toArray(new int[0][]);
        }

    }

    public int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        // for(int[] it: intervals){
        // //
        // if(newInterval[1] < it[0]){
        // res.add(newInterval);
        // }
        // else if (newInterval[0] <= it[1]){
        // res.add(it);
        // newInterval = it;

        // }else{
        // newInterval[0] = Math.min(newInterval[0], it[0]);
        // newInterval[1] = Math.max(newInterval[1], it[1]);
        // }
        // }
        // res.add(newInterval);
        // return res.toArray(new int[res.size()][]);

        for (int[] it : intervals) {
            if (it[1] < newInterval[0]) {
                // put this into it into res coz it end is
                // less then the new interval end
                res.add(it);
            } else if (newInterval[1] < it[0]) {
                res.add(newInterval);
                newInterval = it;
            } else {
                newInterval[0] = Math.min(newInterval[0], it[0]);
                newInterval[1] = Math.max(newInterval[1], it[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);

    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int res = 0;
        int prevEnd = intervals[0][1];

        for (int[] it : intervals) {
            if (it[0] >= prevEnd) {
                prevEnd = it[1];
            } else {
                res += 1;
                prevEnd = Math.min(it[1], prevEnd);
            }
        }

        return res;
    }

    static public class Intervall {
        int start, end;

        Intervall(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean canAttendMeetings(List<Intervall> intervals) {
        // Write your code here

        Collections.sort(intervals, (a, b) -> a.start);

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }
        return true;
    }

    public int minMeetingRooms(List<Intervall> intervals) {
        // Write your code here
        // count of minimum meeting rooms required
        int count = 0;

        List<Integer> st = new ArrayList<>();
        List<Integer> et = new ArrayList<>();

        for (int i = 0; i < intervals.size(); i++) {
            st.add(intervals.get(i).start);
            et.add(intervals.get(i).end);
        }

        // iterate through the start and end which on is small increase the count and
        // move that pointer
        // if there is a tie between the start time and end time then
        // shift the end
        // if we are iterating thought the end so we will decrease the end pointer by 1
        // if no start time end
        int start = 0;
        int end = 0;

        // maintian the count at each level
        int c = 0;
        while (!st.isEmpty()) {
            if (st.get(start) < et.get(end)) {
                start++;
                c++;
            } else {
                end++;
                c++;
            }
            count = Math.max(c, count);
        }
        return count;
    }
}

class TrieNode {
    TrieNode[] links = new TrieNode[26];
    String word;

}

class General {

    public void infixToPostfix(String s) {
        // There will be 4 conditions

    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTree(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfsfw(board, i, j, root, res);
            }
        }
        return res;
    }
    static class TrieNode{
        TrieNode[] links = new TrieNode[26];
        String word;

    } 

    public void dfsfw(char[][] board, int i, int j, TrieNode parent, List<String> res) {
        char c = board[i][j];
        if (c == '#' || parent.links[c - 'a'] == null)
            return;
        parent = parent.links[c - 'a'];
        if (parent.links != null) {
            res.add("hghfgg");
            parent.links = null;
        }
        board[i][j] = '#';
        if (i > 0)
            dfsfw(board, i, j, parent, res);
        if (j > 0)
            dfsfw(board, i, j - 1, p, res);
        if (i < board.length - 1)
            dfsfw(board, i + 1, j, p, res);
        if (j < board[0].length - 1)
            dfsfw(board, i, j + 1, p, res);
    }

    public TrieNode buildTree(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.links[i] == null) {
                    p.links[i] = new TrieNode();
                }
                p = p.links[i];
            }
            p.word = w;
        }
        return root;
    }

    // Word search I
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        // To keep track of words which are visited
        boolean[][] vis = new boolean[n][m];
        int k = 0;// for word indexing

        for (int i = 0; i < n; i++) {
            for (int j = 0; i < m; j++) {
                if (board[i][j] == word.charAt(k) && dfsSearch(board, word, i, j, k, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsSearch(char[][] board, String word, int i, int j, int k, boolean[][] vis) {
        if (word.length() == k) {
            return true;
        }
        if (i < 0 || j < 0 || i >= border.length || j >= border.length || word.charAt[k] != border[i][j] || vis[i][j]) {
            return false;
        }
        vis[i][j] = true;
        // search in all 4 directions
        // if (dfsSearch(i + 1, j, k + 1, board, word, vis) ||
        // dfsSearch(i - 1, j, k + 1, board, word, vis) ||
        // dfsSearch(i, j + 1, k + 1, board, word,vis ) ||
        // dfsSearch(i, j - 1, k + 1, board, word,vis )) {
        // return true;
        // }
        // // if word not found in the iteration make vis to false again make the path
        // followed by that dfs to value
        vis[i][j] = false;
        return false;

    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < numRows; row++) {
            int i = row;
            boolean up = true;

            while (i < s.length()) {

                sb.append(s.charAt(i));

                if (row == 0 || row == numRows - 1) {
                    i += (2 * numRows - 2);
                } else {
                    if (up) {

                    }
                }
            }

        }

        return sb.toString();
    }

    public int reverse(int x) {
        int res = 0;

        while (x != 0) {
            int tmp = x % 10;
            int newans = res * 10 + tmp;

            if ((newans - tmp) / 10 != res) {
                return 0;
            }
            x = x / 10;
        }
        return res;
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
        // while (index < n && s.charAt(index++) - '0' >= 0 && s.charAt(index++) - '0'
        // <= 9) {
        // int digit = s.charAt(index) - '0';
        // System.out.println("Digit: " + digit);
        // if (result > Integer.MAX_VALUE / 10
        // || (digit > Integer.MAX_VALUE % 10 && result == Integer.MAX_VALUE / 10)) {
        // return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        // }
        // result = result * 10 + digit;
        // System.out.println("Index end: " + index);
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

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists1(ListNode a, ListNode b) {
        ListNode tmp = new ListNode(0);
        ListNode curr = tmp;

        while (a != null && b != null) {
            if (a.val < b.val) {
                curr.next = a;
                a = a.next;
            } else {

                curr.next = b;
                b = b.next;
            }
        }

        while (b != null) {
            curr.next = b;
            b = b.next;
        }

        while (a != null) {
            curr.next = a;
            a = b.next;
        }
        return tmp.next;
    }

    // using merge sort approach
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // call for merge sort
        return mergeSortMergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeSortMergeKLists(ListNode[] lists, int start, int end) {
        // check at least it has 2 element or not
        if (start == end) {
            return lists[end];
        }
        // get mid
        int mid = start + (end - start) / 2;
        ListNode l1 = mergeSortMergeKLists(lists, start, mid);
        ListNode l2 = mergeSortMergeKLists(lists, mid + 1, end);

        return mergeKLists(l1, l2);
    }

    private ListNode mergeKLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeKLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeKLists(l1, l2.next);
            return l2;
        }
    }

    public void reorderList(ListNode head) {
        // get the mid of the LL
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // this mid element will be the element at positing slow

        // so from next of slow we want to rev the list
        ListNode prev = null;
        ListNode nextNode = slow.next; // this is like tmp=head in reversing the list
        slow.next = null; // means the last element will be the middle one from the original list
        while (nextNode != null) {
            ListNode tmp = nextNode.next;
            nextNode.next = prev;
            prev = nextNode;
            nextNode = tmp;
        }

        // merge two lists
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }

    }

    public int maxPathSum(TreeNode root) {

    }

}

class Matrix {

    // set Matrix Zeros
    static void setZerosBrute(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // assumption if matrix[i][j] > 0

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    int ind = i - 1; // upper row
                    while (i >= 0) {
                        if (matrix[ind][j] != 0) {
                            matrix[ind][j] = -1;
                        }
                        ind--;
                    }

                    ind = i + 1;
                    while (ind < row) {
                        if (matrix[ind][j] != 0) {
                            matrix[ind][j] = -1;
                        }
                        ind++;
                    }

                    ind = j - 1;
                    while (ind >= 0) {
                        if (matrix[i][ind] != 0) {
                            matrix[i][ind] = -1;
                        }
                        ind++;
                    }

                    ind = j + 1;
                    while (ind < 0) {
                        if (matrix[i][ind] != 0) {
                            matrix[i][ind] = -1;
                        }
                        ind++;
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; i < col; j++) {
                if (matrix[i][j] <= 0) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    static void setZerosBetter(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[] dummy1 = new int[row];
        int[] dummy2 = new int[col];
        Arrays.fill(dummy1, -1);
        Arrays.fill(dummy2, -1);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    dummy1[i] = 0;
                    dummy2[j] = 0;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dummy1[i] == 0 || dummy2[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    static void setZerosOptimal(int[][] matrix) {

        int col0 = 1;
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0)
                col0 = 0;
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) {
                matrix[i][0] = 0;
            }
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) {
            return ans;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m - 1;
        int top = 0;
        int bottom = n - 1;

        while (left <= right && top <= bottom) {

            // for 1st row
            // left -> right
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            // Move from top to bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            // at some point bottom is above the top to handle that
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }

    public void rotateImageBrute(int[][] matrix) {
        // create another matrix and put the row in solumn position
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] m2 = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                m2[j][n - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = m2[i][j];
            }
        }

    }

    public void rotateImageOptimal(int[][] matrix) {

        int m = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < m; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // Reverse the each row of the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][m - j - 1];
                matrix[i][m - j - 1] = tmp;
            }
        }

    }

    // Word Search
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        int k = 0;
        // for maintaining indexing of word
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(k) &&
                        searchWord(i, j, k, board, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(int i, int j, int k, char[][] board, String word, boolean[][] visited) {
        // This will be a recursive call
        // will look in top left right and bottom

        // This will be a recursive call
        // will look in top left right and bottom

        if (k == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length ||
                j >= board[i].length || word.charAt(k) != board[i][j] ||
                visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        // check four side
        // top left right and bottom

        if (searchWord(i + 1, j, k + 1, board, word, visited) ||
                searchWord(i - 1, j, k + 1, board, word, visited) ||
                searchWord(i, j + 1, k + 1, board, word, visited) ||
                searchWord(i, j - 1, k + 1, board, word, visited)) {
            return true;
        }

        // int[] drow = {-1,0,1,0};
        // int[] dcol = {0,1,0,-1};

        // for(int index = 0 ; index< 4; index++){
        // int newrow = i+ drow[index];
        // int newcol = j+dcol[index];

        // if(searchWord(newrow, newcol, k+1, board, word, visited)){
        // return true;
        // }
        // }

        visited[i][j] = false;

        return false;
    }

}

class Entry {
    public int key;
    public int value;

    public Entry(int a, int b) {
        this.key = a;
        this.value = b;
    }
}

class MyHashMap {
    // Create a Structure
    // as hashmap as array of bucket which is linked wil linked of values which
    // whill store
    // all the valus with key so to avoid collision
    // we will create a new custom class which will store the key and value based on
    // hashcode hascode
    // will be the key % size of out array
    // we will use array of linkedlist which contains custom Entry
    // Definign a Structure
    java.util.LinkedList<Entry>[] map;
    // size of the array bucket
    static int SIZE = 1000;

    public MyHashMap() {
        map = new java.util.LinkedList[SIZE];
    }

    public void put(int key, int value) {
        // getting the buckey
        int bucket = key % SIZE;
        // if the key and value is the 1st for the bucket
        if (map[bucket] == null) {
            // create new bucket and put the value into it
            // create a new entry to the bucket
            map[bucket] = new java.util.LinkedList<Entry>();
            // add that element to the bucket
            map[bucket].add(new Entry(key, value));
        } else {
            // if we have something in that bucket
            // traverse the bucket and of the key that matches the key and update its value
            // to he new one
            for (Entry entry : map[bucket]) {
                if (entry.key == key) {
                    entry.value = value;
                    return;
                }
            }
            // if the key is not present add tha new key and add to that bucket
            map[bucket].add(new Entry(key, value));
        }
    }

    public int get(int key) {
        // Search in the bucket -> buckey is the array whcih store the values
        // if found search in all the entries
        int bucket = key % SIZE; // to get the bucket number
        // Get all the entries in the bucket
        java.util.LinkedList<Entry> entrys = map[bucket];
        // if there is no bucket with the key
        if (entrys == null) {
            return -1;
        }
        // if there are entries iterate and return the value
        for (Entry ent : entrys) {
            if (ent.key == key) {
                return ent.value;
            }
        }
        // if there is a bucket but the key is not present then return
        return -1;

    }

    public void remove(int key) {
        int bucket = key % SIZE;
        Entry toRemove = null;
        // if bucket is not present
        if (map[bucket] == null) {
            return;
        } else {
            // if there is iterate and store that value to the tmp entry
            for (Entry entry : map[bucket]) {
                if (entry.key == key) {
                    toRemove = entry;
                }
            }
            // if the tmp entry is null
            if (toRemove == null) {
                return;
            }
            // remove that node
            map[bucket].remove(toRemove);
        }
    }
}

class Strings {

    // 3. Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstringBrute(String s) {
        return 2;
    }

    public int lengthOfLongestSubstringBetter(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        int right = 0;
        int n = s.length();

        while (right < n) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return max;
    }

    public int lengthOfLongestSubstringOptimal(String s) {
        // store character and index
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        int right = 0;
        int n = s.length();

        while (right < n) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public int characterReplacement(String s, int k) {

        int N = s.length();
        int[] char_count = new int[26];

        int window_start = 0;
        int max_length = 0;
        int max_count = 0;

        for (int window_end = 0; window_end < N; window_end++) {
            char_count[s.charAt(window_end) - 'A']++;

            int current_char_count = char_count[s.charAt(window_end) - 'A'];
            max_count = Math.max(max_count, current_char_count);

            // while windows size is maintaind and it is les then k which means we can
            // chnage that many element to get the max size
            while (window_end - window_start - max_count + 1 > k) {
                char_count[s.charAt(window_start) - 'A']--;
                window_start++;
            }
            max_length = Math.max(max_length, window_end - window_start + 1);
        }

        return max_length;
    }



public class CP1 {
    // CP Questions
    public static void main(String[] args) {
        // Strings str = new Strings();
        // System.out.println(str.lcsPrint("abcde", "bdgek"));
    }

}
