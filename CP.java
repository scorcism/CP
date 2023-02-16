import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;
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

    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();

        for(int row = 0; row < numRows; row++){
            int i = row;
            boolean up = true;

            while(i < s.length()){

                sb.append(s.charAt(i));

                if(row == 0 || row == numRows-1){
                    i += (2 * numRows - 2);
                }else {
                    if(up){
                        
                    }
                }
            }

        }

        return sb.toString();
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

    // 76. Minimum Window Substring
    public String minWindow(String s, String t) {
        int slength = s.length();
        int tlength = t.length();

        if (slength == 0 || tlength == 0 || tlength > slength) {
            return "";
        }

        int start = 0;
        int end = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        count = map.size();

        int maxStart = 0;
        int maxEnd = 0;
        int maxlenWindow = Integer.MAX_VALUE; // size of window initialy
        while (end < slength) {
            char charAtEnd = s.charAt(end);

            if (map.containsKey(charAtEnd)) {
                map.put(charAtEnd, map.get(charAtEnd) - 1);

                if (map.get(charAtEnd) == 0) {
                    count--;
                }
            }
            while (count == 0) {
                // achieve the window size
                if (maxlenWindow > end - start + 1) {
                    maxlenWindow = end - start + 1;
                    maxStart = start;
                    maxEnd = end + 1;
                }

                char charAtStart = s.charAt(start);

                if (map.containsKey(charAtStart)) {
                    map.put(charAtStart, map.get(charAtStart) + 1);

                    if (map.get(charAtEnd) == 1) {
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
        if (s.length() == 0 || s == null) {
            return result;
        }

        /*
         * Like a Sliding windows
         * With 2 pointer approach
         * and maintaining hashmap
         */
        int start = 0;
        int end = 0;

        int[] count_chars = new int[26];

        for (char c : p.toCharArray()) {
            count_chars[c - 'a']++;
        }

        int count = p.length();

        while (end < s.length()) {
            if (count_chars[s.charAt(end++) - 'a']-- >= 1) {
                count--;

            }
            if (count == 0) {
                result.add(start);
            }

            if (end - start == p.length() &&
                    count_chars[s.charAt(start++) - 'a']++ >= 0) {
                count++;
            }
        }

        return result;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] char_count = new int[26]; // coz max 26 can only be there
        for (int i = 0; i < s.length(); i++) {
            char_count[s.charAt(i)]++;
            char_count[t.charAt(i)]--;
        }

        for (int i : char_count) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public int totalFruitMap(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int j;
        for (j = 0; j < fruits.length; j++) {
            map.put(fruits[j], map.getOrDefault(fruits[i], 0) + 1);

            if (map.size() > 2) {
                map.put(fruits[i], map.getOrDefault(fruits[i], 0) - 1);
                map.remove(fruits[i], 0);
            }
        }

        return j - i;
    }

    // 20. Valid Parentheses
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (isOpening(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (!isMathing(c, stack.peek())) {
                    return false;
                } else {
                    stack.pop();
                }

            }
        }
        return stack.isEmpty();

    }

    private boolean isMathing(char a, Character b) {
        return (a == '(' && b == ')' || a == '[' && b == ']' || a == '{' && b == '}');
    }

    private boolean isOpening(char a) {
        return (a == '(' || a == '[' || a == '{');
    }

    public int jump(int[] nums) {
        int n = nums.length - 1;
        int maxRechableInRange = 0;
        int currEnd = 0;
        int jumps = 0;

        for (int i = 0; i < n; i++) {
            maxRechableInRange = Math.max(maxRechableInRange, i + nums[i]);
            if (i == currEnd) {
                currEnd = maxRechableInRange;
                jumps++;
            }
        }

        return jumps;

    }

    public List<List<String>> groupAnagrams(String[] strings) {
        Map<String, LinkedList<String>> map = new HashMap<>();

        for (String s : strings) {
            // convert this to array
            char charArray[] = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);

            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new LinkedList<String>());
            }
            map.get(sortedString).add(s);

        }

        return new LinkedList<>(map.values());
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAround(s, i, i);
            int len2 = expandAround(s, i, i + 1);
            int maxLen = Math.max(len1, len2);
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                // "racecar" suppose i is at e
                // 7 coz from e there are 3 in left and 3 in right
                // so start will be i(3) - (7-1)/2 = 0th index
                // (7-1)/2 is used to manage array exceptions
                // we have to move start to the left od i by the max length
                end = i + (maxLen) / 2;
                /*
                 * tart is calculated as (len-1)/2 to take care of both the possibilities. ie.
                 * palindrome substring being of 'even' or 'odd' length. Let me explain.
                 * e.g.
                 * Case-1 : When palindrome substring is of 'odd' length.
                 * e.g. racecar. This palindrome is of length 7 ( odd ). Here if you see the
                 * mid, it is letter 'e'.
                 * Around this mid 'e', you will see start ('r') and end ('r') are 'equidistant'
                 * from 'e'.
                 * Lets assume this 'racecar' is present in our string under test-> 'aracecard'
                 * Now, index of e is '4' in this example.
                 * if you calculate start as i - (len-1)/2 or i - len/2, there would not be any
                 * difference as len being 'odd' would lead to (len -1)/2 and (len/2) being
                 * same. lets use start = i - (len-1)/2, and end = i + (len/2) in this case.
                 * start = 4 - (6/2) , end = 4 + (7/2)
                 * start = 4-3, end = 4+3
                 * start =1, end = 7
                 * s.substring(1, 7+1) = 'racecar'
                 * 
                 * Case-2: When palindrome substring is of 'even' length
                 * e.g. abba
                 * Lets see this case. Lets assume given string under test is-> 'eabbad'
                 * In this case, your i is going to be 2. ( This is most critical part )
                 * With the given solution by Nick, you would found this palindrome with
                 * int len2 = expandFromMiddle(s, i, i+1)
                 * Now if you look at this method, your left which starts with 'i' is always
                 * being compared with right which starts with i+1
                 * That would be the case here with 'eabbad'. When i is 2 ie. 'b' . Then your
                 * left will be 2 (b) and right will be 2+1 ( b) and the comparison will
                 * proceed.
                 * In this case, once you have found 'abba' then it being 'even' the index 'i'
                 * would fall in your 'first half' of the palindrome. ab | ba
                 * if you calculate start as start = i - (len/2) , it would be wrong!! because
                 * your i is not in the mid of palindrome.
                 * lets still try with this formula start = i - len/2
                 * start = 2 - (4/2) // i =2, len = 4 ( abba)
                 * start = 2 -2 =0 ( wrong!)
                 * end = i + (len/2)
                 * end = 2 + 2 = 4
                 * s.substring( 0, 4+1) // ''eabba' --> wrong solution!!!
                 * Here start should have been 1
                 * lets recalculate start as-
                 * start = i - (len-1)/2
                 * start = 2 - (4-1)/2
                 * start = 2- 3/2
                 * start = 2 -1 = 1
                 * s.substring(1, 4+1) // 'abba' --> correct solution
                 */
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAround(String s, int left, int right) {
        if (left > right || s.length() < 1) {
            return 0;
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;

        }

        return right - left - 1;
        /*
         * Providing R - L - 1 explanation:
         * e.g. racecar (length = 7. Simple math to calculate this would be R - L + 1 (
         * where L= 0 , R=6 )), considering start index is '0'.
         * Now, in this example ( 'racecar' ) when loop goes into final iteration, that
         * time we have just hit L =0, R =6 (ie. length -1)
         * but before exiting the loop, we are also decrementing L by L - - , and
         * incrementing R by R ++ for the final time, which will make L and R as ( L =
         * -1, R = 7 )
         * Now, after exiting the loop, if you apply the same formula for length
         * calculation as 'R - L +1', it would return you 7 -( - 1 )+1 = 9 which is
         * wrong, but point to note is it gives you length increased by 2 units than the
         * correct length which is 7.
         * So the correct calculation of length would be when you adjust your R and L .
         * to do that you would need to decrease R by 1 unit as it was increased by 1
         * unit before exiting the loop , and increase L by 1 unit as it was decreased
         * by 1 unit just before exiting the loop.
         * lets calculate the length with adjusted R and L
         * ( R -1 ) - ( L +1 ) + 1
         * R -1 - L -1 + 1
         * R -L -2 + 1
         * R - L -1
         */
    }

    // 2306. Naming a Company
    public long distinctNames(String[] ideas) {
        HashSet<String>[] initialGroup = new HashSet[26];

        for (int i = 0; i < 26; i++) {
            initialGroup[i] = new HashSet<>();
        }
        for (String s : ideas) {
            initialGroup[s.charAt(0) - 'a'].add(s.substring(1));
        }

        // calculate no. of valid names from even pair of groups
        long ans = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {

                long numOfMutual = 0;
                for (String s : initialGroup[i]) {
                    if (initialGroup[j].contains(s)) {
                        numOfMutual = numOfMutual + 1;
                    }
                }

                ans += 2 * (initialGroup[i].size() - numOfMutual) * (initialGroup[i].size() - numOfMutual);
            }
        }
        return ans;
    }

    static int lcs(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1][len2];

        return lcsMemo(s1, s2, len1 - 1, len2 - 1, dp);

    }

    private static int lcsMemo(String s1, String s2, int ind1, int ind2, int[][] dp) {
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }
        if (dp[ind1][ind2] != 0) {
            return dp[ind1][ind2];
        }
        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + lcsMemo(s1, s2, ind1 - 1, ind2 - 1, dp);
        }
        return dp[ind1][ind2] = Math.max(lcsMemo(s1, s2, ind1 - 1, ind2, dp), lcsMemo(s1, s2, ind1, ind2 - 1, dp));
    }

    private static int lcsTabu(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // base case
        // Here we will shift the index
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    // Print lcs
    public static String lcsPrint(String s1, String s2) {
        String res = "";

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        for (int[] a : dp) {
            System.out.println(Arrays.toString(a));
        }

        // for moving backwards

        int len = dp[n][m];
        for (int i = 0; i < len; i++) {
            res += '$';
        }

        int i = n;
        int j = m;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                // res.charAt(len - 1) = s1.charAt(i - 1);
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return res;
    }

    public int longestPalindromeCount(String s) {

        int[] char_counts = new int[128];

        for (char c : s.toCharArray()) {
            char_counts[c]++;
        }

        int result = 0;
        for (int i : char_counts) {
            result += i / 2 * 2;
            if (result % 2 == 0 && i % 2 == 1) {
                result += 1;
            }
        }
        return result;
    }

    private int countSubstringsUtil(String s, int left, int right) {
        int res = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            res++;
            left--;
            right++;
        }
        return res;
    }

    public int countSubstrings(String s) {

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            ans += countSubstringsUtil(s, i, i);
            ans += countSubstringsUtil(s, i, i + 1);

        }
        return ans;

    }

    /*
     * @param strs: a list of strings
     * 
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        String res = "";
        int s = strs.size();
        for (int i = 0; i < s; i++) {
            String currWord = strs.get(i);
            int currWordLen = currWord.length();
            String newToAdd = String.valueOf(currWordLen) + "$" + currWord;
        }
        return res;
    }

    /*
     * @param str: A string
     * 
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        List<String> list = new ArrayList<String>();

        int n = str.length();
        int i = 0;
        while (i < n) {
            int j = i;
            while (str.charAt(j) != '$') {
                j++;
            }
            int nextwordLen = Integer.parseInt(str.substring(i, j));
            String nextWord = str.substring(j + 1, j + 1 + nextwordLen);
            list.add(nextWord);
            i = j + 1 + nextwordLen;
        }
        return list;
    }

}

class trees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    public TreeNode invertTree(TreeNode root) {

        invert(root);
        return root;
    }

    void invert(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        invertTree(root.left);
        invertTree(root.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        if (issameSubtree(root, subRoot)) {
            return true;
        }

        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    private boolean issameSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        if (root.val != subRoot.val) {
            return false;
        }

        return ((issameSubtree(root.left, subRoot.left)) && (issameSubtree(root.right, subRoot.right)));

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        levelOrderHelper(root, ans, 0);
        return ans;
    }

    private void levelOrderHelper(TreeNode root, List<List<Integer>> ans, int level) {
        if (root == null) {
            return;
        }
        // if new level doesnt conatain ist for this level
        if (level >= ans.size()) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.val);
        levelOrderHelper(root.left, ans, level + 1);
        levelOrderHelper(root.right, ans, level + 1);
    }

    // 105. Construct Binary Tree from Preorder and Inorder Traversal
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeUtil(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);

    }

    private TreeNode buildTreeUtil(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> map) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        // get index of the root element from the inorder
        int indexOfRoot = map.get(root.val);
        // find all the element in the left
        int leftEles = indexOfRoot - inStart;

        root.left = buildTreeUtil(preorder, preStart + 1, preEnd + leftEles, inorder, inStart, indexOfRoot - 1, map);
        root.right = buildTreeUtil(preorder, preStart + leftEles + 1, preEnd, inorder, indexOfRoot + 1, inEnd, map);

        return root;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBSTUtil(TreeNode root, int minValue, int maxValue) {

        if (root.val < minValue || root.val > maxValue) {
            return false;
        }

        return ((isValidBSTUtil(root.left, minValue, root.val)) && (isValidBSTUtil(root.right, root.val, maxValue)));
    }

    // 230. Kth Smallest Element in a BST
    // brute
    public int kthSmallestBrute(TreeNode root, int k) {
        // Get the in order traversal
        // return the ktn from the list
        ArrayList<Integer> ans = inorderkthsmallest(root, new ArrayList<Integer>());
        return ans.get(k);

    }

    private ArrayList<Integer> inorderkthsmallest(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return list;
        }
        inorderkthsmallest(root.left, list);
        list.add(root.val);
        inorderkthsmallest(root.right, list);
        return list;
    }

    public int kthSmallestOptimal(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }

    }

}

class easy {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return "";
        }
        // sorting it so that all the strings will be according to the size or the
        // matching characters.
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        int countSameCharacterInBoth = 0;

        while (countSameCharacterInBoth < first.length()) {
            if (first.charAt(countSameCharacterInBoth) == last.charAt(countSameCharacterInBoth)) {
                countSameCharacterInBoth++;
            } else {
                break;
            }
        }
        return (countSameCharacterInBoth == 0 ? "" : first.substring(0, countSameCharacterInBoth));

    }

    public int mySqrt(int x) {

        // y = underoot of x
        // y squre = x
        // we can get the floor one so
        // y sqare less then or eqal to x

        /*
         * long y = 0;
         * while(y * y <= x){
         * y++;
         * }
         * 
         * return (int)y-1;
         */
        // to make it more optiomised insted of linear search we can use binary search
        long start = 0;
        long end = Integer.MAX_VALUE;
        long ans = 0;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return (int) ans;
    }

}

