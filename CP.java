import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
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
}

public class CP {
    // CP Questions
    public static void main(String[] args) {

    }

}
