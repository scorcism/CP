import java.util.Arrays;

public class BSQuestions {

    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}

class Solution {
    // 2187. Minimum Time to Complete Trips
    public long minimumTime(int[] time, int totalTrips) {
        long start = 1;
        int maxTime = 0;
        int minLeft = 0;
        for (int t : time) {
            maxTime = Math.max(maxTime, t);
            minLeft = Math.min(minLeft, t);
        }
        start = minLeft;
        long end = (long) maxTime * totalTrips;

        while (start <= end) {
            long mid = start + ((end - start) >> 1);
            if (isPossibleTripTime(time, totalTrips, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean isPossibleTripTime(int[] time, int totalTrips, long mid) {
        long countTime = 0;
        for (int t : time) {
            countTime += mid / t;
        }
        return countTime >= totalTrips;
    }
}
