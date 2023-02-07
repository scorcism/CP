import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.swing.border.Border;

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
            if (it[0] <= end) {
                // merge
                end = Math.max(end, it[1]);
            } else {
                // put start and new end to the res
                res.add(new int[] { start, end });
                start = it[0];
                end = it[1];
            }
        }
        // put last one into the res
        res.add(new int[] { start, end });

        return res.toArray(new int[0][]);
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

class General {

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
        //     int newrow = i+ drow[index];
        //     int newcol = j+dcol[index];

        //     if(searchWord(newrow, newcol, k+1, board, word, visited)){
        //         return true;
        //     }
        // }

        visited[i][j] = false;

        return false;
    }

}

class Strings {

    // 3. Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstringBrute(String s) {
        

    }
    public int lengthOfLongestSubstringBetter(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        int right = 0;
        int n = s.length();

        while(right < n){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                max = Math.max(max,set.size() );
            }else{
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
        int left=  0;
        int right = 0;
        int n = s.length();

        while(right < n){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right))+1, left);
            }
            map.put(s.charAt(right), right);
            max=  Math.max(max, right - left +1);
            right ++;
        }
        return max;
    }

    public int characterReplacement(String s, int k) {
        
        int N = s.length();
        int[] char_count = new int[26];

        int window_start  = 0;
        int max_length = 0;
        int max_count = 0;

        for(int window_end=  0; window_end < N ; window_end++){
            char_count[s.charAt(window_end) - 'A']++;

            int current_char_count = char_count[s.charAt(window_end) - 'A'];
            max_count = Math.max(max_count, current_char_count);

            // while windows size is maintaind and it is les then k which means we can chnage that many element to get the max size
            while(window_end - window_start - max_count +1 > k){
                char_count[s.charAt(window_start) - 'A']--;
                window_start++;
            } 
            max_length = Math.max(max_length, window_end - window_start +1);
        }

        return max_length;
    }

    // 76. Minimum Window Substring
    public String minWindow(String s, String t) {
        int slength = s.length();
        int tlength = t.length();

        if(slength == 0 || tlength == 0 || tlength> slength){
            return "";
        }

        int start = 0;
        int end = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int count= 0;

        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) +1);
        }   

        count = map.size();

        int maxStart = 0;
        int maxEnd = 0;
        int maxlenWindow = Integer.MAX_VALUE; // size of window initialy 
        while(end < slength){
            char charAtEnd = s.charAt(end);

            if(map.containsKey(charAtEnd)){
                map.put(charAtEnd, map.get(charAtEnd) -1);

                if(map.get(charAtEnd) == 0){
                    count--;
                }
            }
            while(count == 0){
                // achieve the window size
                if(maxlenWindow > end - start +1){
                    maxlenWindow = end - start +1;
                    maxStart = start;
                    maxEnd = end + 1;
                }
                
                char charAtStart = s.charAt(start);

                if(map.containsKey(charAtStart)){
                    map.put(charAtStart, map.get(charAtStart) +1);

                    if(map.get(charAtEnd) == 1){
                        count++;
                    }
                }
                start++;
            }
            end++;
        }

        return s.substring(maxStart, maxEnd);
    }



    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length() == 0 || s == null){
            return result;
        }

        /*  Like a Sliding windows
            With 2 pointer approach
            and maintaining hashmap
         */
        int start = 0;
        int end = 0;
        
        int[] count_chars = new int[26];

        for(char c: p.toCharArray()){
            count_chars[c - 'a']++;
        }

        int count = p.length();

       while(end < s.length()){
            if(count_chars[s.charAt(end++) -'a']-- >= 1){
                count--;

            }
            if(count == 0){
                result.add(start);
            }

            if(end - start == p.length() &&
                count_chars[s.charAt(start++) -'a']++ >= 0
            ){
                count++;
            }
       }

        return result;
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }   

        int[] char_count = new int[26]; // coz max 26 can only be there
        for(int i = 0; i< s.length(); i++){
            char_count[s.charAt(i)]++;
            char_count[t.charAt(i)]--;
        }

        for(int i: char_count){
            if(i != 0){
                return false;
            }
        }

        return true;
    }
}

public class CP {
    // CP Questions
    public static void main(String[] args) {

    }

}