class WDNode {
    WDNode[] links = new WDNode[26];
    boolean flag = false;

    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    void put(char ch, WDNode node) {
        links[ch - 'a'] = node;
    }

    WDNode get(char ch) {
        return links[ch - 'a'];
    }

    void setEnd() {
        flag = true;
    }

    boolean isWord() {
        return flag;
    }
}

class WordDictionary {

    // Create new root
    private static WDNode root;

    public WordDictionary() {
        root = new WDNode();
    }

    public void addWord(String word) {
        // Create tmp node for iteration
        WDNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                // if not already presnet put the current char to the node
                node.put(word.charAt(i), new WDNode());
            }
            // after puting the char to the new node
            // move towards the that node
            node.get(word.charAt(i));
        }
        // set the last ref trie flag to true means word end
        node.setEnd();
    }

    // Return word if present, . means any word can be there
    public boolean search(String word) {
        return matchS(word, 0, root);
    }

    private boolean matchS(String word, int pos, WDNode root) {
        WDNode node = root;

        if (word.charAt(pos) == '.') {
            boolean res = false;
            for (int i = 0; i < 26; ++i) {
                // if we are at the last position
                if (pos == word.length() - 1 && node.links[i] != null) {
                    node = node.links[i];
                    res |= node.isWord();

                    // If we are in betwwen
                } else if (node.links[i] != null && matchS(word, pos + 1, root)) {
                    return true;
                }
                return res;
            }

            // if the child exists
        } else if (node.links[word.charAt(pos) - 'a'] != null) {
            if (pos == word.length() - 1) {
                node = node.links[word.charAt(pos) - 'a'];
                return node.isWord();
            }
            return matchS(word, pos + 1, root);
        }
        return false;
    }

}

class LinkedList {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode tmp = ans;
        int carry = 0;
        ListNode l1p = l1;
        ListNode l2p = l2;
        while (l1p != null || l2p != null || carry != 0) {
            int sum = 0;
            if (l1p != null) {
                sum = sum + l1p.val;
                l1p = l1p.next;
            }
            if (l2p != null) {
                sum = sum + l2p.val;
                l2p = l2p.next;
            }
            sum = sum + carry;
            ListNode temp = new ListNode(sum % 10);
            carry = sum / 10;
            tmp.next = temp;
            tmp = tmp.next;

        }
        return ans.next;
    }
}

public class CP {
    // CP Questions
    public static void main(String[] args) {
        // Strings str = new Strings();
        // System.out.println(str.lcsPrint("abcde", "bdgek"));
    }

}
