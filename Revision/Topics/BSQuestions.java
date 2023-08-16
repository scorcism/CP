import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class BSQuestions {

    public static void main(String[] args) {
        Solution sol = new Solution();
        
    }
}

class Solution {

    public int smallestDivisor(int[] nums, int threshold) {
        int start = 0;
        int end = Integer.MAX_VALUE;
        int ans = 0;

        while(start <= end){
            int mid = start + ((end - start) >> 1);
            if(sDPredicate(nums, mid, threshold)){
                end = mid -1;
                ans = mid;
            }else{
                start = mid+1;
            }
        }

        return ans;
    }   

    public boolean sDPredicate(int[] nums, int mid, int thres){
        int sum = 0;

        for(int n: nums){
            sum+= Math.ceil(((double)n/ (double)mid));
        }
        return sum <= thres;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) {
            return -1;
        }

        int start = 1;
        int end = 0;
        int ans = 0;
        for (int p : bloomDay) {
            end = Math.max(p, end);
        }
        while (start <= end) {
            int mid = start + ((end - start) >> 1);

            if (minDayPredicate(bloomDay, mid, m, k)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static boolean minDayPredicate(int[] nums, int mid, int m, int k) {
        int req = 0;
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] <= mid) {
                counter++;
            } else {
                req += counter / k;
                counter = 0;
            }
        }
        req += counter / k;
        return req >= m;
    }

    // EKO
    public static int ekoSpoj(int[] nums, int n, int m) {
        int start = 1;
        int end = 0;
        int ans = 0;

        for (int p : nums) {
            end = Math.max(end, p);
        }

        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (ekoPredicateFnc(nums, mid, m)) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static boolean ekoPredicateFnc(int[] nums, int mid, int req) {
        int sum = 0;

        for (int n : nums) {
            if (n - mid > 0) {
                sum += n - mid;
            }
        }
        return sum >= req;
    }

    // PRATA - Roti Prata
    public static int rotiPrata(int[] nums, int p) {
        int ans = 0;
        int start = 1;
        int end = (int) (1e8);

        while (start <= end) {
            int mid = start + ((end - start) >> 1);

            if (isPossiblePrata(nums, mid, p)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isPossiblePrata(int[] nums, int mid, int p) {
        int count = 0; // count total prathas

        for (int i = 0; i < nums.length; i++) {

            int perchef = nums[i]; // time taken to cook prathas
            int time = mid; // time stamp

            while (time > 0) {
                time -= perchef;

                if (time >= 0) {
                    count++;
                    perchef += nums[i];
                }
            }
        }
        return count >= p;
    }

    // AGGRCOW
    public static int aggrcow(int[] A, int n, int c) {
        int ans = 0;
        Arrays.sort(A);
        int start = 0;
        int end = 0;

        for (int p : A) {
            start = Math.min(start, p);
            end = Math.max(end, p);
        }

        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (isPossibleCow(A, mid, c)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    static boolean isPossibleCow(int[] nums, int mid, int c) {
        int cowCount = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] <= mid) {
                cowCount++;
            }
            if (cowCount >= c) {
                return true;
            }
        }
        return false;
    }

    // Allocate minimum number of pages
    public static int findPages(int[] A, int N, int M) {
        if (A.length < M) {
            return -1;
        }

        int start = 0;
        int ans = -1;
        int end = 0;

        for (int n : A) {
            end += n;
            start = Math.max(n, start);
        }

        while (start <= end) {
            int mid = start + ((end - start) >> 1);

            if (isPossibleStudent(A, mid, M)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    // Predicate function
    public static boolean isPossibleStudent(int[] nums, int mid, int m) {
        int countStudent = 1;
        int sum = 0;
        for (int n : nums) {
            sum += n;
            if (sum > mid) {
                sum = n;
                countStudent++;
            }
            if (countStudent > m) {
                return false;
            }
        }
        return true;
    }

    // 668. Kth Smallest Number in Multiplication Table
    public int findKthNumber2(int m, int n, int k) {

        int start = 1;
        int end = m * n;
        int ans = 0;

        while (start <= end) {
            int mid = start + ((end - start) >> 1);

            if (isPossibleKth(m, n, k, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossibleKth(int m, int n, int k, int mid) {
        int count = 0;

        for (int i = 1; i <= m; i++) {
            count += Math.min(mid / i, n);
        }

        return count >= k;
    }

    public int findKthNumber(int m, int n, int k) {
        PriorityQueue<Integer> numbers = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int num = i * j;
                numbers.add(num);
                if (numbers.size() > k) {
                    numbers.poll();
                }
            }
        }
        return numbers.peek();
    }

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
