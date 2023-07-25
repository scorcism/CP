import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class BSQuestions {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findKthNumber(2, 3, 6));
    }
}

class Solution {

    

    // 1870. Minimum Speed to Arrive on Time
    public int minSpeedOnTime(int[] dist, double hour) {
        int start = 1;
        int end = (int) 1e7;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (isPossibleSpeed(mid, dist, hour)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start <= (int) 1e7 ? start : -1;
    }

    private boolean isPossibleSpeed(int mid, int[] dist, double hour) {
        double countHours = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            countHours += (double) Math.ceil(dist[i] / (double) mid);

        }
        countHours += (double) (dist[dist.length - 1] / mid);
        return countHours <= hour;
    }

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
